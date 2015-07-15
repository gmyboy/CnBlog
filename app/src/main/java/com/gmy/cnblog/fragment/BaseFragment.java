package com.gmy.cnblog.fragment;

import android.support.v4.app.Fragment;

/**
 * Created by Administrator on 2015/7/15.
 */
public abstract class BaseFragment extends Fragment {

    protected boolean isVisible;//Fragment当前状态是否可见

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (getUserVisibleHint()) {
            isVisible = true;
            onVisible();
        } else {
            isVisible = false;
            onInvisible();
        }
    }

    /**
     * 可见
     */
    protected void onVisible() {
        lazyLoad();
    }

    /**
     * 不可见
     */
    protected void onInvisible() {
    }

    /**
     * 延迟加载 子类必须重写此方法
     */
    protected abstract void lazyLoad();
}
