package com.yichenapp.bigboss.member;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.yichenapp.apisdk.data.UserInfo;
import com.yichenapp.apisdk.utils.LoginUtils;
import com.yichenapp.bigboss.R;
import com.yichenapp.bigboss.base.BaseBigBossActivity;
import com.yichenapp.core.utils.TraceLog;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;


/**
 * Created by Administrator on 2017/2/19 0019.
 */
public class LoginActivity extends BaseBigBossActivity implements View.OnClickListener {

    EditText accountEdit;
    EditText pwdEdit;
    Button loginButton;
    Button registerButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);
        accountEdit = (EditText) findViewById(R.id.account_edit);
        pwdEdit = (EditText) findViewById(R.id.pwd_edit);
        loginButton = (Button) findViewById(R.id.login_button);
        registerButton = (Button) findViewById(R.id.register_button);
        loginButton.setOnClickListener(this);
        registerButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(R.id.login_button == view.getId()){
            String name = accountEdit.getText().toString();
            String pwd = pwdEdit.getText().toString();
            LoginUtils.login(name, pwd, new LogInListener<UserInfo>() {
                @Override
                public void done(UserInfo userInfo, BmobException e) {
                    if(e == null){
                        TraceLog.i("success");
                    }else{
                        TraceLog.w(e.getMessage());
                    }
                }
            });
        }else if(R.id.register_button == view.getId()){
            RegisterActivity.gotoSelf(this);
        }
    }

    public static void gotoSelf(Activity context){
        Intent intent = new Intent(context,LoginActivity.class);
        context.startActivity(intent);
    }
}
