package com.gmy.cnblog.thread;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.Log;

/**
 * Created by Administrator on 2015/7/15.
 */
public class DataRunnable implements Runnable {
    /**
     * 睡眠时间
     */
    private long mSleep = 0;
    /**
     * 响应值
     */
    private int mWhat = Constant.WHAT_DEFAULT;
    /**
     * 网络连接路径
     */
    private String mUrl;
    /**
     * 主线程
     */
    private Handler mHandler;
    /**
     * 传递数据
     */
    private Message mMessage;
    /**
     * Activity
     */
    private Context mContext;

    public DataRunnable(Context context, String url, Handler handler) {
        this.mUrl = url;
        this.mHandler = handler;
        this.mContext = context;
        this.mMessage = mHandler.obtainMessage();
    }

    public DataRunnable(Context context, String url, Handler handler, int what) {
        this(context, url, handler);
        this.mWhat = what;
    }

    public DataRunnable(Context context, String url, Handler handler, long sleep) {
        this(context, url, handler);
        this.mSleep = sleep;
    }

    public Runnable setWhat(int what) {
        this.mWhat = what;
        return this;
    }

    public Runnable setSleep(long sleep) {
        this.mSleep = sleep;
        return this;
    }

    @Override
    public void run() {
        try {
            if( mSleep > 0 )
                Thread.sleep(mSleep);
        } catch(Exception e) {
            Log.d("BUG", e.toString());
        }

    }
}
