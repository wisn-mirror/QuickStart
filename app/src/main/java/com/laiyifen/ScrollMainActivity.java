package com.laiyifen;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.laiyifen.library.adapter.MFragmentPagerAdapter;
import com.laiyifen.library.commons.common.CommonActivity;
import com.laiyifen.library.commons.constants.ARoutePath;
import com.laiyifen.library.event.BaseEvent;
import com.laiyifen.library.utils.ToastUtils;
import com.laiyifen.library.view.tipview.TipRadioButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.List;

@Route(path = ARoutePath.App.ScrollMainActivity)
public class ScrollMainActivity extends CommonActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {

    private RadioGroup rg_main_bottom;
    private ViewPager vp_centerlayout;
    private TipRadioButton rb_homepage, rb_merchandise, rb_shopcart, rb_mine;
    private MFragmentPagerAdapter fragmentPagerAdapter;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EventBus.getDefault().register(this);

    }

    @Override
    public void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }


    @Override
    public int bindLayout() {
        return R.layout.activity_main_scroll;
    }

    @Override
    public void initView(Activity activity) {
        swipeBackLayout.setEnableGesture(true);
        rg_main_bottom = (RadioGroup) findViewById(R.id.rg_main_bottom);
        vp_centerlayout = (ViewPager) findViewById(R.id.vp_centerlayout);
        rb_homepage = (TipRadioButton) findViewById(R.id.rb_homepage);
        rb_merchandise = (TipRadioButton) findViewById(R.id.rb_merchandise);
        rb_shopcart = (TipRadioButton) findViewById(R.id.rb_shopcart);
        rb_mine = (TipRadioButton) findViewById(R.id.rb_mine);
        rg_main_bottom.setOnCheckedChangeListener(this);
        List<String> pages = new ArrayList<>();
        pages.add(ARoutePath.homepager.HomeFragment);
        pages.add(ARoutePath.merchandise.MerchandiseFragment);
        pages.add(ARoutePath.shopcart.ShopCartFragment);
        pages.add(ARoutePath.mine.MineFragment);
        fragmentPagerAdapter = new MFragmentPagerAdapter(getSupportFragmentManager(), pages);
        vp_centerlayout.setAdapter(fragmentPagerAdapter);
        vp_centerlayout.addOnPageChangeListener(this);
    }


    @Subscribe(threadMode = ThreadMode.MAIN)
    public void tipMessage(BaseEvent<Integer> event) {
        ToastUtils.show(event.toString());
        switch (event.data) {
            case 0:
                if (event.type == -1) rb_homepage.setTip();
                else rb_homepage.setTipText(event.msg);
                break;
            case 1:
                if (event.type == -1) rb_merchandise.setTip();
                else rb_merchandise.setTipText(event.msg);
                break;
            case 2:
                if (event.type == -1) rb_shopcart.setTip();
                else rb_shopcart.setTipText(event.msg);
                break;
            case 3:
                if (event.type == -1) rb_mine.setTip();
                else rb_mine.setTipText(event.msg);
                break;
            default:
                break;
        }
    }
    @Override
    public void initData(Context context) {

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        int index = 0;
        switch (checkedId) {
            case R.id.rb_homepage:
                index = 0;
                break;
            case R.id.rb_merchandise:
                index = 1;
                break;
            case R.id.rb_shopcart:
                index = 2;
                break;
            case R.id.rb_mine:
                index = 3;
                break;
            default:
                break;
        }
        vp_centerlayout.setCurrentItem(index);

    }


    @Override
    public void onPageSelected(int position) {
        rg_main_bottom.setOnCheckedChangeListener(null);
        switch (position) {
            case 0:
                rb_homepage.setChecked(true);
                break;
            case 1:
                rb_merchandise.setChecked(true);
                break;
            case 2:
                rb_shopcart.setChecked(true);
                break;
            case 3:
                rb_mine.setChecked(true);
                break;
        }
        rg_main_bottom.setOnCheckedChangeListener(this);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

}
