package com.gmy.cnblog.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gmy.cnblog.R;
import com.gmy.cnblog.adapter.NewsAdapter;
import com.gmy.cnblog.entity.News;
import com.gmy.cnblog.util.Constant;
import com.gmy.cnblog.util.XMLparser;

import java.util.List;


/**
 * Created by Administrator on 2015/7/15.
 */
public class NewsCardFragment extends BaseFragment {
    private int position;
    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private RecyclerView mRecyclerView;
    private List<News> datas;
    private String url = "";
    private View view;//布局
    private int mCurIndex = -1;//当前页
    private boolean isPrepared;//标志位，标志已经初始化完成
    private boolean mHasLoadedOnce;// 是否已被加载过一次，第二次就不再去请求数据了
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == Constant.WHAT_ONE) {
                mAdapter = new NewsAdapter(datas);
                mRecyclerView.setAdapter(mAdapter);
                mHasLoadedOnce = true;
            }
        }
    };

    public static Fragment newInstance(int position) {
        NewsCardFragment f = new NewsCardFragment();
        Bundle b = new Bundle();
        b.putInt("position", position);
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("position");
    }

    @Override
    public View onCreateView(LayoutInflater inflater, final ViewGroup container,
                             Bundle savedInstanceState) {
        if (view == null) {
            view = inflater.inflate(R.layout.frag_news, null);
            mRecyclerView = (RecyclerView) view.findViewById(R.id.my_recycler_view);
            mRecyclerView.setHasFixedSize(true);

            // use a linear layout manager
            mLayoutManager = new LinearLayoutManager(getActivity());
            mRecyclerView.setLayoutManager(mLayoutManager);
            switch (position) {
                case 0:
                    url=Constant.RECOMMENDNEWS+"40";

                    break;
                case 1:
                    url=Constant.HOTNEWS + "40";
                    break;
                case 2:
                    url=Constant.RECCENTNEWS + "40";
                    break;
            }
            isPrepared = true;
            lazyLoad();
        }
        // 因为共用一个Fragment视图，所以当前这个视图已被加载到Activity中，必须先清除后再加入Activity
        ViewGroup parent = (ViewGroup) view.getParent();
        if (parent != null) {
            parent.removeView(view);
        }
        return view;
    }

    @Override
    protected void lazyLoad() {
        if (!isPrepared || !isVisible || mHasLoadedOnce) {
            return;
        }
        new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        try {
                            datas = XMLparser.getAllNews(url);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                        handler.sendEmptyMessage(Constant.WHAT_ONE);
                    }
                }
        ).start();
    }
}
