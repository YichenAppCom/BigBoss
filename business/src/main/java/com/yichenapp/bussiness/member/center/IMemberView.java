package com.yichenapp.bussiness.member.center;

import cn.bmob.v3.exception.BmobException;

/**
 * Created by deman.lu on 2017/3/12 0012.
 */
public interface IMemberView {
    void showUserName(String name);
    void showLoading();
    void disMissLoading();
    void onComplete();
    void onError(BmobException e);
    void showToast(String msg);
    void navigateToScore();
    void navigateToFindPwd();
    void navigateToAboutUs();
}
