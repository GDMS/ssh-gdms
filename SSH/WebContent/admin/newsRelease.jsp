<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>管理员-信息发布</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td align="left">
					<table border="0px" width="450;">
						<tr valign="top">
							<td id="title">
								消息更新页面
							</td>
						</tr>
						<tr>
							<td>
								<table>
									<tr valign="top">
										<td width="0px;"></td>
										<td>
											<table>
												<tr valign="top">
													<td id="info">
														请输入要发布的信息：
													</td>
												</tr>
												<tr>
													<td id="box" width="509">
														<s:form theme="simple" action="newsRelease" method="post"
															namespace="/admin">
															<table border="0px">
																<tr valign="top">
																	<td class="textfield_label">
																		对所有人的消息:
																	</td>
																	<td id="name">
																		<s:textarea name="news.msgToAll"
																			value="%{news.msgToAll}"
																			style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		对老师发布的消息:
																	</td>
																	<td id="name">
																		<s:textarea name="news.msgToTea"
																			value="%{news.msgToTea}"
																			style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		对学生发布的消息:
																	</td>
																	<td id="name">
																		<s:textarea name="news.msgToStu"
																			value="%{news.msgToStu}"
																			style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
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

				<td id="cue" align="right">
					<table style="padding-top: 10px">
						<tr>
							<td class="tableHeading">
								系统提示:
							</td>
						</tr>
						<tr bgcolor="#dcdcdc">
							<td class="tableInfo">
								请留意，各项内容输入的字数应保持在150个汉字以内，包括空格以及标点。
								</font>
								<hr SIZE="3">
								<font color="#ff6600"><s:actionerror /> </font>
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

