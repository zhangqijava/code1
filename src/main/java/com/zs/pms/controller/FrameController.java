package com.zs.pms.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.exception.AppException;
import com.zs.pms.po.TuserPO;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.queryUser;

@Controller
public class FrameController {
@Autowired
UserService us;
@RequestMapping("/tologin.do")
public String tologin(){
	
	return "login";
}
@RequestMapping("/login.do")
public String login(queryUser query,String code,ModelMap model,HttpSession session){
	//获取图片中的验证码
	String ocode=(String) session.getAttribute(com.google.code.kaptcha.Constants.KAPTCHA_SESSION_KEY);
	if (!ocode.equals(code)) {
		//页面回带信息
		model.addAttribute("MSG","验证码有误，请重新输入");
		//返回登陆页面
		return "login";
	}
	//验证码校验成功
	TuserPO user;
	try {
		user=us.chkLogin(query);
		//设置登陆者的真实姓名
		session.setAttribute("CUSER", user);
		return "main";
		
	} catch (AppException e) {
		// TODO Auto-generated catch block
		//页面回带信息
		model.addAttribute("MSG",e.getErrMsg());
		return "login";
	}
}
	/*
	 * 去top页
	 * */
@RequestMapping("/totop.do")
	public String toTop(){
		return "top";
	}
/*
 * 	去left页
 * */
	@RequestMapping("/toleft.do")
	public String toleft(){
		return "left";
	}
	/*
	 * 去right页
	 * */
	@RequestMapping("/toright.do")
	public String toright(){
		return "right";
	}
}
