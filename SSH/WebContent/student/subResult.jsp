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
					<TABLE>
						<TR>
							<TD class="tableTop">
								志愿顺序
							</TD>
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
								删除
							</TD>
							<TD class="tableTop">
								调整志愿顺序
							</TD>
						</TR>
						<s:iterator value="previews" var="preview" status="st">
							<tr>
								<td class="tableDetail">
									<s:property value="suborder" />
								</td>
								<td class="tableDetail">
									<s:property value="%{thesiss[#st.index].name}" />
								</td>
								<td class="tableDetail">
									<s:property value="%{thesiss[#st.index].teacher.name}" />
								</td>
								<td class="tableDetail">
									<s:property value="%{thesiss[#st.index].type}" />
								</td>
								<td class="tableDetail">
									<s:property value="%{thesiss[#st.index].property}" />
								</td>
								<td class="tableDetail">
									<s:property value="%{thesiss[#st.index].mode}" />
								</td>
								<td class="tableDetail">
									<s:property value="%{num[#st.index]}" />
									<!-- num -->
								</td>
								<td class="tableDetail">

									<s:url id="delUrl" action="subResult" namespace="/student"
										method="delete">
										<s:param name="No" value="previewno"></s:param>
									</s:url>
									<s:a href="%{delUrl}">删除
					</s:a>

								</td>
								<td class="tableDetail">
									<s:url id="upUrl" action="subResult" namespace="/student"
										method="Up">
										<s:param name="No" value="previewno"></s:param>
									</s:url>
									<s:a href="%{upUrl}">↑
						</s:a>
									&nbsp;&nbsp;
									<s:url id="downUrl" action="subResult" namespace="/student"
										method="Down">
										<s:param name="No" value="previewno"></s:param>
									</s:url>
									<s:a href="%{downUrl}">↓</s:a>
								</td>
							</tr>
						</s:iterator>
					</TABLE>
					<br>
					<br>
				</td>
			</tr>
		</table>
		<center>
			<A HREF="student/main.jsp">返回</A>
		</center>
	</body>
</html>