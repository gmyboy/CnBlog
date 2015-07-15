package com.gmy.cnblog.util;

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
}
