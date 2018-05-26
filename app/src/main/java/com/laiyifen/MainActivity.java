package com.laiyifen;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.RadioGroup;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.laiyifen.library.commons.common.CommonActivity;
import com.laiyifen.library.commons.constants.ARoutePath;

@Route(path = ARoutePath.App.MainActivity)
public class MainActivity extends CommonActivity implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {
    Fragment homePager;
    Fragment merchandise;
    Fragment shopcart;
    Fragment mine;
    private Fragment oldFragment;
    private RadioGroup rg_main_bottom;


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

    @Override
    public void onCheckedChanged(RadioGroup group, int checkedId) {
        switch (checkedId) {
            case R.id.rb_homepage:
                switchFragment(oldFragment,homePager);
                break;
            case R.id.rb_merchandise:
                switchFragment(oldFragment,merchandise);
                break;
            case R.id.rb_shopcart:
                switchFragment(oldFragment, shopcart);
                break;
            case R.id.rb_mine:
                switchFragment(oldFragment,mine);
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
        oldFragment=to;
    }

    public void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        if (!fragment.isAdded()) {
            fragmentManager.beginTransaction().add(R.id.centerlayout, fragment).commitAllowingStateLoss();
        }
        oldFragment=fragment;
    }

}
