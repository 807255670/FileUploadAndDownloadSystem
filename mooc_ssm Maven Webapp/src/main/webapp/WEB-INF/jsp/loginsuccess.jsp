<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html xmlns="http://www.w3.org/1999/xhtml"
xmlns:th="http://www.thymeleaf.org">
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'loginsuccess.jsp' starting page</title>
    
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
    您好！<%=session.getAttribute("username") %>
     <br>
     <br>
     <br>
     <br>
    
    <%--   <c:forEach items="${classlist }" var="u">  
          <form action ="/mooc_ssm/File/FileList" method = "post"> 
                课程名称：
                <input type="submit"  name="classname" value="${u.classname}" />
           </form> 
     
        <br/>  
      </c:forEach>  --%>
      
     <table id="classlisttable" width="500px"  >
	      <thead>
	       <tr>
	                <th width="20%">课程序号</th>
	                <th width="40%">课程名称</th>
	                <th width="40%">操作</th>
	
	       </tr>
	       </thead>
	       
	       <tbody>  
    		  <c:forEach items="${classlist }" var="u">
      
	       
			       <tr>
			       <td  align="center">   ${u.id } </td>
			       <td  align="center">${u.classname }</td>
			       <td  align="center"> <button onclick="detail(this)">   进入课程</button></td>
			       
			       </tr>
	       			
	       
    		  </c:forEach>
     	 </tbody>
      </table> 
      <br><br>
      <form id="addclass" action="/mooc_ssm/user/addclass" method="post" accept-charset="utf-8" onsubmit="document.charset='utf-8';">
      		<a>添加课程:</a>
      		 <input type="text" name="classname" placeholder='请输入课程名称'/>
      		 <input type="submit" value="添加"/>
      </form>
      
 		
  </body>
  
  <script  type="text/javascript">
   function detail(obj){
    	var classname = $(obj).parents("tr").children("td").eq(1).text();
    	window.location.href='/mooc_ssm/File/FileList?classname='+classname;
   }
  
  </script>
</html>
