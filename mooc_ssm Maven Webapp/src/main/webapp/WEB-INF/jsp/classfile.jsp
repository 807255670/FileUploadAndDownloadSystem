<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'classfile.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script src="https://cdn.bootcss.com/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"></script>
    <script src="http://code.jquery.com/jquery-migrate-1.4.1.js"></script>
  </head>
  
  <body>
       <a href="user/login">全部课程</a> >> ${classname} 
 
  
<br>
<br>
      

	
	 <table id="filelisttable" width="800px"  >
	      <thead>
	       <tr>
	                <th width="20%">文件号</th>
	                <th width="40%">文件名称</th>
	                <th width="40%">操作</th>
	
	       </tr>
	       </thead>
	       
	       <tbody> 
	       <c:forEach items="${filelist}" var="u">
	       <tr>
	       	<td align="center">${u.id }</td>
	       	<td align="center">${u.filename }</td>
	       	<td align="center"> <button onclick="download(this)">下载文件</button></td>
	       </tr>
	       </c:forEach>
	        
	        </tbody>
      </table> 
      <br>
      <br>
      
        <form action="/mooc_ssm/upload" method="post" enctype="multipart/form-data">
		选择文件:<input type="file" name="file" width="120px">
		<input type="submit" value="上传">
		</form>
      
  </body>
  <script  type="text/javascript">
   function download(obj){
    	var filename = $(obj).parents("tr").children("td").eq(1).text();
    	window.location.href='/mooc_ssm/download?filename='+filename;
   }
  
  </script>
</html>
