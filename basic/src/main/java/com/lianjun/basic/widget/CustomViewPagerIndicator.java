package com.lianjun.basic.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.lianjun.basic.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/5/30.
 */
public class CustomViewPagerIndicator extends LinearLayout {

    private Paint mPaint;
    private Path mPath;
    private int mTriangleWidth, mTriangleHeight;
    private static final float RADIO_TRIANGLE_WIDTH = 1 / 4F;
    private int mInitTranslationX, mTranslationX;
    private int mTabVisibleCount;
    private static final int COUNT_DEFAULT_TAB = 4;
    public List<String> mTitles = new ArrayList<>();
    private int COLOR_TEXT_NORMAL = R.color.black;
    private int COLOR_TEXT_HIGHLIGHT = R.color.orange;
    public OnPageChangeListener mListener;
    /**
     * 三角形的底边的最大宽度
     */
    private final int DIMENSION_TRIANGLE_WIDTH_MAX = (int) (getScreenWidth() / 3 * RADIO_TRIANGLE_WIDTH);
    private boolean isDrawLine = true;

    public void setDrawLine(boolean drawLine) {
        isDrawLine = drawLine;
    }

    public CustomViewPagerIndicator(Context context) {
        this(context, null);
    }

    public CustomViewPagerIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取可见tab的数量
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CustomViewPagerIndicator);
        mTabVisibleCount = typedArray.getInt(R.styleable.CustomViewPagerIndicator_visible_tab_count, COUNT_DEFAULT_TAB);
        if (mTabVisibleCount < 0) {
            mTabVisibleCount = COUNT_DEFAULT_TAB;
        }
        typedArray.recycle();


        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setColor(getResources().getColor(COLOR_TEXT_HIGHLIGHT));
        mPaint.setStyle(Paint.Style.FILL);
//        mPaint.setPathEffect(new CornerPathEffect(3));
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mTriangleWidth = (int) (w / mTabVisibleCount * RADIO_TRIANGLE_WIDTH);
        mTriangleWidth = Math.min(mTriangleWidth, DIMENSION_TRIANGLE_WIDTH_MAX);

//        mInitTranslationX = w / mTabVisibleCount / 2 - mTriangleWidth / 2;
        mInitTranslationX = 0;
        initTriangle();
    }

    int rectangleHeight;

    private void initTriangle() {
        mTriangleHeight = mTriangleWidth / 2;
        mPath = new Path();
        mPath.moveTo(0, 0);
//        mPath.lineTo(mTriangleWidth, 0);
//        mPath.lineTo(mTriangleWidth / 2, -mTriangleHeight);

        rectangleHeight = getHeight() / 10;
        mPath.lineTo(getWidth() / mTabVisibleCount, 0);
        mPath.lineTo(getWidth() / mTabVisibleCount, -rectangleHeight);
        mPath.lineTo(0, -rectangleHeight);
        mPath.close();

    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        if (isDrawLine) {
            canvas.save();
//        canvas.translate(mInitTranslationX + mTranslationX, getHeight() + 2);
            canvas.translate(mInitTranslationX + mTranslationX, getHeight());
            canvas.drawPath(mPath, mPaint);
            canvas.restore();
        }
        super.dispatchDraw(canvas);
    }

    /**
     * 指示器跟随手指滚动
     *
     * @param position
     * @param offset
     */
    public void scroll(int position, float offset) {
        int tabWidth = getWidth() / mTabVisibleCount;
        mTranslationX = (int) (tabWidth * offset + tabWidth * position);

        //容器移动
        if (position >= mTabVisibleCount - 2 && offset > 0 && getChildCount() > mTabVisibleCount) {
            if (mTabVisibleCount != 1) {
                this.scrollTo((int) ((position - (mTabVisibleCount - 2)) * tabWidth + tabWidth * offset), 0);
            } else {
                this.scrollTo((int) (position * tabWidth + tabWidth * offset), 0);
            }
        }


        invalidate();
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        int cCount = getChildCount();
        if (cCount == 0) {
            return;
        }
        for (int i = 0; i < cCount; i++) {
            View view = getChildAt(i);
            LayoutParams params = (LayoutParams) view.getLayoutParams();
            params.weight = 0;
            params.width = getScreenWidth() / mTabVisibleCount;
            view.setLayoutParams(params);
        }
        setItemClickEvent();
    }

    private int getScreenWidth() {
        WindowManager wm = (WindowManager) getContext().getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics metrics = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(metrics);
        return metrics.widthPixels;
    }

    public void setTabItemTitles() {
        PagerAdapter adapter = mViewPager.getAdapter();
        mTitles.clear();
        for (int i = 0; i < adapter.getCount(); i++) {
            mTitles.add((String) adapter.getPageTitle(i));
        }
        if (mTitles.size() > 0) {
            this.removeAllViews();
            for (String title : mTitles) {
                addView(generateTextView(title));
            }
            setItemClickEvent();
        }

    }

    /**
     * 根据title创建tab
     *
     * @param title
     * @return
     */
    private View generateTextView(String title) {
        TextView textView = new TextView(getContext());
        LayoutParams params = new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        params.width = getScreenWidth() / mTabVisibleCount;
        textView.setGravity(Gravity.CENTER);
        textView.setText(title);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 16);
