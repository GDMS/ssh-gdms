<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-管理教师信息-查看注册课题-删除</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>

		
		<br>



		<table width="841" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="378" height="35" valign="top">
					<FONT SIZE="+1" COLOR="#ff6600">课题删除页面</FONT>
				</td>
				<td rowspan="3" width="200" align="right" valign="top">
					<table width="100%" border="0" cellspacing="2" cellpadding="4">
						<tr class="tableHeading">
							<td>
								<STRONG><FONT color=#ffffff>提示信息：</FONT> </STRONG>&nbsp;
							</td>
						</tr>
						<tr bgcolor="#dcdcdc">
							<td>
								<font color=slategray>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;课题删除后，已被分配到该课题的学生的课题名称将被同时删除，
									但该学生的导师不变，并可以为其重新分配课题，也可以为其更改课题名称。</font>
								<hr SIZE="3">
								<font color="ff6600"> <s:actionerror /> </font>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="405" valign="top">
					<p>
						请确认你的所要删除的课题：
					</p>
					<s:form action="/adminDeleteSubject" method="post">
						<table align="center">
							<tr valign="baseline">
								<td class="tableHeading" nowrap align="right" width=100>
									教师姓名：
								</td>
								<td>
									<s:textfield property="tutor" size="32" value="tutor"
										readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td class="tableHeading" nowrap align="right" width=100>
									课题名称：
								</td>
								<td>
									<s:textfield property="subname" size="32" value="subname"
										readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td class="tableHeading" nowrap align="right" width=100>
									课题类型：
								</td>
								<td>
									<s:textfield property="type" size="32" value="type"
										readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td class="tableHeading" nowrap align="right" width=100>
									指导属性：
								</td>
								<td>
									<s:textfield property="property" size="32" value="property"
										readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td class="tableHeading" nowrap align="right" width=100>
									课题模式：
								</td>
								<td>
									<s:textfield property="mode" size="32" value="mode"
										readonly="true" />
								</td>
							</tr>

							<tr valign="baseline">
								<td>
									<s:submit
										style="BORDER-RIGHT: 1px solid; BORDER-TOP: 1px solid; BORDER-LEFT: 1px solid; BORDER-BOTTOM: 1px solid"
										onfocus="true">
										<!-- <bean!:message!!! key="form.delete" /> -->
									</s:submit>

								</td>
							</tr>
						</table>
					</s:form>
				</td>
			</tr>
		</table>

		<center>
			<A HREF="admin/subRegView.jsp">返回</A>
		</center>
	</body>
</html>

