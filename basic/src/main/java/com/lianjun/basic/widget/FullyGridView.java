package com.lianjun.basic.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by changgc on 2015/4/20.
 */
public class FullyGridView extends GridView {

    public FullyGridView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FullyGridView(Context context) {
        super(context);
    }

    public FullyGridView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(
                Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}
