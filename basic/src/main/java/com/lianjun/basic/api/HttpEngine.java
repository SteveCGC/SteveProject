package com.lianjun.basic.api;


import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * author changgc on 2016/3/17.
 * email  changgongcai@126.com
 */
public class HttpEngine {

    private static HttpEngine mInstance;
    private Retrofit retrofit;
    private String baseUrl;
    OkHttpClient httpClient;
    private static final boolean IS_DEBUG = true;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
        try {
            retrofit = new Retrofit.Builder()
                    .baseUrl("http://" + baseUrl)
//                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(httpClient)
                    .build();
        }catch (Exception e){
//            retrofit = new Retrofit.Builder()
//                    .baseUrl("http://192.168.222.200:9999")
////                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                    .addConverterFactory(GsonConverterFactory.create())
//                    .client(httpClient)
//                    .build();
            retrofit = null;
        }

    }

    public static HttpEngine getInstance() {
        if (mInstance == null) {
            synchronized (HttpEngine.class) {
                if (mInstance == null) {

                    mInstance = new HttpEngine();
                }
            }
        }
        return mInstance;
    }

    public static final long READ_TIME_OUT_SECOND = 15;
    public static final long CONNECT_TIME_OUT_SECOND = 15;

    public HttpEngine() {
        httpClient = new OkHttpClient.Builder()
                .readTimeout(READ_TIME_OUT_SECOND, TimeUnit.SECONDS)
                .connectTimeout(CONNECT_TIME_OUT_SECOND, TimeUnit.SECONDS).build();
        if (IS_DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            httpClient = new OkHttpClient.Builder()
                    .readTimeout(READ_TIME_OUT_SECOND, TimeUnit.SECONDS)
                    .connectTimeout(CONNECT_TIME_OUT_SECOND, TimeUnit.SECONDS)
                    .addInterceptor(logging).build();
        }

//        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                .readTimeout(7676, TimeUnit.MILLISECONDS)
//                .connectTimeout(7676, TimeUnit.MILLISECONDS)
//                .addInterceptor(interceptor)
//                .build();

//        retrofit = new Retrofit.Builder()
//                .baseUrl(baseUrl)
////                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
//                .addConverterFactory(GsonConverterFactory.create())
////                .client(okHttpClient)
//                .build();
    }

    public <T> T createService(Class<T> clz) {
        if (retrofit==null){
            return null;
        }
        return retrofit.create(clz);
    }
}
