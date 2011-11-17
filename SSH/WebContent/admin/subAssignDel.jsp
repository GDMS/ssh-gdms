<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-管理学生课题分配信息-删除当前分配</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>

		
		<br>



		<table width="841" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="378" height="35" valign="top">
					<FONT SIZE="+1" COLOR="#ff6600">删除学生的当前分配页面</FONT>
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
								<font color=slategray>删除后，该生将成为未分配课题与导师的学生！</font>
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
						请确认你所删除的分配结果：
					</p>
					<s:form action="subAssignDel" method="post" namespace="/admin">
						<table align="center">

							<tr valign="baseline">
								<td class="tableTop" nowrap align="right" width=100>
									学生学号：
								</td>
								<td>
									<s:textfield property="id" size="32" value="%{student.studentno}" readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td class="tableTop" nowrap align="right" width=100>
									学生姓名：
								</td>
								<td>
									<s:textfield size="32" value="%{student.name}"
										readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td class="tableTop" nowrap align="right" width=100>
									课题名称：
								</td>
								<td>
									<s:textfield  size="32" value="%{student.thesis.name}"
										readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td class="tableTop" nowrap align="right" width=100>
									指导老师：
								</td>
								<td>
									<s:textfield size="32" value="%{student.thesis.teacher.name}"
										readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td>
								<s:hidden name="studentNo" value="%{student.studentno}"></s:hidden>
									<s:submit value="确定"
										style="BORDER-RIGHT: 1px solid; BORDER-TOP: 1px solid; BORDER-LEFT: 1px solid; BORDER-BOTTOM: 1px solid"
										onfocus="true">
									</s:submit>

								</td>
							</tr>
						</table>
					</s:form>
				</td>
			</tr>
		</table>

		<center>
			<A HREF="admin/subAssignInfo.action">返回</A>
		</center>

	</body>
</html>