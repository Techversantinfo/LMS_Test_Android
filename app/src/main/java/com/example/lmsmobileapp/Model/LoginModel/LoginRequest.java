package com.example.lmsmobileapp.Model.LoginModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginRequest {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("password")
    @Expose
    private String password;
    @SerializedName("usertype")
    @Expose
    private String usertype;
    @SerializedName("_extend")
    @Expose
    private String _extend;



    public void setUsername(String username) {
        this.username = username;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public void setUsertype(String usertype) {
        this.usertype = usertype;
    }


    public void set_extend(String _extend) {
        this._extend = _extend;
    }


}
