package com.yichenapp.apisdk.login;

import com.yichenapp.apisdk.data.UserInfo;
import com.yichenapp.core.utils.TraceLog;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
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
    public static void register(String name,String pwd,String email,String age,boolean sex){
        UserInfo bu = new UserInfo();
        bu.setUsername(name);
        bu.setAge(age);
        bu.setPassword(pwd);
        bu.setEmail(email);
        bu.setSex(sex);
        bu.signUp(new SaveListener<UserInfo>() {
            @Override
            public void done(UserInfo userInfo, BmobException e) {
                if(e == null){
                    TraceLog.i("success");
                }else{
                    TraceLog.i("e:"+e.getMessage());
                }
            }
        });
    }

    public static void login(String name,String pwd){
        BmobUser bu2 = new BmobUser();
        bu2.setUsername(name);
        bu2.setPassword(pwd);
        bu2.login(new SaveListener<BmobUser>() {

            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if(e==null){
                    TraceLog.i("登录成功:");
                    //通过BmobUser user = BmobUser.getCurrentUser()获取登录成功后的本地用户信息
                    //如果是自定义用户对象MyUser，可通过MyUser user = BmobUser.getCurrentUser(MyUser.class)获取自定义用户信息
                }else{
                    TraceLog.e(e.getMessage());
                }
            }
        });
    }
}
