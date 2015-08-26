package cn.yjava.core.action;


/**
 * 
 * @title BaseAction 
 * @description 基础action 
 * @author 俞杰
 * @time 2015年8月23日-下午6:31:03
 * @version 1.0.0
 * @since JDK1.7
 */
public class BaseAction {
	public static final String AJAX_SUCCESS = "ajaxSuccess";
	public static final String SUCCESS = "success";
	public static final String FAIL = "fail";
	public static final String LOGIN="login";
	public static final String INDEX="index";
	public static final String EXIT="exit";
	protected String result;//让子类去继承  
	/*public String getResult() {
		return result;
	}*/
	public void setResult(String result) {
		this.result = result;
	}
}
