package com.example.lmsmobileapp.Controller.Service.LoginService;

import com.example.lmsmobileapp.Model.LoginModel.LoginResponse;

public interface LoginListener {

    public void getLoginSuccess(LoginResponse loginResponse);
    public void getLoginFailed(String message);

}
