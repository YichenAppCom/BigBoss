package com.yichenapp.apisdk.data;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.datatype.BmobPointer;

/**
 * Created by deman.lu on 2017/2/25 0025.
 */
public class ExtraUser extends BmobObject {
    private int type_a;
    private int type_b;
    private int type_c;
    private UserInfo user;

    public UserInfo getUser() {
        return user;
    }

    public void setUser(UserInfo user) {
        this.user = user;
    }

    public int getType_a() {
        return type_a;
    }

    public void setType_a(int type_a) {
        this.type_a = type_a;
    }

    public int getType_b() {
        return type_b;
    }

    public void setType_b(int type_b) {
        this.type_b = type_b;
    }

    public int getType_c() {
        return type_c;
    }

    public void setType_c(int type_c) {
        this.type_c = type_c;
    }
}
