package com.lianjun.basic.api;


/**
 * author Steve on 2016/3/21.
 * email  changgongcai@126.com
 */
public class ServiceFactory {

    private static ApiService mService;
    private static ServiceFactory mServiceFactory;

    private ServiceFactory(){}

    public static ServiceFactory getInstance(){
        if (mService == null){
            mService = HttpEngine.getInstance().createService(ApiService.class);
            mServiceFactory = new ServiceFactory();
        }
        return mServiceFactory;
    }

    public ApiService getApiService(){

        return mService;
    }
    public void regetService() {
        mService = HttpEngine.getInstance().createService(ApiService.class);

    }

}
