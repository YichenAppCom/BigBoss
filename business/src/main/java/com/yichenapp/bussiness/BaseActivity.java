package com.yichenapp.bussiness;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.yichenapp.core.utils.TraceLog;

import cn.bmob.v3.exception.BmobException;

/**
 * Created by Administrator on 2017/2/19 0019.
 */
public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        TraceLog.i(this.getClass().getSimpleName());
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onResume() {
        TraceLog.i(this.getClass().getSimpleName());
        super.onResume();
    }

    @Override
    protected void onPause() {
        TraceLog.i(this.getClass().getSimpleName());
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        TraceLog.i(this.getClass().getSimpleName());
        super.onDestroy();
    }

    public void showException(BmobException e){
        TraceLog.e(e.getMessage());
    }

    public void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }
}
