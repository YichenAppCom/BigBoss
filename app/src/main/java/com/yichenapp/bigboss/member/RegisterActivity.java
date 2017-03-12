package com.yichenapp.bigboss.member;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;

import com.yichenapp.bigboss.R;
import com.yichenapp.bussiness.base.BaseActivity;
import com.yichenapp.bussiness.member.register.IRegisterView;
import com.yichenapp.bussiness.member.register.RegisterPresenterImpl;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;

/**
 * Created by Administrator on 2017/2/19 0019.
 */
public class RegisterActivity extends BaseActivity implements IRegisterView{
    @BindView(R.id.account_edit)
    EditText accountEdit;
    @BindView(R.id.pwd_edit)
    EditText pwdEdit;
    @BindView(R.id.nick_edit)
    EditText nickEdit;
    @BindView(R.id.register_button)
    Button registerButton;

    RegisterPresenterImpl registerPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        registerPresenter = new RegisterPresenterImpl(getApplicationContext(),this);
    }

    @OnClick(R.id.register_button)
    public void onClick() {
        registerPresenter.registerUser();
    }

    @Override
    public void showLoading() {
        super.showLoadingDialog();
    }

    @Override
    public void dismissLoading() {
        super.dismissLoadingDialog();
    }

    @Override
    public String getAccountName() {
        return accountEdit.getText().toString();
    }

    @Override
    public String getPwd() {
        return pwdEdit.getText().toString();
    }

    @Override
    public String getNickName() {
        if(TextUtils.isEmpty(nickEdit.getText().toString()))
        {
            return getAccountName();
        }

        return nickEdit.getText().toString();
    }

    @Override
    public void onComplete() {
        showToast(getString(R.string.register_success));
        finish();
    }

    @Override
    public void onError(BmobException e) {
        showException(e);
    }

    public static void gotoSelf(Activity context){
        Intent intent = new Intent(context,RegisterActivity.class);
        context.startActivity(intent);
    }
}
