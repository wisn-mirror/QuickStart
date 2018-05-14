package com.laiyifen.shopcart;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.laiyifen.library.commons.common.CommonFragment;
import com.laiyifen.library.commons.constants.ARoutePath;
import com.laiyifen.order.R;

/**
 * Created by Wisn on 2018/5/14 下午3:07.
 */
@Route(path = ARoutePath.shopcart.ShopCartFragment)
public class ShopCartFragment extends CommonFragment{
    @Override
    public void initView(View view) {

    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_shopcart;
    }

    @Override
    public void requestData() {

    }
}
