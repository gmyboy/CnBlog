package com.gmy.cnblog.util;

/**
 * Created by Administrator on 2015/7/15.
 */
public class Constant {
    //网络请求what值
    public final static int WHAT_DEFAULT = 0X0000;
    public final static int WHAT_ONE = 0X0001;
    public final static int WHAT_TWO = 0X0002;
    public final static int WHAT_THREE = 0X0003;
    public final static int WHAT_FOUR = 0X0004;
    public final static int WHAT_MAX = 0X1001;

    public static boolean isDownImg = true;
    public static String USERLOGIN = "http://cnblogs.davismy.com/Handler.ashx?op=UserLogin&username={0}&pwd={1}&aid={2}&authcode={3}";// 登陆
    public static String HOTNEWS = "http://wcf.open.cnblogs.com/news/hot/";// 热门新闻
    public static String RECCENTNEWS = "http://wcf.open.cnblogs.com/news/recent/";// 最新新闻
    public static String RECOMMENDNEWS = "http://wcf.open.cnblogs.com/news/recommend/paged/1/";// 推荐新闻
    public static String NEWSINFO = "http://wcf.open.cnblogs.com/news/item/";// 新闻详细内容
    public static String NEWSCOMMENT = "http://wcf.open.cnblogs.com/news/item/";// 新闻评论
    public static String BLOGCOMMENT = "http://wcf.open.cnblogs.com/blog/post/";// 博文评论

    public static String ALLBLOG = "http://wcf.open.cnblogs.com/blog/sitehome/recent/";// 所有博客
    public static String TENDAYSBLOG = "http://wcf.open.cnblogs.com/blog/TenDaysTopDiggPosts/";
    public static String FORTYEIGHTBLOG = "http://wcf.open.cnblogs.com/blog/48HoursTopViewPosts/";
    public static String BLOGINFO = "http://wcf.open.cnblogs.com/blog/post/body/";// 单条博文的详细内容
    public static String SEARCHBLOGER = "http://wcf.open.cnblogs.com/blog/bloggers/search?t={0}";// 搜索博主
    public static String BLOGERINFO = "http://wcf.open.cnblogs.com/blog/u/{0}/posts/1/30";// 博主的详细信息（最近的30条博文）

    public static String BLOGERCHARTS = "http://wcf.open.cnblogs.com/blog/bloggers/recommend/";// 博客排行榜

    public static String SENDNEWSCOMMENT = "http://cnblogs.davismy.com/Handler.ashx?op=SendNewsComment&sid={0}&postId={1}&commendBody={2}&parentCommentID={3}&is_add_from={4}";//发送新闻评论
    public static String SENDBLOGSCOMMENT = "http://cnblogs.davismy.com/Handler.ashx?op=SendBlogComment&sid={0}&postId={1}&commendBody={2}&parentCommentID={3}&is_add_from={4}";//发送博客评论

    public static String GETUSERINFO = "http://cnblogs.davismy.com/Handler.ashx?op=GetUserInfo&blogapp={0}";
    public static String GETUSERCENTER = "http://cnblogs.davismy.com/Handler.ashx?op=GetUserCenter&sid={0}&uid={1}";
    public static String GETINGLINE = "http://cnblogs.davismy.com/Handler.ashx?op=GetIngLine&sid={0}&page={1}";
    public static String SENDINGPUBLIC = "http://cnblogs.davismy.com/Handler.ashx?op=SendIngPublic&sid={0}&content={1}";
}