//        textView.setTextColor(COLOR_TEXT_NORMAL);
        textView.setLayoutParams(params);
        return textView;
    }

    public void setTabVisibleCount(int count) {
        mTabVisibleCount = count;
    }

    private ViewPager mViewPager;

    /**
     * 设置关联的ViewPager
     *
     * @param viewPager
     * @param pos
     */
    public void setViewPager(ViewPager viewPager, int pos) {
        this.mViewPager = viewPager;
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                scroll(position, positionOffset);
                if (mListener != null) {
                    mListener.onPageScrolled(position, positionOffset, positionOffsetPixels);
                }
            }

            @Override
            public void onPageSelected(int position) {
                if (mListener != null) {
                    mListener.onPageSelected(position);
                }
                hightLightTextView(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                if (mListener != null) {
                    mListener.onPageScrollStateChanged(state);
                }
            }
        });
        setTabItemTitles();
        mViewPager.setCurrentItem(pos);
        hightLightTextView(pos);
    }

    public void setTextViewSelectedColor(int textViewSelectedColor) {
        this.COLOR_TEXT_HIGHLIGHT = textViewSelectedColor;
    }

    public interface OnPageChangeListener {

        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels);

        public void onPageSelected(int position);

        public void onPageScrollStateChanged(int state);

    }


    public void setOnPageChagneListener(OnPageChangeListener listener) {
        this.mListener = listener;
    }

    /**
     * 高亮某个tab的文本
     *
     * @param pos
     */
    private void hightLightTextView(int pos) {
        resetTextViewColor();
        if (mTextViewColors != null) {
            return;
        }
        View view = getChildAt(pos);
        if (view instanceof TextView) {
            ((TextView) view).setTextColor(getResources().getColor(COLOR_TEXT_HIGHLIGHT));
        }
    }

    private int[] mTextViewColors;
    public void setTextViewColors(int[] colors){
        this.mTextViewColors = colors;
    }

    /**
     * 重置tab文本颜色
     */
    private void resetTextViewColor() {
        for (int i = 0; i < getChildCount(); i++) {
            View view = getChildAt(i);
            if (view instanceof TextView) {
                if (mTextViewColors != null) {
                    ((TextView) view).setTextColor(getResources().getColor(mTextViewColors[i]));
                }else{
                    ((TextView) view).setTextColor(getResources().getColor(COLOR_TEXT_NORMAL));
                }
            }
        }
    }

    /**
     * 设置tab的点击事件
     */
    private void setItemClickEvent() {
        int count = getChildCount();
        for (int i = 0; i < count; i++) {
            final int j = i;
            View view = getChildAt(i);
            view.setOnClickListener(new OnClickListener() {
                @Override
                public void onClick(View v) {
                    mViewPager.setCurrentItem(j);
                }
            });
        }
    }
}