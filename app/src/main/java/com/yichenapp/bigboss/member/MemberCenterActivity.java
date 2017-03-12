package com.yichenapp.bigboss.member;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.yichenapp.bigboss.R;
import com.yichenapp.bigboss.base.BaseBigBossActivity;
import com.yichenapp.bussiness.member.center.IMemberView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import cn.bmob.v3.exception.BmobException;

/**
 * Created by deman.lu on 2017/3/12 0012.
 */
public class MemberCenterActivity extends BaseBigBossActivity implements IMemberView {

    @BindView(R.id.username_id)
    TextView usernameId;
    @BindView(R.id.score_id)
    TextView scoreId;
    @BindView(R.id.findpwd_id)
    TextView findpwdId;
    @BindView(R.id.resetpwd_id)
    TextView resetpwdId;
    @BindView(R.id.title_back)
    ImageView titleBack;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_member_center);
        ButterKnife.bind(this);
    }

    @Override
    public void showUserName(String name) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void disMissLoading() {

    }

    @Override
    public void onComplete() {

    }

    @Override
    public void onError(BmobException e) {

    }

    @Override
    public void navigateToScore() {

    }

    @Override
    public void navigateToFindPwd() {

    }

    @Override
    public void navigateToAboutUs() {

    }

    @OnClick({R.id.title_back, R.id.username_id, R.id.score_id, R.id.findpwd_id, R.id.resetpwd_id})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.title_back:
                break;
            case R.id.username_id:
                break;
            case R.id.score_id:
                break;
            case R.id.findpwd_id:
                break;
            case R.id.resetpwd_id:
                break;
        }
    }
}
