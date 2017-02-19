package com.yichenapp.apisdk.login;

import android.support.annotation.NonNull;

import com.yichenapp.apisdk.data.UserInfo;
import com.yichenapp.core.utils.SharePreferencesHelper;
import com.yichenapp.core.utils.TraceLog;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2017/2/12 0012.
 */
public class LoginUtils {

    /**
     *
     * @param name      username
     * @param pwd       password
     * @param email     email
     * @param age       age ,using string
     * @param sex       set,true male,false female
     */
    public static void register(@NonNull String name,
                                @NonNull String pwd,
                                @NonNull String nickName,
                                String email,
                                String age,
                                boolean sex,
                                SaveListener<UserInfo> listener){
        UserInfo bu = new UserInfo();
        bu.setUsername(name);
        bu.setNickname(nickName);
        bu.setAge(age);
        bu.setPassword(pwd);
        bu.setEmail(email);
        bu.setSex(sex);
        bu.signUp(listener);
    }

    public static void login(String name,String pwd,LogInListener<UserInfo> listener) {
        BmobUser bu2 = new BmobUser();
        bu2.setUsername(name);
        bu2.setPassword(pwd);
        bu2.loginByAccount(name, pwd, listener);
    }

    public static UserInfo getCurrentUserInfo(){
        return UserInfo.getCurrentUser(UserInfo.class);
    }

    public static boolean isLogin(){
        UserInfo userInfo = getCurrentUserInfo();
        return (userInfo!=null);
    }

    public static void logout(){
        UserInfo.logOut();
        SharePreferencesHelper.removeByKey(UserInfo.class.getName());
    }

}
