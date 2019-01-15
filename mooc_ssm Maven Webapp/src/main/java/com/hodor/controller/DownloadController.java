package com.hodor.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller


public class DownloadController {

	@RequestMapping("/download")
	public void downloadFile(HttpSession session,HttpServletRequest request,HttpServletResponse response) throws IOException{
		if(session.getAttribute("username")==null||session.getAttribute("classname")==null){
			response.sendRedirect("loginfalse.jsp");
		}
				
		String classname = session.getAttribute("classname").toString();
		String filename = request.getParameter("filename");
		filename = new String(filename .getBytes("iso8859-1"),"utf-8");//url±àÂë×ª»»
		
		String fileName = request.getSession().getServletContext().getRealPath("upload")+"/"+classname+"/" + filename ;
        
        InputStream bis = new BufferedInputStream(new FileInputStream(new File(fileName)));  
        
        
        
        String downloadName = classname+"_"+filename;  
        
       	downloadName = URLEncoder.encode(downloadName,"UTF-8");  
        
        response.addHeader("Content-Disposition", "attachment;filename*=utf-8'zh_cn'" + downloadName);    
            
        response.setContentType("multipart/form-data");   
        
        BufferedOutputStream out = new BufferedOutputStream(response.getOutputStream());  
        int len = 0;  
        while((len = bis.read()) != -1){  
            out.write(len);  
            out.flush();  
        }  
        out.close(); 
    }  
	
	
}
