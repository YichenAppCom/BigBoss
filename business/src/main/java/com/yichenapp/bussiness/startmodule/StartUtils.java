package com.yichenapp.bussiness.startmodule;

import com.yichenapp.apisdk.data.Props;
import com.yichenapp.apisdk.data.UserInfo;
import com.yichenapp.apisdk.data.VipLevel;
import com.yichenapp.apisdk.utils.LoginUtils;
import com.yichenapp.apisdk.utils.PropUtils;
import com.yichenapp.bussiness.scores_props.PropsContent;
import com.yichenapp.core.utils.SharePreferencesHelper;
import com.yichenapp.core.utils.TraceLog;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

/**
 * Created by Administrator on 2017/2/19 0019.
 */
public class StartUtils implements PropUtils.PropResult {

    private static StartUtils  sInstance = null;
    private startUtilListener listener;
    private StartUtils(){}

    public static synchronized  StartUtils getsInstance(){
        if(sInstance == null){
            sInstance = new StartUtils();
        }
        return sInstance;
    }

    public void start(startUtilListener listener){
        TraceLog.i();
        this.listener = listener;
        autoLogin();
        initProps();
    }

    private void initProps() {
        PropUtils.getAllProps(this);
    }

    public void autoLogin(){
        UserInfo userInfo = LoginUtils.getCurrentUserInfo();
        if(userInfo!=null){
            queryUser(userInfo.getUsername());
        }
        else{
            if(listener!=null){
                listener.onComplete();
            }
        }
    }

    private void queryUser(String username) {
        BmobQuery<UserInfo> query = new BmobQuery<UserInfo>();
        query.addWhereEqualTo("username", username);
        query.include("viplevel");
        query.findObjects(new FindListener<UserInfo>() {
            @Override
            public void done(List<UserInfo> object, BmobException e) {
                if(e==null && object.size()>0){
                    TraceLog.i("get online user");
                    SharePreferencesHelper.saveObject(UserInfo.class.getName(),object.get(0));
                }else{
                    TraceLog.i("get current user");
                   SharePreferencesHelper.saveObject(UserInfo.class.getName(),LoginUtils.getCurrentUserInfo());
                }
                if(listener!=null){
                    listener.onComplete();
                }
            }
        });
    }

    @Override
    public void onFindProps(List<Props> list) {
        if(list!=null && list.size()>0){
            PropUtils.getAllVipLevels(this);
        }else{
            onFail();
        }
    }

    @Override
    public void onGetVipLevelConfig(List<VipLevel> list) {

    }

    @Override
    public void onFail() {

    }

    public interface startUtilListener{
        void onComplete();
    }
}
