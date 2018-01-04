package com.yk.pojo;

import java.io.Serializable;

public class News implements Serializable{
    private Integer id;

    private String title;

    private String profile;

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