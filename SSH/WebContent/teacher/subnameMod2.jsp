<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>教师-更改课题名称</title>

	</head>

	<body>

		<table width="841" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="378" height="35" valign="top">
					<FONT SIZE="+1" COLOR="#ff6600">课题名称修改页面</FONT>
				</td>
				<td rowspan="3" width="200" align="right" valign="top">
					<table width="100%" border="0" cellspacing="2" cellpadding="4">
						<tr class="tableHeading">
							<td>
								<B><FONT COLOR="white">提示信息：</FONT> </B>
							</td>
						</tr>
						<tr bgcolor="#dcdcdc">
							<td>
								<font color=slategray>只有最终分配到课题后才能修改论文题目。请根据导师要求修改！</font>
								<hr SIZE="3">
								<font color="#ff6600"><s:actionerror /> </font>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="405" valign="top">
					<p>
						请输入您要修改的信息：
					</p>
					<s:form action="subnameMod!changename" namespace="/teacher" method="post">
						<table align="center">
						<tr valign="baseline">
							
								<td class="tableHeading" nowrap align="right" width=70>
									课题编号
								</td>
								<td>
									<s:textfield id="thesisno" name="thesis.thesisno" size="24"
										style="WIDTH: 199px; HEIGHT: 22px" readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
							
								<td class="tableHeading" nowrap align="right" width=70>
									学生学号
								</td>
								<td>
									<s:textfield value="%{thesis.student.studentno}" size="24"
										style="WIDTH: 199px; HEIGHT: 22px" readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
							
								<td class="tableHeading" nowrap align="right" width=70>
									学生姓名
								</td>
								<td>
									<s:textfield value="%{thesis.student.name}" size="24"
										style="WIDTH: 199px; HEIGHT: 22px" readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
							
								<td class="tableHeading" nowrap align="right" width=70>
									教师姓名
								</td>
								<td>
									<s:textfield value="%{teacher.name}" size="24"
										style="WIDTH: 199px; HEIGHT: 22px" readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td class="tableHeading" nowrap align="right">
									原课题名称
								</td>
								<td>
									<s:textfield value="%{thesis.name}" size="24"
										style="WIDTH: 199px; HEIGHT: 22px" readonly="true" />
								</td>
							</tr>

							<tr valign="baseline">
								<td class="tableHeading" nowrap align="right">
									新课题名称
								</td>
								<td>
									<s:textfield id="name" name="newthesis.name" />
								</td>
							</tr>
							<tr valign="baseline">

								<td nowrap align="right">
									&nbsp;
								</td>
								<td>
									<s:submit value="確定"
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
			<a HREF="teacher/main.jsp">返回</a>
		</center>
	</body>
</html>