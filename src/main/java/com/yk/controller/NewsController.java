package com.yk.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mysql.fabric.xmlrpc.base.Value;
import com.yk.pojo.News;
import com.yk.service.NewsService;

import net.sf.json.JSONObject;

@Controller
public class NewsController {
	
	@Autowired
	NewsService newsService;
	
	/**
	 * 发布新闻
	 * @param newsInfo
	 * @param title
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/releaseNews",method=RequestMethod.POST)
	public String releaseNews(String newsInfo, String title) {
		//保存新闻
		newsService.releaseNews(newsInfo,title);
		return "seccess";
	}
	
	/**
	 * 获取单个新闻信息，显示新闻详情
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/showNewsInfo",method=RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String showNewsInfo(Integer id) {
		News news = newsService.showNewsInfo(id);
		JSONObject jsonObject = JSONObject.fromObject(news);
		return jsonObject.toString();
	}
	
	/**
	 * 获取所有新闻信息，并分页显示
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value="/getNews",method=RequestMethod.GET, produces = "application/json;charset=utf-8")
	public String getNews(Integer pageNum) {
		PageHelper.startPage(pageNum,3);
		List<News> news = newsService.getNews();
		PageInfo pageInfo = new PageInfo(news);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("myMessage", pageInfo);
		return jsonObject.toString();
	}
	
}
