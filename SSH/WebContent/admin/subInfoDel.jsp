<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-管理课题信息-删除</title>
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
					<s:form action="subInfoManage" namespace="/admin" method="post">
						<table align="center">
							<tr valign="baseline">
								<td class="tableHeading" nowrap align="right" width=100>
									课题名称：
								</td>
								<td>
									<s:textfield size="44" value="%{thesis.name}"
										readonly="true" />
								</td>
							</tr>
							<tr valign="baseline">
								<td class="tableHeading" nowrap align="right" width=100>
									课题编号：
								</td>
								<td>
								<s:textfield size="44" value="%{thesis.thesisno}" name="thesisno" readonly="true" />
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
			<A HREF="admin/subInfoManage!query.action">返回</A>
		</center>

	</body>
</html>

