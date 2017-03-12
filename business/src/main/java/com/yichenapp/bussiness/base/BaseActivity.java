package com.yichenapp.bussiness.base;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;
import android.widget.Toast;

import com.yichenapp.bussiness.R;
import com.yichenapp.core.utils.TraceLog;

import cn.bmob.v3.exception.BmobException;

/**
 * Created by Administrator on 2017/2/19 0019.
 */
public class BaseActivity extends AppCompatActivity {
    ProgressDialog progress = null;
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
        if(e!=null){
            TraceLog.e(e.toString());
            showErrorDialog(e.getMessage());
        }else{
            showDefaultError();
        }
    }

    private void showDefaultError() {
        showErrorDialog("default error");
    }

    public void showToast(String msg){
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show();
    }

    public boolean isProgressShowing() {
        return progress != null && progress.isShowing();
    }

    public void showLoadingDialog(){
        if (progress == null) {
            progress = new ProgressDialog(this);
            try {
                progress.show();
            } catch (WindowManager.BadTokenException e) {
                e.printStackTrace();
            }
        }
        progress.setCancelable(false);
        progress.setContentView(R.layout.progressdialog);
        progress.show();
    }

    public void showLoadingDialog(boolean isCancelable) {
        if (progress == null) {
            progress = new ProgressDialog(this);
            try {
                progress.show();
            } catch (WindowManager.BadTokenException e) {
                e.printStackTrace();
            }
        }
        progress.setCancelable(isCancelable);
        progress.setContentView(R.layout.progressdialog);
        progress.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        progress.show();
    }

    public void dismissLoadingDialog(){
        progress.dismiss();
    }


    public void showErrorDialog(String msg){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg);
        builder.create().show();
    }


}
