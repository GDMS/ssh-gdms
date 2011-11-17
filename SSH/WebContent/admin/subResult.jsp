<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>教师-管理课题信息</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="admin/subAssignInfo.js"></script>
		<table align="center" width="740px" >
			<tr valign="top">
				<td id="title">
					您已提交的课题信息：
				</td>
				<td>
					<span style="test-align: right;"><input type="button"
							value="点此导出Excel" onclick="window.open('excelTViewSub.do')" /> </span>
					<br />
					<br />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<FONT COLOR="slategray">注意：每个教师注册的课题数不能超过自己的可指导学生数。您的可指导学生数为<s:property
							value="teacher.subnum" />个。</font>
					<br />
					<br />
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
						</TR>
						<s:iterator value="thesiss" var="thesis" status="st">
							<tr>
								<td class="tableDetail">
									<s:property value="name" />
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
							</tr>
						</s:iterator>
					</TABLE>
					<br>
				</td>
			</tr>
		</table>
		<center>
			<a href="admin/teacherInfo!query.action">返回</a>
		</center>
	</body>
</html>