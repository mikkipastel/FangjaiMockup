package com.mikkipastel.fangjaimockup.Manager;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpManager {
    // from http://www.anop72.info/api/seed.json
    public String apiUrl = "http://www.anop72.info/api/";

    private static HttpManager instance;

    public static HttpManager getInstance() {
        if (instance == null){
            instance = new HttpManager();
        }
        return instance;
    }

    private ApiService service;

    private HttpManager() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(apiUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiService.class);
    }

    public ApiService getService(){
        return service;
    }
}
