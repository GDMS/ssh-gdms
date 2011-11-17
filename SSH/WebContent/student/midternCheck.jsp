<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>学生-中期自检</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td align="left">
					<table border="0px" width="450;">
						<tr valign="top">
							<td id="title">
								中期自检页面
							</td>
						</tr>
						<tr>
							<td>
								<table width="auto">
									<tr valign="top">
										<td width="40px;"></td>
										<td>
											<table>
												<tr valign="top">
													<td id="info">
														请输入你的中期自检信息：
													</td>
												</tr>
												<tr>
													<td id="box">
														<s:form theme="simple" action="midternCheck"
															namespace="/student" method="post">
															<table border="0px">
																<tr valign="top">
																	<td class="textfield_label">
																		警告提示：
																	</td>
																	<td id="name">
																		<s:textfield 
																			value="%{studentScore.warn}"
																			style="WIDTH: 20px; HEIGHT: 20px" readonly="true" />
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		工作进度：
																	</td>
																	<td id="name">
																		<s:textarea name="studentScore.progress"
																			value="%{studentScore.progress}"
																			style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		质&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;量：
																	</td>
																	<td id="name">
																		<s:textarea name="studentScore.quality"
																			value="%{studentScore.quality}"
																			style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		工作态度：
																	</td>
																	<td id="name">
																		<s:textarea name="studentScore.attitude"
																			value="%{studentScore.attitude}"
																			style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		出勤情况：
																	</td>
																	<td id="name">
																		<s:textarea name="studentScore.duty"
																			value="%{studentScore.duty}"
																			style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
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
								请留意，各项内容输入的字数应保持在150个汉字以内，包括空格以及标点。
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

