package com.lianjun.basic.utils;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.text.TextUtils;

/**
 * Created by Administrator on 2016/6/3.
 */
public class PhoneUtil {

    /**
     * 获取手机厂商信息
     *
     * @return
     */
    public static String getManufacturer() {
        //手机厂商
        String phoneFactory = Build.MANUFACTURER;
        if (!TextUtils.isEmpty(phoneFactory)) {
//            phoneFactory = phoneFactory.replace("&", "");
        } else {
            phoneFactory = "";
        }
        return phoneFactory;
    }

    /**
     * 获取手机型号
     *
     * @return
     */
    public static String getPhoneModel() {
        //手机型号
        String model = Build.MODEL;
        if (!TextUtils.isEmpty(model)) {
//            model = model.replace("&", "");
        } else {
            model = "";
        }
        return model;
    }

    /**
     * 获取系统版本
     *
     * @return
     */
    public static String getSdkInt() {
        //系统版本
        String os = String.valueOf(Build.VERSION.SDK_INT);
        return os;
    }

    /**
     * 获取版本名称
     * @param context
     * @return
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            String version = info.versionName;
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    /**
     * 获取版本号
     * @param context
     * @return
     */
    public static String getVersionCode(Context context) {
        try {
            PackageManager manager = context.getPackageManager();
            PackageInfo info = manager.getPackageInfo(context.getPackageName(), 0);
            String version = info.versionCode+"";
            return version;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

}
