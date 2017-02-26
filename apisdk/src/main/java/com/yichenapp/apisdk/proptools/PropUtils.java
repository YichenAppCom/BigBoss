package com.yichenapp.apisdk.proptools;

import com.yichenapp.apisdk.data.Props;
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
                        listener.onFind(list);
                    }else{
                        TraceLog.i("查询成功，无数据返回");
                        listener.onFind(null);
                    }
                }else{
                    TraceLog.i("smile", "错误码："+e.getErrorCode()+"，错误描述："+e.getMessage());
                    listener.onFail();
                }
            }
        });
    }

    public interface PropResult{
        void onFind(List<Props> list);
        void onFail();
    }
}
