package com.yichenapp.apisdk.data;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2017/2/12 0012.
 */
public class UserInfo extends BmobUser
{
    public String getNickname() {
        return nickname;
    }
    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
    private String nickname;
}
