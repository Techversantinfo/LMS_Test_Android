package com.example.lmsmobileapp.Model.StudentModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class StudentResponse {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("response")
    @Expose
    private List<Response> response = null;
    @SerializedName("pagination")
    @Expose
    private Pagination pagination;


    public Integer getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public List<Response> getResponse() {
        return response;
    }

    public Pagination getPagination() {
        return pagination;
    }



}
