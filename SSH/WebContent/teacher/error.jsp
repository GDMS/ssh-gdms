<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>错误</title>
		<meta http-equiv="refresh" content="3; url=teacher/main.jsp">
	</head>

	<body>
		<br />
		<br />
		<br />
		<br />
		<center>
			<font style="font-size: 24px;"> <s:actionerror /> </font>
			<br />
			<font style="font-size: 24px;">操作无效，3秒后返回主页</font>
			<br />
			<a href="teacher/main.jsp" style="font-size: 18px;">如不返回请单击这里</a>
		</center>
	</body>
</html>