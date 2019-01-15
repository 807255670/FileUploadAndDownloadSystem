package com.hodor.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.hodor.dto.ClassFile;
import com.hodor.service.IFileService;

@Controller

public class UploadController {
	@Resource
	IFileService iFileService;
	
	@RequestMapping("/upload")
	public String uploadFile(HttpSession session,HttpServletRequest request,
			@RequestParam(value = "file")MultipartFile file) throws IllegalStateException, IOException{
		if(session.getAttribute("username")==null||session.getAttribute("classname")==null){
			return "loginfalse";
		}
		 String classname = session.getAttribute("classname").toString();
		 String path =request.getSession().getServletContext().getRealPath("upload")+"/"+classname+"/";
		 
		 SimpleDateFormat df = new SimpleDateFormat("HH_mm_ss");
		 String now = df.format(new Date());
	     String fileName = now+"_"+file.getOriginalFilename();  
	        if(file.getSize()!=0){
		        File dir = new File(path,fileName);        
		        if(!dir.exists()){
		            dir.mkdirs();
		        }
		        //MultipartFile自带的解析方法
		        file.transferTo(dir);
		        iFileService.insertintoFile(classname, fileName);
	        }
		        List<ClassFile> list = iFileService.getFileByClassname(classname);
				request.setAttribute("filelist", list);
		        request.setAttribute("classname", classname);
		        return "classfile";
	      
	        
	        

	}
	
	
}
