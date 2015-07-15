package com.gmy.cnblog.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.gmy.cnblog.fragment.NewsCardFragment;

/**
 * Created by Administrator on 2015/7/15.
 */
public class CardPageAdapter extends FragmentPagerAdapter {
    private final String[] TITLES = {"推荐新闻", "热门新闻", "最新新闻", "所有博客", "48小时阅读排行", "十天内阅读排行",};

    public CardPageAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return TITLES[position];
    }

    @Override
    public int getCount() {
        return TITLES.length;
    }

    @Override
    public Fragment getItem(int position) {
        return NewsCardFragment.newInstance(position);
    }

}
