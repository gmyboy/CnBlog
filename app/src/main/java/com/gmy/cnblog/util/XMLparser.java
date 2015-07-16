package com.gmy.cnblog.util;

import android.util.Xml;

import com.gmy.cnblog.entity.Blog;
import com.gmy.cnblog.entity.News;
import com.gmy.cnblog.entity.User;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/7/15.
 */
public class XMLparser {
    /**
     * 单独获取博主博文总数
     *
     * @param path
     * @return
     * @throws IOException
     * @throws XmlPullParserException
     */
    public static int getCountofUser(String path) throws IOException, XmlPullParserException {
        URL url = new URL(path);
        int counnt = 0;
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        InputStream in = conn.getInputStream();
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(in, "UTF-8");
        int eventType = parser.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String name = parser.getName();

            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    break;
                case XmlPullParser.START_TAG:
                    if ("postcount".equals(name)) {
                        counnt = Integer.parseInt(parser.nextText());
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if ("postcount".equals(parser.getName())) {
                        break;
                    }
            }
            eventType = parser.next();
        }
        return counnt;
    }

    /**
     * 获取单个博主的所有博文
     *
     * @param path
     * @return
     * @throws IOException
     * @throws XmlPullParserException
     */
    public static List<Blog> getBlogofUser(String path) throws IOException,
            XmlPullParserException {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        InputStream in = conn.getInputStream();
        return parserBlogs(in);
    }

    /**
     * 获取查询结果的所有博主
     *
     * @param path
     * @return
     * @throws IOException
     * @throws XmlPullParserException
     */
    public static List<User> getAllUserofSearch(String path) throws IOException,
            XmlPullParserException {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        InputStream in = conn.getInputStream();
        return parserUsers(in);
    }

    /**
     * 获取新闻列表
     *
     * @param path
     * @return
     * @throws Exception
     */
    public static List<News> getAllNews(String path) throws Exception {

        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        InputStream in = conn.getInputStream();
        return parserNews(in);
    }

    /**
     * 获取所有博客信息
     *
     * @param path
     * @return
     * @throws IOException
     * @throws NumberFormatException
     * @throws XmlPullParserException
     */
    public static List<Blog> getAllBlogs(String path) throws IOException, NumberFormatException,
            XmlPullParserException {
        URL url = new URL(path);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setReadTimeout(5 * 1000);
        conn.setRequestMethod("GET");
        InputStream in = conn.getInputStream();
        return parserBlogs(in);
    }

    /**
     * 解析多条博文
     *
     * @param in
     * @return
     * @throws XmlPullParserException
     * @throws NumberFormatException
     * @throws IOException
     */
    private static List<Blog> parserBlogs(InputStream in) throws XmlPullParserException,
            NumberFormatException, IOException {
        List<Blog> blogs = null;
        Blog blog = null;
        User bloger = null;
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(in, "UTF-8");
        int eventType = parser.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String name = parser.getName();

            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    blogs = new ArrayList<Blog>();
                    break;
                case XmlPullParser.START_TAG:
                    if ("entry".equals(name)) {
                        blog = new Blog();
                        bloger = new User();
                    } else if (name.equals("id") && blog != null) {
                        blog.setId(Integer.parseInt(parser.nextText()));
                    } else if (name.equals("title") && blog != null) {
                        blog.setTitle(parser.nextText());
                    } else if (name.equals("summary") && blog != null) {
                        blog.setSummary(parser.nextText());
                    } else if (name.equals("published") && blog != null) {
                        blog.setPublished(parser.nextText());
                    } else if (name.equals("updated") && blog != null) {
                        blog.setUpdated(parser.nextText());
                    } else if (name.equals("link") && blog != null) {
                        blog.setLink_href(parser.getAttributeValue(1));
                    } else if (name.equals("name") && blog != null) {
                        bloger.setTitle(parser.nextText());
                    } else if (name.equals("uri") && blog != null) {
                        bloger.setLink(parser.nextText());
                    } else if (name.equals("avatar") && blog != null) {
                        bloger.setAvatar(parser.nextText());
                    } else if (name.equals("diggs") && blog != null) {
                        blog.setDiggs(parser.next());
                    } else if (name.equals("views") && blog != null) {
                        blog.setViews(Integer.parseInt(parser.nextText()));
                    } else if (name.equals("comments") && blog != null) {
                        blog.setComments(Integer.parseInt(parser.nextText()));
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if ("entry".equals(parser.getName())) {
                        blog.setUser(bloger);
                        blogs.add(blog);
                        blog = null;
                        bloger = null;
                    }
                    break;
            }
            eventType = parser.next();
        }
        return blogs;
    }

    /**
     * 解析多条用户信息
     *
     * @param in
     * @return
     * @throws XmlPullParserException
     * @throws IOException
     */
    public static List<User> parserUsers(InputStream in) throws XmlPullParserException,
            IOException {
        List<User> blogers = null;
        User bloger = null;
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(in, "UTF-8");
        int eventType = parser.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String name = parser.getName();

            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    blogers = new ArrayList<User>();
                    break;
                case XmlPullParser.START_TAG:
                    if ("entry".equals(name)) {

                        bloger = new User();
                    } else if (name.equals("id") && bloger != null) {
                        bloger.setId(parser.nextText());
                    } else if (name.equals("title") && bloger != null) {
                        bloger.setTitle(parser.nextText());
                    } else if (name.equals("updated") && bloger != null) {
                        bloger.setUpdate(parser.nextText());
                    } else if (name.equals("blogapp") && bloger != null) {
                        bloger.setBlogapp(parser.nextText());
                    } else if (name.equals("avatar") && bloger != null) {
                        bloger.setAvatar(parser.nextText());
                    } else if (name.equals("postcount") && bloger != null) {
                        bloger.setPostcount(Integer.parseInt(parser.nextText()));
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if ("entry".equals(parser.getName())) {
                        blogers.add(bloger);
                        bloger = null;
                    }
                    break;
            }
            eventType = parser.next();
        }
        return blogers;

    }

    /**
     * 解析多条新闻信息
     *
     * @param in
     * @return
     * @throws XmlPullParserException
     * @throws NumberFormatException
     * @throws IOException
     */
    private static List<News> parserNews(InputStream in) throws XmlPullParserException,
            NumberFormatException, IOException {
        List<News> newses = null;
        News news = null;
        XmlPullParser parser = Xml.newPullParser();
        parser.setInput(in, "UTF-8");
        int eventType = parser.getEventType();

        while (eventType != XmlPullParser.END_DOCUMENT) {
            String name = parser.getName();

            switch (eventType) {
                case XmlPullParser.START_DOCUMENT:
                    newses = new ArrayList<News>();
                    break;
                case XmlPullParser.START_TAG:
                    if ("entry".equals(name)) {
                        news = new News();

                    } else if (name.equals("id") && news != null) {
                        news.setId(Integer.parseInt(parser.nextText()));
                    } else if (name.equals("title") && news != null) {
                        news.setTitle(parser.nextText());
                    } else if (name.equals("summary") && news != null) {
                        news.setSummary(parser.nextText());
                    } else if (name.equals("published") && news != null) {
                        news.setPublished(parser.nextText());
                    } else if (name.equals("updated") && news != null) {
                        news.setUpdated(parser.nextText());
                    } else if (name.equals("link") && news != null) {
                        news.setLink_href(parser.getAttributeValue(1));
                    } else if (name.equals("diggs") && news != null) {
                        news.setDiggs(parser.next());
                    } else if (name.equals("views") && news != null) {
                        news.setViews(Integer.parseInt(parser.nextText()));
                    } else if (name.equals("comments") && news != null) {
                        news.setComments(Integer.parseInt(parser.nextText()));
                    } else if (name.equals("topic") && news != null) {
                        news.setTopic(null);
                    } else if (name.equals("topicIcon") && news != null) {
                        news.setTopicIcon(null);
                    } else if (name.equals("sourceName") && news != null) {
                        news.setSourceName(parser.nextText());
                    }
                    break;
                case XmlPullParser.END_TAG:
                    if ("entry".equals(parser.getName())) {
                        newses.add(news);
                        news = null;
                    }
                    break;
            }

            eventType = parser.next();
        }

        return newses;
    }


}
