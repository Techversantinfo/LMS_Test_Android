package com.example.lmsmobileapp.Controller.Service;

import com.example.lmsmobileapp.Controller.Utils.ApiUrl;
import com.example.lmsmobileapp.Model.LoginModel.LoginResponse;
import com.example.lmsmobileapp.Model.StudentModel.StudentResponse;
import java.util.Map;

import retrofit2.Call;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface {



//    @POST(ApiConstants.TRANSACTIONS)
//    Call<TransactionSuccessModel> getTransactions(@FieldMap Map<String, String> parameters);

//    @Headers( "Content-Type: application/json")
//    @GET(ApiUrl.STUDENTS_URL)
//    Call<StudentResponse> getStudentData(@FieldMap Map<String, String> params);

    @GET(ApiUrl.STUDENTS_URL)
    Call<StudentResponse> getStudentData(@Query("account_id") String account_id, @Query("_start") String _start,
                                 @Query("_limit") String _limit, @Query("token") String token);

}
