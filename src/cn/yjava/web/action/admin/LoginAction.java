package cn.yjava.web.action.admin;

import java.util.List;

import org.apache.struts2.ServletActionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import cn.yjava.core.action.BaseAction;
import cn.yjava.model.Admin;
import cn.yjava.service.IAdminService;
import cn.yjava.service.IPermissionService;
import cn.yjava.util.YjConstant;

/**
 * 
 * @title AdminAction 
 * @description 管理员处理类 
 * @author 俞杰
 * @time 2015年8月24日-上午4:10:19
 * @version 1.0.0
 * @since JDK1.7
 */
@Controller
@Scope("prototype")
public class LoginAction extends BaseAction{
	private String account;//用户名
	private String password;//密码
	@Autowired
	private IPermissionService permissionService;//权限
	@Autowired
	private IAdminService adminService;
	/**
	 * 
	 * @description 跳转到登陆页面
	 * @方法名 login
	 * @return String
	 * @exception
	 */
	public String execute(){
		return LOGIN;
	}
	/**
	 * 
	 * @description ajax登录验证
	 * @方法名 loginValidate
	 * @return String
	 * @exception
	 */
	public String loginValidate(){
		Admin admin=adminService.get(account, password);
		if(admin!=null){
			Integer adminId=admin.getId();
			List<Object[]> permissions=permissionService.find(adminId);
			ServletActionContext.getRequest().getSession().setAttribute(YjConstant.SESSION_PERMISSION,permissions);
			ServletActionContext.getRequest().getSession().setAttribute(YjConstant.SESSION_ADMIN, admin);
			result=SUCCESS;
		}else{
			result=FAIL;
		}
		return AJAX_SUCCESS;
	}
	/**
	 * 
	 * @description 退出登录 
	 * @方法名 exit
	 * @return String
	 * @exception
	 */
	public String exit(){
		ServletActionContext.getRequest().getSession().invalidate();
		return EXIT;
	}
	//setter
	public void setAccount(String account) {
		this.account = account;
	}
	public void setPassword(String password) {
		this.password = password;
	}
}
