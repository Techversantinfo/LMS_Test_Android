package com.example.lmsmobileapp.Controller.Utils;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    public static Retrofit getClient(String baseUrl){


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okClient = new OkHttpClient.Builder()
                .connectTimeout(AppConstants.TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(AppConstants.TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        Gson gson = new GsonBuilder().serializeNulls().create();
        Retrofit client = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return  client;
    }
    public static Retrofit getUploadClient(String baseUrl){


        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient uploadOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(AppConstants.UPLOAD_TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(AppConstants.UPLOAD_TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        Gson gson = new GsonBuilder().serializeNulls().create();
        Retrofit client = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(uploadOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return  client;
    }

    public static Retrofit getClientRequest(String baseUrl) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okClient = new OkHttpClient.Builder()
                .connectTimeout(AppConstants.TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(AppConstants.TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        Gson gson = new GsonBuilder().serializeNulls().create();
        Retrofit client = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return client;
    }

    public static Retrofit getClientRequestStudent(String baseUrl, String accountId) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okClient = new OkHttpClient.Builder()
                .connectTimeout(AppConstants.TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(AppConstants.TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        Gson gson = new GsonBuilder().serializeNulls().create();
        Retrofit client = new Retrofit.Builder()
                .baseUrl(baseUrl+accountId+"/")
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return client;
    }


    public static Retrofit getAppMCClient(String baseUrl, final Context context) {

        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okClient = new OkHttpClient.Builder()
                .connectTimeout(AppConstants.TIME_OUT, TimeUnit.SECONDS)
                .readTimeout(AppConstants.TIME_OUT, TimeUnit.SECONDS)
                .addInterceptor(interceptor)
                .build();
        Gson gson = new GsonBuilder().serializeNulls().create();
        okClient.interceptors().add(interceptor);
        Retrofit client = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .client(okClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return client;
    }

//    public static Retrofit getStringClient(String baseUrl){
//        OkHttpClient okClient = new OkHttpClient();
//        okClient.interceptors().add(new Interceptor() {
//            @Override
//            public Response intercept(Interceptor.Chain chain) throws IOException {
//                Response response = chain.proceed(chain.request());
//                return response;
//            }
//        });
//
//        Retrofit client = new Retrofit.Builder()
//                .baseUrl(baseUrl)
//                .client(okClient)
//                .addConverterFactory(GsonConverterFactory.create())
//                .build();
//
//        return  client;
//    }

}
