package com.laiyifen.library.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.laiyifen.library.commons.mvp.BaseView;

/**
 * Created by Wisn on 2018/5/6 上午10:20.
 */

public abstract class BaseFragment extends Fragment implements FragmentUserVisibleController.UserVisibleCallback,BaseView {

    private boolean isInit; // 是否可以开始加载数据
    private boolean isCreated;
    /**
     * 当前Fragment渲染的视图View
     **/
    private View mContextView = null;
    private FragmentUserVisibleController userVisibleController;

    public BaseFragment() {
        userVisibleController = new FragmentUserVisibleController(this, this);

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        isCreated = true;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (null != mContextView) {
            ViewGroup parent = (ViewGroup) mContextView.getParent();
            if (null != parent) parent.removeView(mContextView);
        } else {
            try {
                mContextView = inflater.inflate(bindLayout(), null);
                initView(mContextView);
            } catch (Exception e) {
                getActivity().finish();
                return mContextView;
            }
        }
        return mContextView;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        isInit = true;
        userVisibleController.activityCreated();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        userVisibleController.resume();
        if (getUserVisibleHint()) {
            if (isInit && isCreated) {
                isInit = false;// 加载数据完成
                initData();
            }
        }

    }
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        userVisibleController.setUserVisibleHint(isVisibleToUser);
        // 每次切换fragment时调用的方法
        if (isVisibleToUser) {
            if (isInit&&isCreated) {
                isInit = false;//加载数据完成
                initData();
            }
        }
    }
    @Override
    public void onPause() {
        super.onPause();
        userVisibleController.pause();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }



    public abstract int bindLayout();

    public abstract void initView(View view);

    public abstract void initData();

    @Override
    public void setWaitingShowToUser(boolean waitingShowToUser) {
        userVisibleController.setWaitingShowToUser(waitingShowToUser);
    }

    @Override
    public boolean isWaitingShowToUser() {
        return userVisibleController.isWaitingShowToUser();
    }

    @Override
    public boolean isVisibleToUser() {
        return userVisibleController.isVisibleToUser();
    }

    @Override
    public void callSuperSetUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
    }

    @Override
    public void onVisibleToUserChanged(boolean isVisibleToUser, boolean invokeInResumeOrPause) {

    }

    @Override
    public void onNetStart(String startMsg) {

    }
    @Override
    public void onNetError(String errorMsg) {

    }


    @Override
    public void onNetFinish(String startMsg) {

    }
}
