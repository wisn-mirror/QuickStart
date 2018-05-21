package com.laiyifen.library.view.refresh.header;


import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.laiyifen.library.view.refresh.api.RefreshInternal;
import com.laiyifen.library.view.refresh.api.RefreshLayout;
import com.laiyifen.library.view.refresh.constant.RefreshState;
import com.laiyifen.library.view.refresh.internal.InternalAbstract;
import com.laiyifen.library.view.refresh.utils.DensityUtil;

/**
 * Created by Wisn on 2018/5/18 下午2:24.
 */
public class LyfRefreshHeader extends InternalAbstract implements RefreshInternal {

    private ImageView drawable;
    protected int mPaddingTop = 20;
    protected int mPaddingBottom = 20;

    public LyfRefreshHeader(Context context) {
        this(context, null);
    }

    public LyfRefreshHeader(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public LyfRefreshHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs, defStyleAttr);
    }

    private void initView(Context context, AttributeSet attrs, int defStyleAttr) {
        drawable = new ImageView(context);
        final View thisView = this;
        final DensityUtil density = new DensityUtil();
        RelativeLayout.LayoutParams lpArrow = new RelativeLayout.LayoutParams(density.dip2px(20), density.dip2px(20));
        lpArrow.addRule(CENTER_VERTICAL);
        lpArrow.addRule(CENTER_HORIZONTAL);
        this.addView(drawable, lpArrow);
        if (thisView.getPaddingTop() == 0) {
            if (thisView.getPaddingBottom() == 0) {
                thisView.setPadding(thisView.getPaddingLeft(), mPaddingTop = density.dip2px(20), thisView.getPaddingRight(), mPaddingBottom = density.dip2px(20));
            } else {
                thisView.setPadding(thisView.getPaddingLeft(), mPaddingTop = density.dip2px(20), thisView.getPaddingRight(), mPaddingBottom = thisView.getPaddingBottom());
            }
        } else {
            if (thisView.getPaddingBottom() == 0) {
                thisView.setPadding(thisView.getPaddingLeft(), mPaddingTop = thisView.getPaddingTop(), thisView.getPaddingRight(), mPaddingBottom = density.dip2px(20));
            } else {
                mPaddingTop = thisView.getPaddingTop();
                mPaddingBottom = thisView.getPaddingBottom();
            }
        }


    }

    @NonNull
    @Override
    public View getView() {
        return this;
    }

    @Override
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean success) {
        return super.onFinish(refreshLayout, success);
    }

    @Override
    public void onMoving(boolean isDragging, float percent, int offset, int height, int maxDragHeight) {
        super.onMoving(isDragging, percent, offset, height, maxDragHeight);
    }

    @Override
    public void onReleased(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {
        super.onReleased(refreshLayout, height, maxDragHeight);
    }

    @Override
    public void onStartAnimator(@NonNull RefreshLayout refreshLayout, int height, int maxDragHeight) {
        super.onStartAnimator(refreshLayout, height, maxDragHeight);
    }

    @Override
    public void onStateChanged(@NonNull RefreshLayout refreshLayout, @NonNull RefreshState oldState, @NonNull RefreshState newState) {
        super.onStateChanged(refreshLayout, oldState, newState);
    }
}
