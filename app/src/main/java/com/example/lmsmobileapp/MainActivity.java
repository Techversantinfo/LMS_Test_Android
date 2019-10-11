package com.example.lmsmobileapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.content.ContextCompat;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lmsmobileapp.Controller.Service.LoginService.LoginListener;
import com.example.lmsmobileapp.Controller.Service.LoginService.LoginServiceClass;
import com.example.lmsmobileapp.Controller.Utils.AppConstants;
import com.example.lmsmobileapp.Controller.Utils.PreferenceManager;
import com.example.lmsmobileapp.Controller.Utils.Util;
import com.example.lmsmobileapp.Model.LoginModel.LoginResponse;
import com.example.lmsmobileapp.View.Activity.HomeActivity;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoginListener {

    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setStatusBarColor(ContextCompat.getColor(this,R.color.button_bg));
        setContentView(R.layout.layout_login);
        getSupportActionBar().hide();

        rememberMe().setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked)
                            saveMyCredentials(getUserName().getText().toString().trim(), getPassword().getText().toString().trim(), "yes");
                    else
                        saveMyCredentials("", "", "");
            }
        });

        //   Store data in private mode while using Remember Me
        SharedPreferences sp1 = this.getSharedPreferences("Login", MODE_PRIVATE);
            String unm=sp1.getString("Name", null);
            String pass = sp1.getString("Psw", null);
            String rem = sp1.getString("Rem", null);
            getUserName().setText(unm);
            getPassword().setText(pass);
            if (null != rem)
                rememberMe().setChecked(true);
            else
                rememberMe().setChecked(false);

        getLoginButton().setOnClickListener(this);
    }

    @Override
    protected void onStart() {
        super.onStart();

        //    checking whether user is logged in or not
        final boolean isLoggedIn = PreferenceManager.getInstance(this).getBoolean(AppConstants.LOGGED_IN);
        if (isLoggedIn){
            startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }

    //    variable typecasting
    private EditText getUserName() { return (EditText) findViewById(R.id.etUsername); }
    private EditText getPassword() { return (EditText) findViewById(R.id.etPassword); }
    private LinearLayout getLoginButton() { return (LinearLayout) findViewById(R.id.btnLogin); }
    private LinearLayout rootLayout() { return (LinearLayout) findViewById(R.id.root); }
    @SuppressLint("WrongViewCast")
    private CheckBox rememberMe() { return (CheckBox) findViewById(R.id.checkboxRememberMe); }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            
            case R.id.btnLogin:
                if (isValidate())
                    callLoginService();
                    break;
        }
    }

    //    saving login credentials for remember Me
    private void saveMyCredentials(final String name, final String pass, final  String rem){
        SharedPreferences sp=getSharedPreferences("Login", MODE_PRIVATE);
        SharedPreferences.Editor Ed=sp.edit();
        Ed.putString("Name",name);
        Ed.putString("Psw",pass);
        if (rem.equals("yes"))
            Ed.putString("Rem",rem);
        else
            Ed.putString("Rem",null);
        Ed.commit();
    }

    //    validations for text fields
    private boolean isValidate() {
        String msg = null;
        boolean b = true;

        if (TextUtils.isEmpty(getUserName().getText())) {
            msg = "Please add username";
            b = false;
        }
        else if (TextUtils.isEmpty(getPassword().getText())) {
            msg = "Please add password";
            b = false;
        }
        if (msg != null)
            showSnackBar(msg, 2);
        return b;
    }

    //    Api call for login service
    private void callLoginService() {
        if (Util.isNetworkAvailable(getApplicationContext())) {

            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog = ProgressDialog.show(MainActivity.this, null, null, true);
            progressDialog.setContentView(R.layout.progress_bar);
            progressDialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
            progressDialog.show();

                LoginServiceClass oLoginServiceClass = new LoginServiceClass(MainActivity.this, this);
                oLoginServiceClass.getAppLogin(getUserName().getText().toString().trim(),
                        getPassword().getText().toString().trim(),
                        "accountAdmin", "user");
        }else {
            showSnackBar("Network not available", 2);
        }

    }

    //    Api success response for login service
    @Override
    public void getLoginSuccess(LoginResponse loginResponse) {

        if (progressDialog.isShowing())
            progressDialog.dismiss();

        String token = loginResponse.getResponse().getToken();
        String accountId = loginResponse.getResponse().getUser().getAccountId();
        if ( !token.isEmpty()){
            PreferenceManager.getInstance(getApplicationContext()).put(AppConstants.TOKEN, token);
            PreferenceManager.getInstance(getApplicationContext()).put(AppConstants.ACCOUNT_ID, accountId);
            PreferenceManager.getInstance(getApplicationContext()).put(AppConstants.LOGGED_IN, true);
        }
        showSnackBar("Login success!!", 1);
        startActivity(new Intent(getApplicationContext(), HomeActivity.class));
        finish();

    }

    //    Api failure response for login service
    @Override
    public void getLoginFailed(String message) {
        if (progressDialog.isShowing())
            progressDialog.dismiss();

        showSnackBar("Login failed!!", 2);
    }

    private void showSnackBar(final String message, final int type) {
        Snackbar snackbar = Snackbar.make(rootLayout(), message, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(getResources().getColor(R.color.button_bg));
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


    // clearing focus of EditText when touching outside
    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if ( v instanceof EditText) {
                Rect outRect = new Rect();
                v.getGlobalVisibleRect(outRect);
                if (!outRect.contains((int)event.getRawX(), (int)event.getRawY())) {
                    v.clearFocus();
                    InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
        }
        return super.dispatchTouchEvent(event);
    }
}
