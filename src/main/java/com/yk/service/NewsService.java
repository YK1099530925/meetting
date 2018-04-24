package com.yk.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yk.dao.MyNewsMapper;
import com.yk.dao.NewsMapper;
import com.yk.pojo.News;

@Service
public class NewsService {
	
	@Autowired
	MyNewsMapper myNewsMapper;
	
	@Autowired
	NewsMapper newsMapper;

	//发布新闻，保存新闻信息
	public void releaseNews(String newsInfo, String title) {
		News news = new News();
		news.setTime(new Date());
		news.setTitle(title);
		news.setNewsinfo(newsInfo);
		newsMapper.insert(news);
	}

	public News showNewsInfo(Integer id) {
		return newsMapper.selectByPrimaryKey(id);
	}

	public List<News> getNews() {
		return newsMapper.selectByExample(null);
	}

	
}
