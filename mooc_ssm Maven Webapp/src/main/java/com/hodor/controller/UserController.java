package com.hodor.controller;
import java.io.UnsupportedEncodingException;
import java.util.List;  

import javax.annotation.Resource;  
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;  
import org.springframework.ui.Model;  
import org.springframework.web.bind.annotation.RequestMapping;  
  
import com.hodor.dto.User;
import com.hodor.dto.Class;
import com.hodor.service.IClassService;
import com.hodor.service.IUserService;  
  
@Controller  
@RequestMapping("/user")  
public class UserController {  
  @Resource
  IUserService userService;
  
  @Resource
  IClassService classService;
  
  @RequestMapping("/login")
  public String login(HttpSession session,HttpServletRequest request){
	  
	  if(session.getAttribute("username")!=null){ //无须登录
		  List<Class> list = classService.getAllClass();
		  request.setAttribute("classlist", list);
		  return "loginsuccess";
	  }
	  
	  String username = request.getParameter("username");
	  String password = request.getParameter("password");
	  boolean loginType = userService.login(username, password);
	  if(loginType){
		  List<Class> list = classService.getAllClass();
		  session.setAttribute("username", username);
		  session.setMaxInactiveInterval(600); //会话最长600s
		  request.setAttribute("classlist", list);
		  return "loginsuccess";
	  }
	  else{
		  request.setAttribute("messege", "用户名密码错误");
		  session.invalidate();
		  return "loginfalse";
	  }
  }
  @RequestMapping("/addclass")
  	public String addClass(HttpSession session,HttpServletRequest request) throws UnsupportedEncodingException{
	  if(session.getAttribute("username")==null){
		  return "loginfalse";
	  }
	  
	  if(request.getParameter("classname")!=null&&request.getParameter("classname")!=""){
		  classService.addClass(request.getParameter("classname"));
		  List<Class> list = classService.getAllClass();
		  request.setAttribute("classlist", list);
		  return "loginsuccess"; //刷新
	  }
	  else{
		  List<Class> list = classService.getAllClass();
		  request.setAttribute("classlist", list);
		  return "loginsuccess";
	  }
  }
  
}
