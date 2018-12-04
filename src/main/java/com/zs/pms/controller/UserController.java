package com.zs.pms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zs.pms.exception.AppException;
import com.zs.pms.service.UserService;
import com.zs.pms.vo.queryUser;

@Controller
public class UserController {
	//按类型自动装配
	@Autowired
	UserService us;
	@RequestMapping("/user/userlist.do")
	public String list(queryUser query,String page,ModelMap map){
		//如果page为空，将page默认设置为第一页
		if (page==null||"".equals(page)) {
			page="1";
		}
		
		
			//向页面带回分页数据
			map.addAttribute("LIST", us.queryByPage(query, Integer.parseInt(page)));
			//带回页面总数
			map.addAttribute("PAGECOYNT", us.queryByCount(query));
			//回带当前页数
			map.addAttribute("PAGE", page);
			//回带查询条件
			map.addAttribute("QUERY",query);
			//返回user/userlist.jsp页面
			return "user/userlist";
		} 
	}
	

