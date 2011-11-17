<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-管理学生信息-删除</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>

		<br>


		<table width="841" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="378" height="35" valign="top">
					<FONT SIZE="+1" COLOR="#ff6600">删除学生页面</FONT>
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
								<font color=slategray>如果确认要删除的学生，就按删除按钮</font>
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
						请确认你的所要删除的学生：
					</p>
					<s:form action="studentInfo" namespace="/admin" method="post">
						<table align="center">
							<tr valign="baseline">
								<td class="tableTop" nowrap align="right" width=100>
									学生姓名：
								</td>
								<td>
									<s:textfield  size="32" value="%{student.name}" readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td class="tableTop" nowrap align="right" width=100>
									学生学号：
								</td>
								<td>
									<s:textfield  size="32" value="%{student.studentno}" name="studentno" readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td class="tableTop" nowrap align="right" width=100>
									学生性別：
								</td>
								<td>
									<s:textfield  size="32" value="%{student.gender}" readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td class="tableTop" nowrap align="right" width=100>
									学生专业：
								</td>
								<td>
									<s:textfield  size="32" value="%{student.stuClass.major.name}" readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td class="tableTop" nowrap align="right" width=100>
									学生班級：
								</td>
								<td>
									<s:textfield  size="32" value="%{student.stuClass.name}" readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td class="tableTop" nowrap align="right" width=100>
									学生积点：
								</td>
								<td>
									<s:textfield  size="32" value="%{student.credit}" readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td class="tableTop" nowrap align="right" width=100>
									学生联系方式：
								</td>
								<td>
									<s:textfield  size="32" value="%{student.phone}" readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td class="tableTop" nowrap align="right" width=100>
									学生EMAIL：
								</td>
								<td>
									<s:textfield  size="32" value="%{student.email}" readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td>
									<s:submit value="删除"
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
			<A HREF="admin/studentInfoManage.jsp">返回</A>
		</center>
	</body>
</html>

