package com.yichenapp.apisdk.data;

import cn.bmob.v3.BmobObject;

/**
 * Created by deman.lu on 2017/2/26 0026.
 */
public class VipLevel extends BmobObject{
    private int Rate;
    private int money;
    private int level;

    public int getRate() {
        return Rate;
    }

    public void setRate(int rate) {
        Rate = rate;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }
}
