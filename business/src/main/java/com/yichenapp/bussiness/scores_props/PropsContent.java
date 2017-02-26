package com.yichenapp.bussiness.scores_props;

import com.yichenapp.apisdk.data.Props;
import com.yichenapp.apisdk.proptools.PropUtils;
import com.yichenapp.core.utils.TraceLog;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/2/25 0025.
 *
 */
public class PropsContent {
    private static List<Props> mPropList = new ArrayList<>();
    public static void initProps(){
        TraceLog.i();
        PropUtils.getAllProps(new PropUtils.PropResult() {
            @Override
            public void onFind(List<Props> list) {
                onFindProps(list);
            }

            @Override
            public void onFail() {
                mPropList.clear();
            }
        });
    }

    private static void onFindProps(List<Props> list) {
        mPropList.clear();
        mPropList.addAll(list);
    }

    public static List<Props> getPropList(){
        return mPropList;
    }
}
