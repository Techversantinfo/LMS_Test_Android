package com.example.lmsmobileapp.Controller.Service.LoginService;

import com.example.lmsmobileapp.Controller.Utils.ApiUrl;
import com.example.lmsmobileapp.Model.LoginModel.LoginRequest;
import com.example.lmsmobileapp.Model.LoginModel.LoginResponse;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface LoginService {

    @POST(ApiUrl.LOGIN_URL)
    Call<LoginResponse> getLogin(@Query("username") String username, @Query("password") String password,
                                 @Query("usertype") String usertype, @Query("_extend") String _extend);

}
