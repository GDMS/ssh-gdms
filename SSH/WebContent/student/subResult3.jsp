<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>学生-管理预选课题</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="admin/subAssignInfo.js"></script>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td id="title">
					你已选择的课题信息：
				</td>
			</tr>
			<tr>
				<td colspan="1">
					<font color="slategray" size="2px">注意：若发现选了重复的课题，请选择任意一条重复信息进行删除，再重新选择此课题，以防影响课题分配及志愿调整。若课题的属性为空，表示此课题信息已被删除。这不会影响课题分配。<br>
						预选课题的志愿顺序可调整，若没有反应请刷新。继续选择课题&gt;&gt; <A
						HREF="student/subChoose!query.action">点击进入</A> </font>
					<br />
					<br />
				</td>
			</tr>
			<tr>
				<td colspan="1">
					<font color="slategray" size="2px">对不起，你的操作无效的！</font>
				</td>
			</tr>
		</TABLE>
		<br>
		<br>
		<center>
			<A HREF="student/subResult.action">返回</A>
		</center>
	</body>
</html>