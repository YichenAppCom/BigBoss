package com.yichenapp.bussiness.member.center;

import android.content.Context;
import android.text.TextUtils;

import com.yichenapp.apisdk.data.UserInfo;
import com.yichenapp.apisdk.utils.LoginUtils;

/**
 * Created by deman.lu on 2017/3/12 0012.
 */
public class MemberPresenterImpl {

    private IMemberView view;
    private Context context;

    public MemberPresenterImpl(IMemberView view, Context context) {
        this.view = view;
        this.context = context;
    }

    public void init(){
        UserInfo userInfo = LoginUtils.getCurrentUserInfo();
        if(userInfo!=null){
            if(!TextUtils.isEmpty(userInfo.getNickname())){
                view.showUserName(userInfo.getNickname());
            }else{
                view.showUserName(userInfo.getUsername());
            }
        }
    }

    public void onScoreClick(){
        view.navigateToScore();
    }

    public void onFindPwdClick(){
        view.navigateToFindPwd();
    }

    public void onAboutUs(){
        view.navigateToAboutUs();
    }


}
