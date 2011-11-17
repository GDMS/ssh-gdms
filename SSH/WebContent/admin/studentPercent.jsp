<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-设置预选学生比例</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>

		<br>

		<table width="841" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="378" height="35" valign="top">
					<FONT SIZE="+1" COLOR="#ff6600">设置预选学生比例</FONT>
				</td>
				<td rowspan="3" width="200" align="right" valign="top">
					<table width="100%" border="0" cellspacing="2" cellpadding="4">
						<tr class="tableHeading">
							<td>
								<B><FONT COLOR="white"> 提示信息：</FONT>
								</B>
							</td>
						</tr>
						<tr bgcolor="#dcdcdc">
							<td>
								&nbsp;&nbsp;
								<font color=slategray>通过设置预选学生比例来统一设置老师能够挑选学生选择课题的总数。</font>
								<hr SIZE="3">
								<font color="#ff6600"><s:actionerror />
								</font>
							</td>
						</tr>
					</table>
				</td>
			</tr>
			<tr>
				<td height="405" valign="top">
					<p>
						请设置预选学生比例：
					</p>
					<!-- TODO: input action mapping here -->
					<s:form action="studentPercent" namespace="/admin" method="post">
						<table align="center">
							<tr valign="baseline">
								<td class="tableHeading" nowrap align="right" width=70>
									比 例：(例如20%，输入：20)
								</td>
								<td>
									<s:textfield name="percent" size="32" />
								</td>
							</tr>
							<tr valign="baseline">
								<td nowrap align="right">
									&nbsp;
								</td>
								<td>
									<s:submit theme="simple" type="image" value="提交"
									src="images/submit.png" />
								</td>
							</tr>
						</table>
					</s:form>
				</td>
			</tr>
		</table>
		<center>
			<A HREF="admin/main.jsp">返回</A>
		</center>


	</body>
</html>