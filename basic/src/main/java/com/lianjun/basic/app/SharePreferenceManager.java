package com.lianjun.basic.app;

import android.content.Context;

/**
 * Created by Administrator on 2016/5/4.
 */
public class SharePreferenceManager {

    public static final String SP_CONFIG_NAME = "sp_config";


    public static final String KEY_EMP_POSITION = "epm_position";//用户的职务
    public static final String KEY_STORE_CD = "store_cd";//所属门店
    public static final String KEY_USER_REAL_NAME = "user_real_name";//用户姓名
    public static final String KEY_USER_ID = "user_user_id";//用户的员工id，也是userId
    public static final String  KEY_EMPLOYEE_ID = "e_employee_id";//
    public static final String  KEY_USER_PASSWORD = "user_password";//
    public static final String  KEY_IP_PORT = "ip_port";//


    public static void saveString(Context context,String key,String value){
        context.getSharedPreferences(SP_CONFIG_NAME,Context.MODE_PRIVATE).edit().putString(key,value).commit();
    }

    public static String getString(Context context,String key,String defaultValue){
        return context.getSharedPreferences(SP_CONFIG_NAME,Context.MODE_PRIVATE).getString(key,defaultValue);
    }

}
