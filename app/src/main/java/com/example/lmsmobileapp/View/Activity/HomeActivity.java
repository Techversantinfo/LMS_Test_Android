package com.example.lmsmobileapp.View.Activity;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lmsmobileapp.Controller.Adapter.StudentListAdapter;
import com.example.lmsmobileapp.Controller.Service.ApiClient;
import com.example.lmsmobileapp.Controller.Service.ApiInterface;
import com.example.lmsmobileapp.Controller.Utils.AppConstants;
import com.example.lmsmobileapp.Controller.Utils.PreferenceManager;
import com.example.lmsmobileapp.Controller.Utils.Util;
import com.example.lmsmobileapp.MainActivity;
import com.example.lmsmobileapp.Model.StudentModel.Response;
import com.example.lmsmobileapp.Model.StudentModel.StudentResponse;
import com.example.lmsmobileapp.R;
import com.google.android.material.snackbar.Snackbar;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private String token, accountId;
    private ProgressDialog progressDialog;
    private StudentListAdapter studentListAdapter;

    @SuppressLint("ResourceAsColor")
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.mediumGrey));
        setContentView(R.layout.activity_home);
        getSupportActionBar().hide();

        if (PreferenceManager.getInstance(getApplicationContext()).getString(AppConstants.TOKEN) != null)
            token = PreferenceManager.getInstance(getApplicationContext()).getString(AppConstants.TOKEN);

        if (PreferenceManager.getInstance(getApplicationContext()).getString(AppConstants.ACCOUNT_ID) != null)
            accountId = PreferenceManager.getInstance(getApplicationContext()).getString(AppConstants.ACCOUNT_ID);

        callStudentService("0", "1");

        getLogoutButton().setOnClickListener(this);
        getTextOne().setOnClickListener(this);
        getTextTwo().setOnClickListener(this);
        getTextThree().setOnClickListener(this);
        getTextFour().setOnClickListener(this);
        getTextFive().setOnClickListener(this);
    }

    //    variable typecasting
    private TextView getLogoutButton() { return (TextView) findViewById(R.id.tvLogout); }
    private TextView getTextOne() { return (TextView) findViewById(R.id.tvOne); }
    private TextView getTextTwo() { return (TextView) findViewById(R.id.tvTwo); }
    private TextView getTextThree() { return (TextView) findViewById(R.id.tvThree); }
    private TextView getTextFour() { return (TextView) findViewById(R.id.tvFour); }
    private TextView getTextFive() { return (TextView) findViewById(R.id.tvFive); }
    private TextView getNoData() { return (TextView) findViewById(R.id.tvNoData); }
    private RecyclerView getUsersRecyclerView() { return (RecyclerView) findViewById(R.id.usersRecyclerView); }
    private LinearLayout rootLayout() { return (LinearLayout) findViewById(R.id.rootHome); }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

            case R.id.tvLogout:
                AlertDialog dialog = signOutDilog();
                dialog.show();
                break;

            case R.id.tvOne:
                callStudentService("0", "1");
                break;

            case R.id.tvTwo:
                callStudentService("5", "2");
                break;

            case R.id.tvThree:
                callStudentService("10","3");
                break;

            case R.id.tvFour:
                callStudentService("14","4");
                break;

            case R.id.tvFive:
                callStudentService("19","5");
                break;
        }
    }

    //    Api call for listing students data
    private void callStudentService(final String start, final String count){
        if (Util.isNetworkAvailable(getApplicationContext())) {
            progressDialog = new ProgressDialog(HomeActivity.this);
            progressDialog = ProgressDialog.show(HomeActivity.this, null, null, true);
            progressDialog.setContentView(R.layout.progress_bar);
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            progressDialog.show();
            ApiInterface apiService = ApiClient.getClient(accountId).create(ApiInterface.class);
            Call<StudentResponse> call = apiService.getStudentData(accountId, start, "5", token);
            call.enqueue(new Callback<StudentResponse>() {
                @Override
                public void onResponse(Call<StudentResponse> call, retrofit2.Response<StudentResponse> response) {
                    if (response.isSuccessful()){
                        if (progressDialog.isShowing())
                            progressDialog.dismiss();
                            setUpAdapter(response.body().getResponse());
                            changePaginator(count);
                    }
                }
                @Override
                public void onFailure(Call<StudentResponse> call, Throwable t) {
                    // Log error here since request failed
                    if (progressDialog.isShowing())
                        progressDialog.dismiss();
                    showSnackBar(t.getMessage().toString(),2);
                }
            });

        }else {
            showSnackBar("Network not available",2);
        }
    }

    private void setUpAdapter(List<Response> list){
        studentListAdapter = new StudentListAdapter(getApplicationContext(), list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        getUsersRecyclerView().setLayoutManager(layoutManager);
        getUsersRecyclerView().setAdapter(studentListAdapter);
        if (studentListAdapter.getItemCount() > 0){
            getUsersRecyclerView().setVisibility(View.VISIBLE);
            getNoData().setVisibility(View.GONE);
        }else {
            getUsersRecyclerView().setVisibility(View.GONE);
            getNoData().setVisibility(View.VISIBLE);
        }
    }

    private AlertDialog signOutDilog()
    {
        AlertDialog myQuittingDialogBox =new AlertDialog.Builder(HomeActivity.this)
                .setTitle("Logout")
                .setMessage("Are you sure you want to logout?")
                .setPositiveButton("Ok", new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int whichButton) {
                        try {
                            logoff();
                        } catch (Exception e) { e.printStackTrace();}
                        dialog.dismiss();
                    }
                })

                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                })
                .create();
        return myQuittingDialogBox;

    }

    //    function to logoff clearing offline cache
    private void logoff() {
        PreferenceManager.getInstance(HomeActivity.this).clear();
        startActivity(new Intent(HomeActivity.this, MainActivity.class));
        finish();
    }


    private void showSnackBar(final String message, final int type) {
        Snackbar snackbar = Snackbar.make(rootLayout(), message, Snackbar.LENGTH_LONG);
        snackbar.setActionTextColor(getResources().getColor(R.color.edit_text_bg_color));

        if (type == 1)
            snackbar.getView().setBackgroundColor(getResources().getColor(R.color.darkGreen));
        else
            snackbar.getView().setBackgroundColor(getResources().getColor(R.color.red));

        final ViewGroup.LayoutParams params = snackbar.getView().getLayoutParams();
        if (params instanceof CoordinatorLayout.LayoutParams) {
            ((CoordinatorLayout.LayoutParams) params).gravity = Gravity.BOTTOM;
        } else {
            ((FrameLayout.LayoutParams) params).gravity = Gravity.BOTTOM;
        }
        snackbar.getView().setLayoutParams(params);
        View mView = snackbar.getView();
        TextView tv = (TextView) mView.findViewById(R.id.snackbar_text);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        } else {
            tv.setGravity(Gravity.CENTER_HORIZONTAL);
        }
        snackbar.show();
    }

    private void changePaginator(final String count){
        switch(count){
            case "1":
                getTextOne().setTextColor(Color.parseColor("#e98c3b"));
                getTextTwo().setTextColor(Color.parseColor("#333333"));
                getTextThree().setTextColor(Color.parseColor("#333333"));
                getTextFour().setTextColor(Color.parseColor("#333333"));
                getTextFive().setTextColor(Color.parseColor("#333333"));

                getTextOne().setPaintFlags(getTextOne().getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                getTextTwo().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);
                getTextThree().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);
                getTextFour().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);
                getTextFive().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);

                getTextOne().setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                getTextTwo().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                getTextThree().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                getTextFour().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                getTextFive().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                break;

            case "2":
                getTextOne().setTextColor(Color.parseColor("#333333"));
                getTextTwo().setTextColor(Color.parseColor("#e98c3b"));
                getTextThree().setTextColor(Color.parseColor("#333333"));
                getTextFour().setTextColor(Color.parseColor("#333333"));
                getTextFive().setTextColor(Color.parseColor("#333333"));

                getTextOne().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);
                getTextTwo().setPaintFlags(getTextOne().getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                getTextThree().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);
                getTextFour().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);
                getTextFive().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);

                getTextOne().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                getTextTwo().setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                getTextThree().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                getTextFour().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                getTextFive().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                break;

            case "3":
                getTextOne().setTextColor(Color.parseColor("#333333"));
                getTextTwo().setTextColor(Color.parseColor("#333333"));
                getTextThree().setTextColor(Color.parseColor("#e98c3b"));
                getTextFour().setTextColor(Color.parseColor("#333333"));
                getTextFive().setTextColor(Color.parseColor("#333333"));

                getTextOne().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);
                getTextTwo().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);
                getTextThree().setPaintFlags(getTextOne().getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                getTextFour().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);
                getTextFive().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);

                getTextOne().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                getTextTwo().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                getTextThree().setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                getTextFour().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                getTextFive().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                break;

            case "4":
                getTextOne().setTextColor(Color.parseColor("#333333"));
                getTextTwo().setTextColor(Color.parseColor("#333333"));
                getTextThree().setTextColor(Color.parseColor("#333333"));
                getTextFour().setTextColor(Color.parseColor("#e98c3b"));
                getTextFive().setTextColor(Color.parseColor("#333333"));

                getTextOne().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);
                getTextTwo().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);
                getTextThree().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);
                getTextFour().setPaintFlags(getTextOne().getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);
                getTextFive().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);

                getTextOne().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                getTextTwo().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                getTextThree().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                getTextFour().setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                getTextFive().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                break;

            case "5":
                getTextOne().setTextColor(Color.parseColor("#333333"));
                getTextTwo().setTextColor(Color.parseColor("#333333"));
                getTextThree().setTextColor(Color.parseColor("#333333"));
                getTextFour().setTextColor(Color.parseColor("#333333"));
                getTextFive().setTextColor(Color.parseColor("#e98c3b"));

                getTextOne().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);
                getTextTwo().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);
                getTextThree().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);
                getTextFour().setPaintFlags(getTextOne().getPaintFlags()| Paint.LINEAR_TEXT_FLAG);
                getTextFive().setPaintFlags(getTextOne().getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

                getTextOne().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                getTextTwo().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                getTextThree().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                getTextFour().setTextSize(TypedValue.COMPLEX_UNIT_SP,14);
                getTextFive().setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
                break;
        }
    }

}
