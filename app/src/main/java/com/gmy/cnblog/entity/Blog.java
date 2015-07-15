package com.gmy.cnblog.entity;

/**
 * Created by Administrator on 2015/7/15.
 */
public class Blog {
    private int comments;// 评论
    private int diggs;// 出处
    private int id;// ID
    private String link_href;// 链接
    private String published;// 发表时间
    private String summary;// 内容
    private String title;// 标题
    private String updated;// 更新时间
    private int views;// 浏览次数
    private User user;// 博主信息

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getDiggs() {
        return diggs;
    }

    public void setDiggs(int diggs) {
        this.diggs = diggs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLink_href() {
        return link_href;
    }

    public void setLink_href(String link_href) {
        this.link_href = link_href;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUpdated() {
        return updated;
    }

    public void setUpdated(String updated) {
        this.updated = updated;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
