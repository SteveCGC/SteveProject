package com.lianjun.basic.utils;

import android.content.Context;
import android.widget.Toast;

import com.lianjun.basic.R;

/**
 * Created by Administrator on 2016/5/26.
 */
public class ToastUtil {
    public static void showToast(Context context,String str) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }

    public static void showCheckNetWarning(Context context) {
        if (context!=null){
            Toast.makeText(context, R.string.net_error_check_network_warning, Toast.LENGTH_SHORT).show();
        }
    }

}
