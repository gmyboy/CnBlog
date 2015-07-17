package com.gmy.cnblog.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2015/7/15.
 */
public class StringUtil {
    /*
     * 转换日期格式 like：2014-07-28T10:54:35+08:00 to 2014年07月28日  10:54:35
	 */
    public static String getDateString(String string) throws ParseException {
        String temp1 = string.substring(0, 10);
        String temp2 = string.substring(11, 19);
        SimpleDateFormat forsdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat latsdf = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = forsdf.parse(temp1);
        String now = latsdf.format(date);
        return now + "" + temp2;
    }

    private static int screenWidth = 0;
    private static int screenHeight = 0;

    public static int dpToPx(int dp) {
        return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
    }

    public static int getScreenHeight(Context c) {
        if (screenHeight == 0) {
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenHeight = size.y;
        }

        return screenHeight;
    }

    public static int getScreenWidth(Context c) {
        if (screenWidth == 0) {
            WindowManager wm = (WindowManager) c.getSystemService(Context.WINDOW_SERVICE);
            Display display = wm.getDefaultDisplay();
            Point size = new Point();
            display.getSize(size);
            screenWidth = size.x;
        }

        return screenWidth;
    }
}
