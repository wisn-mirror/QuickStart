package com.laiyifen.order;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.laiyifen.library.commons.common.CommonFragment;
import com.laiyifen.library.commons.constants.ARoutePath;

/**
 * Created by Wisn on 2018/5/14 下午3:07.
 */
@Route(path = ARoutePath.order.OrderFragment)
public class OrderFragment extends CommonFragment{
    @Override
    public void initView(View view) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_order;
    }

    @Override
    public void initData() {

    }
}
