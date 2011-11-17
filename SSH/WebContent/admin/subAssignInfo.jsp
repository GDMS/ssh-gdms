<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-管理学生课题分配信息</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="admin/subAssignInfo.js"></script>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td id="title">
					所有注册学生的课题分配信息：
				</td>
				<td>
				<a href="admin/subAssignInfo!Excel.action?printable=true">点此导出Excel</a> 
					<br>
					<br>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<font color="slategray" size="2px">注意：若课题名称及指导老师为空，表示该学生未被分配；若只有课题名称为空，表示该学生有导师但原本分配的课题已被删除。<br>
						删除当前分配功能对未分配的学生也可用，但数据库中的数据不会改变。要为已分配的学生分配课题前请先删除当前分配。</font>
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
								指导老师
							</TD>
							<TD class="tableTop">
								分配形式
							</TD>
							<TD class="tableTop">
								学生详细信息
							</TD>
							<TD class="tableTop">
								课题详细信息
							</TD>
							<TD class="tableTop">
								删除当前分配
							</TD>
							<TD class="tableTop">
								分配课题
							</TD>
						</TR>
						<s:iterator value="students" var="student" status="st">
							<tr>
								<td class="tableDetail">
									<s:property value="studentno" />
								</td>
								<td class="tableDetail">
									<s:property value="name" />
								</td>
								<s:if test="thesis==null||thesis.isEmpty()">
									<td class="tableDetail">
										未选择
									</td>
									<td class="tableDetail">
										未选择
									</td>
									<td class="tableDetail">
										未分配
									</td>
								</s:if>
								<s:else>
									<td class="tableDetail">
										<s:property value="thesis.name" />
									</td>
									<td class="tableDetail">
										<s:property value="thesis.teacher.name" />
									</td>
									<td class="tableDetail">
										<s:property value="autoassign" />
									</td>
								</s:else>
								<td class="tableDetail">
									<A
										HREF="admin/studentAssignDetail.action?studentNo=${student.studentno}">查看</A>
								</td>
								<td class="tableDetail">
									<A
										HREF="admin/subAssignDetail.action?thesisNo=${student.thesis.thesisno}">查看</A>
								</td>
								<td class="tableDetail">
									<A
										HREF="admin/subAssignDel!query.action?studentNo=${student.studentno}">删除</A>
								</td>
								<td class="tableDetail">
									<A
										HREF="admin/subAssign!query.action?studentNo=${student.studentno}">分配</A>
								</td>
							</tr>
						</s:iterator>
					</table>
					<br />
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<div style="font-size: 13px;">
						第
						<span id="page">${page}</span>页，共
						<span id="totalPage">${totalPage}</span>页
						<a id="pre" href="admin/subAssignInfo.action?page=${page-1}">上一页</a>
						，
						<a id="next" href="admin/subAssignInfo.action?page=${page+1}">下一页</a>
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
			<A HREF="admin/main.jsp">返回</A>
		</center>

	</body>
</html>