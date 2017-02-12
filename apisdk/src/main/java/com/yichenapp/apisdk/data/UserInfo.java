package com.yichenapp.apisdk.data;

import cn.bmob.v3.BmobUser;

/**
 * Created by Administrator on 2017/2/12 0012.
 */
public class UserInfo extends BmobUser
{
    private Boolean sex;

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    private String age;

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }


}
