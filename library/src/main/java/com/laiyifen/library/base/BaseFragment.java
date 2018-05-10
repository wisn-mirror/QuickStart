package com.laiyifen.library.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Wisn on 2018/5/6 上午10:20.
 */

public abstract class BaseFragment extends Fragment {
    /**
     * 当前Fragment渲染的视图View
     **/
    private View mContextView = null;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }


    public abstract void initView(View view);

    public abstract int bindLayout();

    public abstract void requestData();
}
