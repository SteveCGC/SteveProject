package com.lianjun.basic.utils;

import android.content.Context;
import android.content.DialogInterface;

/**
 * Created by Administrator on 2016/6/3.
 */
public class UIHelper {

    /**
     * 发送App异常崩溃报告
     *
     * @param context
     */
    public static void sendAppCrashReport(final Context context) {

        DialogHelper.getConfirmDialog(context, "程序发生异常", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                // 退出
                System.exit(-1);
            }
        }).show();
    }
}
