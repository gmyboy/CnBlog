package com.gmy.cnblog.util;

import java.lang.String;

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


    public static String BASE_URL = "http://wcf.open.cnblogs.com/";
    //blog
    public static String ALLBLOG = BASE_URL + "blog/sitehome/recent/{0}";// 获取首页文章列表
    public static String ALLBLOGPAGED = BASE_URL + "blog/sitehome/paged/{0}/{1}";// 分页获取首页文章列表  pageIndex pageSize
    public static String TENDAYSBLOG = BASE_URL + "blog/TenDaysTopDiggPosts/{0}";//10天内推荐排行
    public static String FORTYEIGHTBLOG = BASE_URL + "blog/48HoursTopViewPosts/{0}";//48小时阅读排行
    public static String BLOGERCHARTS = BASE_URL + "blog/bloggers/recommend/{0}/{1}";// 分页博客排行榜  pageIndex  pageSize
    public static String GETBLOGCOUNT = BASE_URL + "blog/bloggers/recommend/count";// 获取推荐博客总数
    public static String SEARCHBLOGER = "blog/bloggers/search?t={0}";// 根据作者名搜索博主
    public static String GETBLOGCOMMENT = "blog/post/{0}/comments/{1}/{2}";// 获取文章评论  postId  pageIndex  pageSize
    public static String BLOGINFO = "blog/post/body/{0}";// 获取文章内容  postId
    public static String BLOGERINFO = "blogu/{0}/posts/{1}/{2}";// 分页获取个人博客文章列表 blogapp pageIndex pageSize
    //news
    public static String HOTNEWS = BASE_URL + "news/hot/{0}";// 热门新闻  itemCount
    public static String RECCENTNEWS = BASE_URL + "news/recent/{0}";// 最新新闻 itemcount
    public static String RECCENTNEWSPAGED = BASE_URL + "news/recent/paged/{0}/{1}";  //分页获取最新新闻列表 pageIndex  pageSize
    public static String RECOMMENDNEWS = BASE_URL + "news/recommend/paged/{0}/{1}";// 分页获取推荐新闻列表 pageIndex  pageSize
    public static String NEWSINFO = BASE_URL + "news/item/{0}";// 获取新闻内容
    public static String NEWSCOMMENT = "news/item/{0}/comments/{1}/{2}";// 获取新闻评论  contentId  pageIndex  pageSize


    public static String SENDNEWSCOMMENT = "http://cnblogs.davismy.com/Handler.ashx?op=SendNewsComment&sid={0}&postId={1}&commendBody={2}&parentCommentID={3}&is_add_from={4}";//发送新闻评论
    public static String SENDBLOGSCOMMENT = "http://cnblogs.davismy.com/Handler.ashx?op=SendBlogComment&sid={0}&postId={1}&commendBody={2}&parentCommentID={3}&is_add_from={4}";//发送博客评论
    public static String GETUSERINFO = "http://cnblogs.davismy.com/Handler.ashx?op=GetUserInfo&blogapp={0}";
    public static String GETUSERCENTER = "http://cnblogs.davismy.com/Handler.ashx?op=GetUserCenter&sid={0}&uid={1}";
    public static String GETINGLINE = "http://cnblogs.davismy.com/Handler.ashx?op=GetIngLine&sid={0}&page={1}";
    public static String SENDINGPUBLIC = "http://cnblogs.davismy.com/Handler.ashx?op=SendIngPublic&sid={0}&content={1}";
    public static String USERLOGIN = "http://cnblogs.davismy.com/Handler.ashx?op=UserLogin&username={0}&pwd={1}&aid={2}&authcode={3}";// 登陆
}
