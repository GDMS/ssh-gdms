<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-自动分配</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="admin/assignauto.js"></script>
		<br>

		<FONT SIZE="+1" COLOR="#ff6600">所有学生的课题分配信息：<s:actionerror />
			<s:actionmessage /> </font>
		<a href="admin/assignAuto!query.action">点此返回查看结果</a>
	</body>



</html>

