package cn.yjava.web.action.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.yjava.core.action.BaseAction;
import cn.yjava.model.News;
import cn.yjava.service.INewsService;

/**
 * 
 * @title NewsAction 
 * @description  新闻处理类
 * @author 俞杰
 * @time 2015年09月03日 16:11:56
 * @version 1.0.0
 * @since JDK1.7
 */
@Controller
@Scope("prototype")
public class NewsAction extends BaseAction{
	@Autowired
	private INewsService newsService;
 	private List<News> newses;
	/**
	 * 
	 * @description 进入页面
	 * @方法名 list
	 * @return String
	 * @exception
	 */
	public String list(){
		newses=newsService.findNews(params, pageInfo);
		int count=newsService.countNews(params);
		pageInfo.setItemCount(String.valueOf(count));
		return SUCCESS;
	}
	//setter getter
	public List<News> getNewses() {
		return newses;
	}
}
