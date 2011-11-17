<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-管理学生课题分配信息-查看课题信息</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>

		
		<br>

		<FONT SIZE="+1" COLOR="#ff6600">该课题的详细信息：</FONT>
		<br>
		<br>
		<FONT COLOR="slategray">注意：若课题属性为空，表示该课题已被修改或删除。</font>
		<br>
		<br>
		<TABLE CELLSPACING="2" CELLPADDING="5" BORDER="0">
			<TR>
				<TD width="320" ALIGN="center" class="tableTop">
					课题名称
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					指导老师
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					题目类型
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					题目性质
				</TD>
				<TD width="115" ALIGN="center" class="tableTop">
					承担方式
				</TD>
			</TR>

			<tr bgcolor="#dcdcdc">
				<td align="center" class="tableDetail">
					<s:property value="thesis.name"/>
				</td>
				<td align="center" class="tableDetail">
					<s:property value="thesis.teacher.name"/>
				</td>
				<td align="center" class="tableDetail">
					<s:property value="thesis.type"/>
				</td>
				<td align="center" class="tableDetail">
					<s:property value="thesis.property"/>
				</td>
				<td align="center" class="tableDetail">
					<s:property value="thesis.mode"/>
				</td>
			</tr>

		</TABLE>
		<br>
		<center>
			<A HREF="admin/subAssignInfo.action">返回</A>
		</center>

	</body>
</html>