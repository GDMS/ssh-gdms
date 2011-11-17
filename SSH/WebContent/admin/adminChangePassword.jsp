<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员修改密码</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td align="left">
					<table border="0px" width="450;">
						<tr valign="top">
							<td id="title">
								修改密码页面
							</td>
						</tr>
						<tr>
							<td>
								<table width="auto">
									<tr valign="top">
										<td width="120px;"></td>
										<td>
											<table>
												<tr valign="top">
													<td id="info">
														<s:actionmessage />
														<s:actionerror />
														请输入你的信息：
													</td>
												</tr>
												<tr>
													<td id="box">
														<s:form theme="simple" action="adminPassword"
															namespace="/admin" method="post">
															<table border="0px">
																<tr valign="top">
																	<td class="textfield_label">
																		管理员帐号:
																	</td>
																	<td id="name">
																		<s:property value="%{admin.name}"/>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		旧密码：
																	</td>
																	<td id="name">
																		<s:password theme="simple" cssClass="textfield"
																			name="oldPassword" size="20" />
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		新密码：
																	</td>
																	<td id="name">
																		<s:password theme="simple" cssClass="textfield"
																			name="newPassword" size="20" />
																		<br>
																	</td>
																</tr>
																<tr valign="baseline">
																	<td nowrap align="right">
																		&nbsp;
																		<br>
																	</td>
																	<td>
																		<s:submit theme="simple" type="image" value="提交"
																			src="images/submit.png" />
																		<br>
																	</td>
																</tr>
															</table>
														</s:form>
													</td>
												</tr>
											</table>
										</td>
									</tr>
								</table>
							</td>
						</tr>
					</table>
				</td>
				<td></td>
				<td id="cue" align="right">
					<table style="padding-top: 10px">
						<tr>
							<td class="tableHeading">
								系统提示:
							</td>
						</tr>
						<tr bgcolor="#dcdcdc">
							<td class="tableInfo">
								您的密码修改后请重新登录验证密码是否修改<br/>
								如有错误请联系其他管理员。
								<hr SIZE="3">
								<font color=#ff6600><s:actionerror /> </font>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<center>
			<A HREF="admin/main.jsp">返回</A>
		</center>



	</body>
</html>

