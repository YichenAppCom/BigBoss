package com.yichenapp.bigboss.base;

import android.content.SharedPreferences;
import android.support.multidex.MultiDexApplication;

import com.yichenapp.bigboss.BuildConfig;
import com.yichenapp.bussiness.startmodule.StartUtils;
import com.yichenapp.core.utils.SharePreferencesHelper;

import cn.bmob.v3.Bmob;

/**
 * Created by Administrator on 2017/2/19 0019.
 */
public class BigbossApp extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        initApp();
    }

    private void initApp() {
        initBmob();
        SharePreferencesHelper.init(this);
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
}
