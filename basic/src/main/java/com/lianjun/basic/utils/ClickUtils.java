package com.lianjun.basic.utils;

/**
 * 一些点击事件的处理
 * Created by Changgc on 2016/1/28.
 */
public class ClickUtils {

    private static long lastClickTime;
    public synchronized static boolean isFastClick() {
        long time = System.currentTimeMillis();
        if ( time - lastClickTime < 2000) {
            return true;
        }
        lastClickTime = time;
        return false;
    }
}
