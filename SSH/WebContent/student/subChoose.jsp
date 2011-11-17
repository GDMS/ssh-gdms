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
							<TD class="tableTop">
								选择
							</TD>
						</TR>
						<s:iterator value="thesiss" var="thesis" status="st">
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
									<s:property value="%{num[#st.index]}" />
								</td>
								<td class="tableDetail">
									<a href="student/subChoose!select.action?thesisno=${thesisno}">选择</a>
								</td>
							</tr>
						</s:iterator>
					</TABLE>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div style="font-size: 13px;">
						第
						<span id="page">${page}</span>页，共
						<span id="totalPage">${totalPage}</span>页
						<a id="pre" href="student/subChoose!query.action?page=${page-1}">上一页</a>
						，
						<a id="next" href="student/subChoose!query.action?page=${page+1}">下一页</a>
						转到：第
						<input type=text id="pageNo" size=1 value="${page}">
						页
						<input type=button id="go" value=GO
							onclick="gotoPage(${totalPage})">
					</div>
				</td>
			</tr>
		</table>
		<center>
			<a HREF="student/main.jsp">返回</a>
		</center>
	</body>
</html>