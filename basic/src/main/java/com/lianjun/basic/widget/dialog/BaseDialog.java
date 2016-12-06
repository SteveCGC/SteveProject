package com.lianjun.basic.widget.dialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Display;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;

import com.lianjun.basic.R;


/**
 * <类描述>
 * 作者： Administrator
 * 时间： 2016/1/5
 */
public class BaseDialog extends Dialog{

    public BaseDialog(Context context) {
        super(context, R.style.dialog_bg_transparency);
    }

    private void initDialog(){
        setCanceledOnTouchOutside(true);
        Window window = getWindow();
        WindowManager windowManager = window.getWindowManager();
        Display display = windowManager.getDefaultDisplay();
        WindowManager.LayoutParams params = window.getAttributes();
        window.setGravity(Gravity.BOTTOM);
        params.width = (int) (display.getWidth());
        window.setAttributes(params);
        window.setWindowAnimations(R.style.photo_albums_style);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initDialog();
    }
}
