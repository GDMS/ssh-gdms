<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-数据库管理</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>

		<br>

		<table width="841" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="378" height="35" valign="top">
					<FONT SIZE="+1" COLOR="#ff6600">管理数据库</FONT>
				</td>
				<td rowspan="3" width="200" align="right" valign="top">
					<table width="100%" border="0" cellspacing="2" cellpadding="4">
						<tr class="tableHeading">
							<td>
								<B><FONT COLOR="white"> 提示信息：</FONT> </B>
							</td>
						</tr>
						<tr bgcolor="#dcdcdc">
							<td>
								&nbsp;&nbsp;
								<font color=slategray>可以在此进行数据库管理操作。</font>
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
						请输入需要执行的SQL语句：
					</p>
					<!-- TODO: input action mapping here -->
					<s:form action="/DBOper" method="post">
						<table align="center">
							<tr valign="baseline">
								<s:textarea property="sql" rows="5" cols="50" value="">
								</s:textarea>
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
			<A HREF="admin/dbOperate.jsp">返回</A>
		</center>


	</body>
</html>