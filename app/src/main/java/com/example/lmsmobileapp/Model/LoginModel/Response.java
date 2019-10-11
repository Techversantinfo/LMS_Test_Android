package com.example.lmsmobileapp.Model.LoginModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Response {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("seconds")
    @Expose
    private String seconds;
    @SerializedName("user_type")
    @Expose
    private String userType;
    @SerializedName("user")
    @Expose
    private User user;
    @SerializedName("login")
    @Expose
    private String login;
    @SerializedName("api_user_id")
    @Expose
    private String apiUserId;
    @SerializedName("accountAdmin")
    @Expose
    private Integer accountAdmin;
    @SerializedName("hash")
    @Expose
    private String hash;
    @SerializedName("account")
    @Expose
    private String account;
    @SerializedName("accessByPages")
    @Expose
    private Object accessByPages;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSeconds() {
        return seconds;
    }

    public void setSeconds(String seconds) {
        this.seconds = seconds;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getApiUserId() {
        return apiUserId;
    }

    public void setApiUserId(String apiUserId) {
        this.apiUserId = apiUserId;
    }

    public Integer getAccountAdmin() {
        return accountAdmin;
    }

    public void setAccountAdmin(Integer accountAdmin) {
        this.accountAdmin = accountAdmin;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        this.hash = hash;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public Object getAccessByPages() {
        return accessByPages;
    }

    public void setAccessByPages(Object accessByPages) {
        this.accessByPages = accessByPages;
    }
}
