package com.lianjun.basic;

import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * author Changgc on 2016/4/8
 * email  changgongcai@126.com
 */
public class BaseApp extends Application{

    public Gson gson;
    private static BaseApp ourInstance;
    public static BaseApp getInstance() {
        return ourInstance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        ourInstance = this;
        initGson();
        initLogger();

    }

    private void initLogger(){
//        LogLevel logLevel;
//        if (Config.DEBUG)logLevel =LogLevel.FULL;
//        else logLevel=LogLevel.NONE;
//
//        Logger.init().methodOffset(2).methodCount(2).logLevel(logLevel);
    }

    private void initGson() {
        this.gson = new GsonBuilder()
                .setDateFormat(GlobalConstant.DATA_FORMAT)
                .create();
    }
}
