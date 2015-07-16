package com.gmy.cnblog;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2015/7/16.
 */
public class ReplyActivity extends AppCompatActivity {
    public static final String ARG_DRAWING_START_LOCATION = "arg_drawing_start_location";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reply);
    }
}
