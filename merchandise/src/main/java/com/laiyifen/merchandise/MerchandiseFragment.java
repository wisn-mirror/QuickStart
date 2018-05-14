package com.laiyifen.merchandise;

import android.view.View;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.laiyifen.library.commons.common.CommonFragment;
import com.laiyifen.library.commons.constants.ARoutePath;

/**
 * Created by Wisn on 2018/5/14 下午3:00.
 */
@Route(path = ARoutePath.merchandise.MerchandiseFragment)
public class MerchandiseFragment extends CommonFragment {
    @Override
    public void initView(View view) {
        view.findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ARouter.getInstance().build(ARoutePath.App.ScrollMainActivity).navigation();

            }
        });
    }

    @Override
    public int bindLayout() {
        return R.layout.fragment_merchandise;
    }

    @Override
    public void requestData() {

    }
}
