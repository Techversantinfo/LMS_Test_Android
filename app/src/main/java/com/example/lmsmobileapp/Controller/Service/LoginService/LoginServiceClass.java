package com.example.lmsmobileapp.Controller.Service.LoginService;

import android.content.Context;

import com.example.lmsmobileapp.Controller.Service.ServiceGenerator;
import com.example.lmsmobileapp.Controller.Utils.ApiUrl;
import com.example.lmsmobileapp.Model.LoginModel.LoginRequest;
import com.example.lmsmobileapp.Model.LoginModel.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Query;

public class LoginServiceClass {

    LoginInteractor interactor;
    LoginListener listener;
    LoginService serviceInterface;

    public LoginServiceClass(Context context, LoginListener oLoginListerner) {
        listener=oLoginListerner;
        serviceInterface = ServiceGenerator.createRestService(LoginService.class, ApiUrl.BASE_URL_LMS);
        interactor = new LoginInteractor();
    }
    public void getAppLogin(String username, String password, String usertype, String extend)
    {
        Call<LoginResponse> call = serviceInterface.getLogin(username, password, usertype, extend);
        interactor.getAppLogin(call,listener);
    }

}
