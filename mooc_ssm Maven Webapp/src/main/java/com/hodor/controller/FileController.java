package com.hodor.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.websocket.Session;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hodor.dto.ClassFile;
import com.hodor.service.IFileService;

@Controller
@RequestMapping("/File")
public class FileController {
@Resource
IFileService iFileService;
	
	@RequestMapping("/FileList")
	 public String showFile(HttpSession session,HttpServletRequest request) throws UnsupportedEncodingException{
		
		if(session.getAttribute("username")==null||request.getParameter("classname")==null){
			return "loginfalse";
			
		}
		String classname = request.getParameter("classname");
		classname = new String(classname .getBytes("iso8859-1"),"utf-8");//url编码转换
		if(iFileService.getFileByClassname(classname)!=null){
			List<ClassFile> list = iFileService.getFileByClassname(classname);
			request.setAttribute("filelist", list);
			request.setAttribute("classname", classname);
			session.setAttribute("classname", classname);  //把课程名加入session
			return "classfile";
		}
		return "classfile";
	}
}
