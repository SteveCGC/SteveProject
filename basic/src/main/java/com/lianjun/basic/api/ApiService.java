package com.lianjun.basic.api;


import com.lianjun.basic.bean.LoginResult;
import com.lianjun.basic.bean.User;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

/**
 * author Steve on 2016/3/17.
 * email  changgongcai@126.com
 */
public interface ApiService {


    public static final String BASE_URL = "http://192.168.222.200:9999/hxlz/reception";

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @POST("/hxlz/reception/login/login/")
    Call<LoginResult> login(@Body User user);



}
