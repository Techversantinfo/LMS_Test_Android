package com.example.lmsmobileapp.Controller.Service.LoginService;

import com.example.lmsmobileapp.Model.LoginModel.LoginResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginInteractor {

    public void getAppLogin(Call<LoginResponse> call, final LoginListener oLoginListerner) {

        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.code() == 200)
                {
                    if (response.body().getStatus().equals("OK")) {
                        oLoginListerner.getLoginSuccess(response.body());

                    } else {
                        oLoginListerner.getLoginFailed(response.message());
                    }
                }
                else
                {
                    oLoginListerner.getLoginFailed(response.message());
                }
            }
            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                oLoginListerner.getLoginFailed(call.toString());
            }
        });
    }

}
