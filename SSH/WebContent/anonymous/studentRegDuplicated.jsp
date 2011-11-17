<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>学生注册失败</title>
		<meta http-equiv="refresh" content="3; url=index.jsp">
	</head>

	<body>
		<br />
		<br />
		<br />
		<br />
		<center>
			<div align="center">
				<font color="red" size="24px"><s:actionerror id="actionerror" />
				</font>
				<br />
				<font color="red" size="24px"><s:fielderror id="fielderror" />
				</font>
			</div>
			<font style="font-size: 24px;">注册失败</font>
			<br />
			<a href="index.jsp" style="font-size: 18px;">如不返回请单击这里</a>
		</center>
	</body>
</html>

