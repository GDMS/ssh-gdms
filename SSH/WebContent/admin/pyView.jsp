<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-查看评语</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>


		<table width="841" border="0" cellpadding="0" cellspacing="0">
			<tr>
				<td width="378" height="35" valign="top">
					<FONT SIZE="+1" COLOR="#ff6600">教师查看评语</FONT>
				</td>
				<td rowspan="3" width="200" align="right" valign="top">
					<table width="100%" border="0" cellspacing="2" cellpadding="4">
						<tr class="tableHeading">
							<td>
								<B><FONT COLOR="white">系统提示：</FONT> </B>
							</td>
						</tr>
						<tr bgcolor="#dcdcdc">
							<td>
								<font color=slategray>请留意，各项内容输入的字数应保持在150个汉字以内，包括空格以及标点。</font>
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
						请查看需要发布的评语：
					</p>
					<table align="center">
						<s:form action="/adminNewPY" method="post">
							<s:submit
								style="BORDER-RIGHT: 1px solid; BORDER-TOP: 1px solid; BORDER-LEFT: 1px solid; BORDER-BOTTOM: 1px solid"
								onfocus="true">
			            	新增评语
			            </s:submit>
						</s:form>
						<s:form action="/adminAddzdpy" method="post">
							<tr valign="baseline">
								<td class="tableHeading" nowrap align="right" valign="top">
									zdpingyu:
								</td>
								<td>
									<s:textfield property="lv" value="lv" readonly="true">
									</s:textfield>
									<s:textfield property="lvNo" value="String.valueOf(lvNo)"
										readonly="true">
									</s:textfield>
									<s:textarea property="zdpingyu" value="zdpingyu"
										style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
								</td>
							</tr>
							<tr valign="baseline">
								<td>
									<s:submit
										style="BORDER-RIGHT: 1px solid; BORDER-TOP: 1px solid; BORDER-LEFT: 1px solid; BORDER-BOTTOM: 1px solid"
										onfocus="true">
			            		保存
			            	</s:submit>
								</td>
							</tr>
						</s:form>
						<s:form action="/adminAddpypy" method="post">
							<tr valign="baseline">
								<td class="tableHeading" nowrap align="right" valign="top">
									pypingyu:
								</td>
								<td>
									<s:textfield property="lv" value="lv" readonly="true">
									</s:textfield>
									<s:textfield property="lvNo" value="String.valueOf(lvNo)"
										readonly="true">
									</s:textfield>
									<s:textarea property="pypingyu" value="pypingyu"
										style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
								</td>
							</tr>
							<tr valign="baseline">
								<td>
									<s:submit
										style="BORDER-RIGHT: 1px solid; BORDER-TOP: 1px solid; BORDER-LEFT: 1px solid; BORDER-BOTTOM: 1px solid"
										onfocus="true">
			            		保存
			            	</s:submit>
								</td>
							</tr>
						</s:form>
						<s:form action="/adminAdddbpy" method="post">
							<tr valign="baseline">
								<td class="tableHeading" nowrap align="right" valign=top>
									dbpingyu:
								</td>
								<td>
									<s:textfield property="lv" value="lv" readonly="true">
									</s:textfield>
									<s:textfield property="lvNo" value="String.valueOf(lvNo)"
										readonly="true">
									</s:textfield>
									<s:textarea property="dbpingyu" value="dbpingyu"
										style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
								</td>
							</tr>
							<tr valign="baseline">
								<td>
									<s:submit
										style="BORDER-RIGHT: 1px solid; BORDER-TOP: 1px solid; BORDER-LEFT: 1px solid; BORDER-BOTTOM: 1px solid"
										onfocus="true">
			            		保存
			            	</s:submit>
								</td>
							</tr>
						</s:form>

					</table>

				</td>
			</tr>
		</table>
		<center>
			<A HREF="admin/printManage.jsp">返回</A>
		</center>

	</body>
</html>
