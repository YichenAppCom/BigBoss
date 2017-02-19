package com.yichenapp.bigboss;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import com.yichenapp.apisdk.data.UserInfo;
import com.yichenapp.apisdk.login.LoginUtils;
import com.yichenapp.bussiness.member.SigninActivity;
import com.yichenapp.bussiness.startmodule.StartUtils;
import com.yichenapp.core.utils.SharePreferencesHelper;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @BindView(R.id.account_name)
    TextView accountName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initViews();
        StartUtils.getsInstance().start(new StartUtils.startUtilListener() {
            @Override
            public void onComplete() {
                updateViews();
            }
        });
    }

    private void updateViews() {
        UserInfo userInfo = SharePreferencesHelper.getObject(UserInfo.class.getName(),UserInfo.class);
        if(userInfo!=null){
            if(!TextUtils.isEmpty(userInfo.getNickname()))
            {
                accountName.setText(userInfo.getNickname());
            }else{
                accountName.setText(userInfo.getUsername());
            }
        }else{
            accountName.setText(R.string.member_login);
        }
    }

    private void initViews() {
        accountName.setText(R.string.member_login);
    }





    @OnClick(R.id.account_name)
    public void onClick() {
        if(LoginUtils.isLogin()){

        }else{
            SigninActivity.navigataToSignIn(MainActivity.this);
        }
    }
}
