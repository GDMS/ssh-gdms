<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>教师-取回密码</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td align="left">
					<table border="0px" width="450;">
						<tr valign="top">
							<td id="title">
								取回密码页面
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
														请输入您的信息：
													</td>
												</tr>
												<tr>
													<td id="box">
														<s:form theme="simple" action="teacherForgetPassword"
															namespace="/anonymous" method="post">
															<table border="0px">
																<tr valign="top">
																	<td class="textfield_label">
																		教工号：
																	</td>
																	<td id="name">
																		<s:textfield theme="simple" cssClass="textfield"
																			name="teacherno" size="20" />
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		姓名：
																	</td>
																	<td id="name">
																		<s:textfield theme="simple" cssClass="textfield"
																			name="name" size="20" />
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
								请从您的注册邮箱中获取您的密码。
								<hr SIZE="3">
								<font color=#ff6600><s:actionerror /> </font>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<center>
			<A HREF="student/main.jsp">返回</A>
		</center>



	</body>
</html>

