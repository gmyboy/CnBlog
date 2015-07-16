package com.gmy.cnblog.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.gmy.cnblog.fragment.BlogsCardFragment;
import com.gmy.cnblog.fragment.NewsCardFragment;

/**
 * Created by Administrator on 2015/7/15.
 */
public class CardPageAdapter extends FragmentPagerAdapter {
    private String[] TITLES;

    public CardPageAdapter(FragmentManager fm, String[] mTitles) {
        super(fm);
        this.TITLES = mTitles;
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
        if (position < 3)
            return NewsCardFragment.newInstance(position);
        else
            return BlogsCardFragment.newInstance(position);
    }

}
