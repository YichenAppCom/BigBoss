package com.yichenapp.bussiness.member.register;

import cn.bmob.v3.exception.BmobException;

/**
 * Created by Administrator on 2017/2/19 0019.
 */
public interface IRegisterView {
    void showLoading();
    void dismissLoading();
    String getAccountName();
    String getPwd();
    String getNickName();
    String getEmail();
    String getAge();
    void onComplete();
    void onError(BmobException e);
}
