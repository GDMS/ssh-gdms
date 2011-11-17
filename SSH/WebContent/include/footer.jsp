<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%
	String pathFooter = request.getContextPath();
	String basePathFooter = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ pathFooter + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePathFooter%>">
</head>

<body>
<br>
<center>
  Copyright 2004东华大学计算机科学与技术学院<br>
  Powered by Tomcat v5.5<br>
  You can contact <A style="TEXT-DECORATION: none" 
  	 href="mailto:sxj@dhu.edu.cn" >sxj@dhu.edu.cn</A>
</center>
</body>
</html>