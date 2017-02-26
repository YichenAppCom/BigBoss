package com.yichenapp.apisdk.utils;

import com.yichenapp.apisdk.data.Props;
import com.yichenapp.apisdk.data.VipLevel;
import com.yichenapp.core.utils.TraceLog;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.datatype.BmobQueryResult;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SQLQueryListener;

/**
 * Created by deman.lu on 2017/2/26 0026.
 */
public class PropUtils {

    public static void getAllProps(final PropResult listener){
        if(listener == null){
            throw new RuntimeException(" listen is null");
        }
        String bql ="select * from props order by hurt";//query all info with prop
        new BmobQuery<Props>().doSQLQuery(bql,new SQLQueryListener<Props>(){

            @Override
            public void done(BmobQueryResult<Props> result, BmobException e) {
                if(e ==null){
                    List<Props> list = (List<Props>) result.getResults();
                    if(list!=null && list.size()>0){
                        listener.onFindProps(list);
                    }else{
                        TraceLog.i("查询成功，无数据返回");
                        listener.onFindProps(null);
                    }
                }else{
                    TraceLog.i("smile", "错误码："+e.getErrorCode()+"，错误描述："+e.getMessage());
                    listener.onFail();
                }
            }
        });
    }

    public static void getAllVipLevels(final PropResult listener){
        if(listener == null){
            throw new RuntimeException(" listen is null");
        }
        String bql ="select * from viplevel order by level";//query all info with prop
        new BmobQuery<VipLevel>().doSQLQuery(bql,new SQLQueryListener<VipLevel>(){

            @Override
            public void done(BmobQueryResult<VipLevel> result, BmobException e) {
                if(e ==null){
                    List<VipLevel> list = (List<VipLevel>) result.getResults();
                    if(list!=null && list.size()>0){
                        listener.onGetVipLevelConfig(list);
                    }else{
                        TraceLog.i("查询成功，无数据返回");
                        listener.onFindProps(null);
                    }
                }else{
                    TraceLog.i("smile", "错误码："+e.getErrorCode()+"，错误描述："+e.getMessage());
                    listener.onFail();
                }
            }
        });
    }

    public interface PropResult{
        void onFindProps(List<Props> list);
        void onGetVipLevelConfig(List<VipLevel> list);
        void onFail();
    }
}
