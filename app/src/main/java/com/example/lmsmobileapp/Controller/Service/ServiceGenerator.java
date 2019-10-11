package com.example.lmsmobileapp.Controller.Service;

import com.example.lmsmobileapp.Controller.Utils.RetrofitClient;
import retrofit2.Retrofit;

public class ServiceGenerator {

  /*  public static <S> S createService(Class<S> serviceClass) {
        Retrofit retrofit = RetrofitClient.getClient(ApiUrl.BASE_URL);
        return retrofit.create(serviceClass);
    }

    public static <S> S createStringService(Class<S> serviceClass) {
        Retrofit retrofit = RetrofitClient.getStringClient(ApiUrl.BASE_URL);
        return retrofit.create(serviceClass);
    }
    public static <S> S createUploadService(Class<S> serviceClass) {
        Retrofit retrofit = RetrofitClient.getUploadClient(ApiUrl.BASE_URL);
        return retrofit.create(serviceClass);
    }

    public static <S> S createAppUpdateService(Class<S> serviceClass, Context context) {
        Retrofit retrofit = RetrofitClient.getAppMCClient(ApiUrl.BASE_LOGIN,context);
        return retrofit.create(serviceClass);
    }*/

    public static <S> S createRestService(Class<S> serviceClass, String mainUrl) {
        Retrofit retrofit = RetrofitClient.getClientRequest(mainUrl);
        return retrofit.create(serviceClass);
    }

    public static <S> S createRestServiceStudent(Class<S> serviceClass, String mainUrl, String accountId) {
        Retrofit retrofit = RetrofitClient.getClientRequestStudent(mainUrl, accountId);
        return retrofit.create(serviceClass);
    }


}
