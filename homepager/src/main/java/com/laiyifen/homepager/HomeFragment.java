package com.laiyifen.homepager;

import android.view.View;
import android.widget.TextView;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.laiyifen.homepager.bean.Movies;
import com.laiyifen.homepager.model.HomeModelImpl;
import com.laiyifen.homepager.presenter.HomePresenter;
import com.laiyifen.library.commons.common.CommonFragment;
import com.laiyifen.library.commons.constants.ARoutePath;
import com.laiyifen.library.event.BaseEvent;

import org.greenrobot.eventbus.EventBus;

/**
 * Created by Wisn on 2018/5/14 下午3:07.
 */
@Route(path = ARoutePath.homepager.HomeFragment)
public class HomeFragment extends CommonFragment<HomeModelImpl, HomePresenter> implements HomePager.View, View.OnClickListener {


    private TextView result;
    private TextView refresh;
    private TextView loadmore;


    @Override
    public int bindLayout() {
        return R.layout.fragment_homepager;
    }


    @Override
    public void initView(View view) {
        result = view.findViewById(R.id.result);
        loadmore = view.findViewById(R.id.loadmore);
        refresh = view.findViewById(R.id.refresh);
        refresh.setOnClickListener(this);
        loadmore.setOnClickListener(this);
    }


    @Override
    public void initData() {
        ((HomePresenter) mPresenter).getTopMovies(2);
    }


    @Override
    public void showMovies(Movies movies) {
        result.setText(movies.toString());

    }

    @Override
    public void loadMore(Movies movies) {
        result.append(movies.toString());

    }

    @Override
    public void onClick(View v) {
        if (v == loadmore) {
            ((HomePresenter) mPresenter).loadMoreMovies(2);
            BaseEvent<Integer> baseEvent=new BaseEvent<>(-1,"",1);
            EventBus.getDefault().post(baseEvent);
        } else if (v == refresh) {
            ((HomePresenter) mPresenter).refreshMovies(2);
            BaseEvent<Integer> baseEvent=new BaseEvent<>(1,"39",1);
            EventBus.getDefault().post(baseEvent);
        }
    }

    @Override
    public void onNetStart(String startMsg) {
        super.onNetStart(startMsg);

    }

    @Override
    public void onNetFinish(String startMsg) {
        super.onNetFinish(startMsg);

    }


}
