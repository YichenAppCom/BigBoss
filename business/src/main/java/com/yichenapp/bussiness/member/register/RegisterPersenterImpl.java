package com.yichenapp.bussiness.member.register;

import com.yichenapp.apisdk.data.UserInfo;
import com.yichenapp.apisdk.utils.LoginUtils;
import com.yichenapp.core.utils.SharePreferencesHelper;
import com.yichenapp.core.utils.TraceLog;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2017/2/19 0019.
 */
public class RegisterPersenterImpl {

    IRegisterView view;
    public RegisterPersenterImpl(IRegisterView view){
        this.view = view;
    }

    private void register(SaveListener<UserInfo> listener){


        LoginUtils.register(
                view.getAccountName(),
                view.getPwd(),
                view.getNickName(),
                view.getEmail(),
                view.getAge(),
                false,
                listener
        );
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
