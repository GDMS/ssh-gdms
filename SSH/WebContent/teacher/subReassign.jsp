<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>教师-重新分配课题</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<script type="text/javascript" src="admin/subAssignInfo.js"></script>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td id="title">
					您指导的学生及课题：
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<font color="slategray" size="2px">注意：如果学生的原课题为空，表示原本分配的课题已被删除。</font>
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
								性别
							</TD>
							<TD class="tableTop">
								专业
							</TD>
							<TD class="tableTop">
								班级
							</TD>
							<TD class="tableTop">
								学分绩点
							</TD>
							<TD class="tableTop">
								重新分配
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
									<td class="tableDetail">
										<s:property value="name" />
									</td>
									<td class="tableDetail">
										未选择
									</td>
									<td class="tableDetail">
										未选择
									</td>
									<td class="tableDetail">
										未选择
									</td>
									<td class="tableDetail">
										未选择
									</td>
									<td class="tableDetail">
										<a href="teacher/preview.action">选择学生</a>
									</td>
								</s:if>
								<s:else>
									<td class="tableDetail">
										<s:property value="student.studentno" />
									</td>
									<td class="tableDetail">
										<s:property value="student.name" />
									</td>
									<td class="tableDetail">
										<s:property value="name" />
									</td>
									<td class="tableDetail">
										<s:property value="student.gender" />
									</td>
									<td class="tableDetail">
										<s:property value="student.stuClass.major.name" />
									</td>
									<td class="tableDetail">
										<s:property value="student.stuClass.name" />
									</td>
									<td class="tableDetail">
										<s:property value="student.credit" />
									</td>
									<td class="tableDetail">
										<a href="teacher/subAssign.action">重新分配</a>
									</td>
								</s:else>
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