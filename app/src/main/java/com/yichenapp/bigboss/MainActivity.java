package com.yichenapp.bigboss;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.yichenapp.apisdk.login.LoginUtils;
import com.yichenapp.bussiness.member.SigninActivity;
import com.yichenapp.core.utils.TraceLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.Bmob;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.startregister)
    Button startregister;
    @BindView(R.id.login)
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initBmob();
    }

    private void initBmob() {
        //第一：默认初始化
        Bmob.initialize(this, BuildConfig.BmobSdkKey);

        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        //BmobConfig config =new BmobConfig.Builder(this)
        ////设置appkey
        //.setApplicationId("Your Application ID")
        ////请求超时时间（单位为秒）：默认15s
        //.setConnectTimeout(30)
        ////文件分片上传时每片的大小（单位字节），默认512*1024
        //.setUploadBlockSize(1024*1024)
        ////文件的过期时间(单位为秒)：默认1800s
        //.setFileExpiration(2500)
        //.build();
        //Bmob.initialize(config);
    }


    @OnClick({R.id.startregister,R.id.login})
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.startregister:
                break;
            case R.id.login:
                SigninActivity.navigataToSignIn(MainActivity.this);
                break;
        }
    }

}
