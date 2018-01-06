package com.example.cloud.mi.ec.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.util.Patterns;
import android.view.View;

import com.example.cloud.mi.ec.R;
import com.example.cloud.mi.ec.R2;
import com.example.cloud.mi_core.delegates.LatteDelegate;
import com.example.cloud.mi_core.net.RestClient;
import com.example.cloud.mi_core.net.callback.ISuccess;
import com.example.cloud.mi_core.util.log.LatteLogger;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by cloud on 2018/1/6.
 */

public class SignUpDelegate extends LatteDelegate {
    @BindView(R2.id.edit_sign_in_name)
    TextInputEditText mEditSignInName;
    @BindView(R2.id.edit_sign_in_email)
    TextInputEditText mEditSignInEmail;
    @BindView(R2.id.edit_sign_in_phone)
    TextInputEditText mEditSignInPhone;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mEditSignInPassword;
    @BindView(R2.id.edit_sign_in_re_password)
    TextInputEditText mEditSignInRePassword;
    @BindView(R2.id.btn_sign_in)
    AppCompatButton mBtnSignIn;
    @BindView(R2.id.tv_link_sign_in)
    AppCompatTextView tv_link_sign_in;

    private ISignListener mISignListener = null;


    @OnClick(R2.id.btn_sign_in)
    void onClickSignUp() {
        if (checkForm()) {
            RestClient.builder()
                    .url("http://192.168.56.1:8080/RestDataServer/api/user_profile.php")
                    .params("name", mEditSignInName.getText().toString())
                    .params("email", mEditSignInEmail.getText().toString())
                    .params("phone", mEditSignInPhone.getText().toString())
                    .params("password", mEditSignInPassword.getText().toString())
                    .success(new ISuccess() {
                        @Override
                        public void onSuccess(String response) {
                            LatteLogger.json("USER_PROFILE", response);
                            SignHandler.onSignUp(response, mISignListener);
                        }
                    })
                    .build()
                    .post();
        }
    }

    @OnClick(R2.id.tv_link_sign_in)
    void onClickLinkSignUp() {
        start(new SignInDelegate());
    }


    private boolean checkForm() {
        final String name = mEditSignInName.getText().toString();
        final String email = mEditSignInEmail.getText().toString();
        final String phone = mEditSignInPhone.getText().toString();
        final String password = mEditSignInPassword.getText().toString();
        final String rePassword = mEditSignInRePassword.getText().toString();

        boolean isPass = true;

        if (name.isEmpty()) {
            mEditSignInName.setError("请输入姓名");
            isPass = false;
        } else {
            mEditSignInName.setError(null);
        }

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEditSignInEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEditSignInEmail.setError(null);
        }

        if (phone.isEmpty() || phone.length() != 11) {
            mEditSignInPhone.setError("手机号码错误");
            isPass = false;
        } else {
            mEditSignInPhone.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            mEditSignInPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mEditSignInPassword.setError(null);
        }

        if (rePassword.isEmpty() || rePassword.length() < 6 || !(rePassword.equals(password))) {
            mEditSignInRePassword.setError("密码验证错误");
            isPass = false;
        } else {
            mEditSignInRePassword.setError(null);
        }

        return isPass;
    }


    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_up;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
