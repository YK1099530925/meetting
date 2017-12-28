package com.yk.pojo;

public class News {
    /**
	 * 新闻id
	 */
    private Integer id;

    /**
	 * 新闻标题
	 */
    private String title;

    /**
	 * 新闻简介
	 */
    private String profile;

    /**
	 * 新闻内容
	 */
    private String newsinfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getProfile() {
        return profile;
    }

    public void setProfile(String profile) {
        this.profile = profile == null ? null : profile.trim();
    }

    public String getNewsinfo() {
        return newsinfo;
    }

    public void setNewsinfo(String newsinfo) {
        this.newsinfo = newsinfo == null ? null : newsinfo.trim();
    }

	@Override
	public String toString() {
		return "News [id=" + id + ", title=" + title + ", profile=" + profile + ", newsinfo=" + newsinfo + "]";
	}
    
}