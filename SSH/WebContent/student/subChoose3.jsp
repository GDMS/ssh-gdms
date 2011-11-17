<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>学生-选择课题</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="student/subChoose.js"></script>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td id="title">
					已注册的课题信息：
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<TABLE>
						<TR>
							<TD class="tableTop">
								课题名称
							</TD>
							<TD class="tableTop">
								指导老师
							</TD>
							<TD class="tableTop">
								题目类型
							</TD>
							<TD class="tableTop">
								题目性质
							</TD>
							<TD class="tableTop">
								承担方式
							</TD>
							<TD class="tableTop">
								已被预选次数
							</TD>
							<s:iterator value="thesiss" var="thesis">
								<tr>
									<td class="tableDetail">
										<s:property value="name" />
									</td>
									<td class="tableDetail">
										<s:property value="teacher.name" />
									</td>
									<td class="tableDetail">
										<s:property value="type" />
									</td>
									<td class="tableDetail">
										<s:property value="property" />
									</td>
									<td class="tableDetail">
										<s:property value="mode" />
									</td>
									<td class="tableDetail">
										<s:property value="assigned" />
									</td>
								</tr>
							</s:iterator>
					</TABLE>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<font color="slategray" size="2px">预选次序:${order}</font>
				</td>
			</tr>
			<tr>
				<td>
					<font color="slategray" size="2px">提交完成!</font>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div style="color: red; font-size: x-large;">
						<s:actionerror id="actionError" />
					</div>
				</td>
			</tr>
		</table>

		<center>
			<A HREF="student/subResult.action">返回</A>
		</center>
	</body>
</html>