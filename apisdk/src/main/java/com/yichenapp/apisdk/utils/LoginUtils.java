package com.yichenapp.apisdk.utils;

import android.support.annotation.NonNull;

import com.yichenapp.apisdk.data.ExtraUser;
import com.yichenapp.apisdk.data.UserInfo;
import com.yichenapp.apisdk.data.VipLevel;
import com.yichenapp.core.utils.SharePreferencesHelper;
import com.yichenapp.core.utils.TraceLog;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;

/**
 * Created by Administrator on 2017/2/12 0012.
 */
public class LoginUtils {

    /**
     * @param name  username
     * @param pwd   password
     * @param email email
     * @param age   age ,using string
     * @param sex   set,true male,false female
     */
    public static void register(@NonNull String name,
                                @NonNull String pwd,
                                @NonNull String nickName,
                                String email,
                                String age,
                                boolean sex,
                                SaveListener<UserInfo> listener) {
        UserInfo bu = new UserInfo();
        bu.setUsername(name);
        bu.setNickname(nickName);
        bu.setAge(age);
        bu.setPassword(pwd);
        bu.setEmail(email);
        bu.setSex(sex);
        bu.signUp(listener);
    }

    public static void createUserExtras(UserInfo bu) {
        ExtraUser extraUser = new ExtraUser();
        extraUser.setType_a(2147483647);
        extraUser.setType_b(5);
        extraUser.setType_c(1);
        extraUser.setUser(bu);
        extraUser.save(new SaveListener<String>() {
            @Override
            public void done(String objectId, BmobException e) {
                TraceLog.i("objectId:" + objectId);
                if (e == null) {
                    TraceLog.i("success");
                } else {
                    TraceLog.w(e.getMessage());
                }
            }
        });
    }

    public static void login(final String name, String pwd, final LogInListener<UserInfo> listener) {
        BmobUser bu2 = new BmobUser();
        bu2.setUsername(name);
        bu2.setPassword(pwd);
        bu2.login(new SaveListener<UserInfo>() {
            @Override
            public void done(UserInfo userInfo, BmobException e) {
                if (e == null) {
                    checkUserInfo(name, listener);
                } else {
                    listener.done(null, e);
                }
            }
        });
    }

    private static void checkUserInfo(String name, final LogInListener<UserInfo> listener) {
        BmobQuery<UserInfo> query = new BmobQuery<UserInfo>();
        query.addWhereEqualTo("username", name);
        query.include("viplevel");
        query.findObjects(new FindListener<UserInfo>() {
            @Override
            public void done(List<UserInfo> list, BmobException e) {
                if (e == null) {
                    listener.done(list.get(0), e);
                } else {
                    listener.done(null, e);
                }
            }
        });
    }

    public static UserInfo getCurrentUserInfo() {
        return UserInfo.getCurrentUser(UserInfo.class);
    }

    public static boolean isLogin() {
        UserInfo userInfo = getCurrentUserInfo();
        return (userInfo != null);
    }

    public static void logout() {
        UserInfo.logOut();
        SharePreferencesHelper.removeByKey(UserInfo.class.getName());
    }

    public static void  getDefaultLevel(FindListener<VipLevel> defaultListener){
        BmobQuery<VipLevel> query = new BmobQuery<VipLevel>();
        query.addWhereEqualTo("level", 0);
        query.findObjects(defaultListener);
    }
}
