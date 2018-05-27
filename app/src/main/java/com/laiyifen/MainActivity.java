package com.laiyifen;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.laiyifen.library.commons.common.CommonActivity;
import com.laiyifen.library.commons.constants.ARoutePath;
import com.laiyifen.library.event.BaseEvent;
import com.laiyifen.library.utils.ToastUtils;
import com.laiyifen.library.view.tipview.TipRadioButton;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Route(path = ARoutePath.App.MainActivity)
public class MainActivity extends CommonActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    Fragment homePager;
    Fragment merchandise;
    Fragment shopcart;
    Fragment mine;
    private Fragment oldFragment;
    private RadioGroup rg_main_bottom;
    private TipRadioButton rb_homepage;
    private TipRadioButton rb_merchandise;
    private TipRadioButton rb_shopcart;
    private TipRadioButton rb_mine;

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
        return R.layout.activity_main;
    }

    @Override
    public void initView(Activity activity) {
        swipeBackLayout.setEnableGesture(false);
        homePager = (Fragment) ARouter.getInstance().build(ARoutePath.homepager.HomeFragment).navigation();
        merchandise = (Fragment) ARouter.getInstance().build(ARoutePath.merchandise.MerchandiseFragment).navigation();
        shopcart = (Fragment) ARouter.getInstance().build(ARoutePath.shopcart.ShopCartFragment).navigation();
        mine = (Fragment) ARouter.getInstance().build(ARoutePath.mine.MineFragment).navigation();
        rb_homepage = (TipRadioButton) findViewById(R.id.rb_homepage);
        rb_merchandise = (TipRadioButton) findViewById(R.id.rb_merchandise);
        rb_shopcart = (TipRadioButton) findViewById(R.id.rb_shopcart);
        rb_mine = (TipRadioButton) findViewById(R.id.rb_mine);
        rg_main_bottom = (RadioGroup) findViewById(R.id.rg_main_bottom);
        rg_main_bottom.setOnCheckedChangeListener(this);
        addFragment(homePager);
    }

    @Override
    public void initData(Context context) {
        ARouter.getInstance().build(ARoutePath.App.ScrollMainActivity)
                .navigation();
    }

    @Override
    public void onClick(View v) {

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
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_homepage:
                switchFragment(oldFragment, homePager);
                break;
            case R.id.rb_merchandise:
                switchFragment(oldFragment, merchandise);
                break;
            case R.id.rb_shopcart:
                switchFragment(oldFragment, shopcart);
                break;
            case R.id.rb_mine:
                switchFragment(oldFragment, mine);
                break;
            default:
                break;
        }
    }

    public void switchFragment(Fragment from, Fragment to) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (to.isAdded() || fragmentManager.getFragments().contains(to)) {
            // 隐藏当前的fragment，显示下一个
            fragmentManager.beginTransaction().hide(from).show(to).commitAllowingStateLoss();
        } else {
            // 隐藏当前的fragment，add下一个到Activity中
            fragmentManager.beginTransaction().hide(from).add(R.id.centerlayout, to).commitAllowingStateLoss();
        }
        oldFragment = to;
    }

    public void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (!fragment.isAdded()) {
            fragmentManager.beginTransaction().add(R.id.centerlayout, fragment).commitAllowingStateLoss();
        }
        oldFragment = fragment;
    }

}
