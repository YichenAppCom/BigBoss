package com.yichenapp.bussiness.member.register;

import android.content.Context;

import com.yichenapp.apisdk.data.UserInfo;
import com.yichenapp.apisdk.utils.LoginUtils;
import com.yichenapp.bussiness.R;
import com.yichenapp.core.utils.SharePreferencesHelper;
import com.yichenapp.core.utils.TraceLog;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2017/2/19 0019.
 */
public class RegisterPresenterImpl {

    IRegisterView view;
    Context context;
    public RegisterPresenterImpl(Context context, IRegisterView view){
        this.context = context;
        this.view = view;
    }

    private void register(SaveListener<UserInfo> listener){

        if(!checkAccount()){
            view.showToast(context.getString(R.string.member_account_length_wrong));
            return;
        }

        if(!checkPwd()){
            view.showToast(context.getString(R.string.member_pwd_length_wrong));
            return;
        }

        LoginUtils.register(
                view.getAccountName(),
                view.getPwd(),
                view.getNickName(),
                listener
        );
    }

    private boolean checkPwd() {
        String pwd = view.getPwd();
        if(pwd!=null && pwd.length()>=4){
            return true;
        }
        return false;
    }

    private boolean checkAccount() {
        String account = view.getAccountName();
        if(account!=null && account.length()>=6){
            return true;
        }
        return false;
    }

    public void registerUser(){
        view.showLoading();
        register(new SaveListener<UserInfo>() {
            @Override
            public void done(UserInfo userInfo, BmobException e) {
                view.dismissLoading();
                if(e == null){
                    LoginUtils.createUserExtras(userInfo);
                    SharePreferencesHelper.saveObject(UserInfo.class.getName(),userInfo);
                    view.onComplete();
                }else{
                    TraceLog.w("e:"+e.getMessage());
                    view.onError(e);
                }
            }
        });
    }
}
