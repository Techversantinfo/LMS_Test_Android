package com.example.lmsmobileapp.Controller.Service;

import com.example.lmsmobileapp.Controller.Utils.ApiUrl;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

//    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    private static Retrofit retrofit = null;


    public static Retrofit getClient(final String accountid) {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(ApiUrl.BASE_URL_USERS + accountid +"/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
