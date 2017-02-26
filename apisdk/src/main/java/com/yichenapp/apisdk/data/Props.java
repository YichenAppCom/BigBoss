package com.yichenapp.apisdk.data;

import cn.bmob.v3.BmobObject;

/**
 * Created by deman.lu on 2017/2/26 0026.
 */
public class Props extends BmobObject {

    private String type;
    private String nameCN;
    private String name;
    private long hurt;

    public long getHurt() {
        return hurt;
    }

    public void setHurt(long hurt) {
        this.hurt = hurt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getNameCN() {
        return nameCN;
    }

    public void setNameCN(String nameCN) {
        this.nameCN = nameCN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
