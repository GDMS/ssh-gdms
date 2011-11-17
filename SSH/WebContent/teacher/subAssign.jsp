<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>教师-管理课题分配信息</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="admin/subAssignInfo.js"></script>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td id="title">
					课题分配信息：
				</td>
				<td>
					<a href="teacher/subAssign!Excel.action?printable=true">点此导出Excel</a> 
					<br />
					<br />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<font color="slategray" size="2px">注意：您可以自由选择的学生人数为<FONT
						COLOR="#ff6600">${teacher.maxassign}</font>人，在自动分配结束之后将会取消此限制。 <br>若课题及其属性为空，表示原本分配的课题已被删除，但该学生的导师依旧是您，并可以为其重新分配课题&gt;&gt;
						<A HREF="teacher/subReassign.action">点击进入</A>&nbsp;&nbsp;也可以为其更改课题名称&gt;&gt;<A
						HREF="teacher/subnameMod.action">点击进入</A> </font>
					<br />
					<br />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<TABLE>
						<TR>
							<TD class="tableTop">
								学号
							</TD>
							<TD class="tableTop">
								姓名
							</TD>
							<TD class="tableTop">
								课题名称
							</TD>
							<TD class="tableTop">
								课题类型
							</TD>
							<TD class="tableTop">
								课题性质
							</TD>
							<TD class="tableTop">
								承担方式
							</TD>
							<TD class="tableTop">
								分配形式
							</TD>
							<TD class="tableTop">
								学生详细信息
							</TD>
							<TD class="tableTop">
								删除
							</TD>
						</TR>
						<s:iterator value="thesiss" var="thesis" status="st">
							<tr>
								<s:if test="student==null">
									<td class="tableDetail">
										未选择
									</td>
									<td class="tableDetail">
										未选择
									</td>
								</s:if>
								<s:else>
									<td class="tableDetail">
										<s:property value="student.studentno" />
									</td>
									<td class="tableDetail">
										<s:property value="student.name" />
									</td>
								</s:else>

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
									<s:property value="assigned" />
								</td>
								<td class="tableDetail">
									<s:url id="viewUrl" action="subAssign" namespace="/teacher"
										method="view">
										<s:param name="studentNo" value="student.studentno"></s:param>
									</s:url>
									<s:a href="%{viewUrl}">查看
						</s:a>
								</td>
								<td class="tableDetail">
									<s:url id="delUrl" action="subAssign" namespace="/teacher"
										method="delete">
										<s:param name="studentNo" value="student.studentno"></s:param>
									</s:url>
									<s:a href="%{delUrl}">删除
						</s:a>
								</td>
							</tr>
						</s:iterator>
					</TABLE>
					<br>
				</td>
			</tr>
		</table>
		<center>
			<A HREF="teacher/main.jsp">返回</A>
		</center>
	</body>
</html>