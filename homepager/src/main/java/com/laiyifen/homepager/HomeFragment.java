package com.laiyifen.homepager;

import android.provider.Settings;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.laiyifen.library.commons.common.CommonFragment;
import com.laiyifen.library.commons.constants.ARoutePath;
import com.laiyifen.library.utils.ToastUtils;
import com.laiyifen.library.view.refresh.SmartRefreshLayout;

/**
 * Created by Wisn on 2018/5/14 下午3:07.
 */
@Route(path = ARoutePath.homepager.HomeFragment)
public class HomeFragment extends CommonFragment{

    private RecyclerView recyclerView;
    private SmartRefreshLayout refresh;

    @Override
    public void initView(View view) {
        refresh = view.findViewById(R.id.refresh);
        recyclerView = view.findViewById(R.id.homerecycle);
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_homepager;
    }

    @Override
    public void requestData() {

        try {
            String androidId= Settings.Secure.getString(getActivity().getContentResolver(),
                               Settings.Secure.ANDROID_ID);
            ToastUtils.show(androidId);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
