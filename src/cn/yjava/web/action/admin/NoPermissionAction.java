package cn.yjava.web.action.admin;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.yjava.core.action.BaseAction;

/**
 * 
 * @title IndexAction 
 * @description  没有权限处理类
 * @author 俞杰
 * @time 2015年8月24日-上午9:26:26
 * @version 1.0.0
 * @since JDK1.7
 */
@Controller
@Scope("prototype")
public class NoPermissionAction extends BaseAction{
	/**
	 * 
	 * @description 跳转没有权限页面
	 * @方法名 execute
	 * @return String
	 * @exception
	 */
	public String execute(){
		return SUCCESS;
	}
}
