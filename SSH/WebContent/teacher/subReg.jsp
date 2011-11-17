<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>教师-注册新课题</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td align="left">
					<table border="0px" width="450;">
						<tr valign="top">
							<td id="title">
								课题信息提交页面
							</td>
						</tr>
						<tr>
							<td>
								<table width="auto">
									<tr valign="top">
										<td width="60px;"></td>
										<td>
											<table>
												<tr valign="top">
													<td id="info">
														请输入相关信息：
													</td>
												</tr>
												<tr>
													<td id="box">
														<s:form theme="simple" action="subReg"
															namespace="/teacher" method="post">
															<table border="0px">
																<tr>
																	<td class="textfield_label">
																		课题名称：
																	</td>
																	<td id="name">
																		<s:textfield theme="simple" cssClass="textfield"
																			name="thesis.name" size="32" />
																		<br>
																	</td>
																</tr>
																<tr>
																	<td align="right">
																		<table class="select" style="padding-right: -10px;">
																			<tr>
																				<td class="select_label">
																					题目类型：
																				</td>
																			</tr>
																		</table>
																	</td>
																	<td style="padding-top: 0px;">
																		<s:select list="#{'设计类':'设计类 ','软件设计类':'软件设计类','课题研究类':'课题研究类','其他类':'其他类'}" name="thesis.type"></s:select>
																	</td>
																</tr>
																<tr>
																	<td align="right">
																		<table class="select">
																			<tr style="padding-right: -3px">
																				<td class="select_label" >
																					题目性质：
																				</td>
																			</tr>
																		</table>
																	</td>
																	<td style="padding-top: 0px;">
																		<s:select list="#{'纵向课题':'纵向课题 ','横向课题':'横向课题','自选课题':'自选课题','模拟课题':'模拟课题','其他':'其他'}"
																			name="thesis.property"></s:select>
																	</td>
																</tr>
																<tr>
																	<td class="radio_label">
																		承担方式：
																	</td>
																	<td id="sex">
																		<s:radio theme="simple" cssClass="radio"
																			name="thesis.mode" list="%{#{'独立':'独立','部分':'部分'}}"
																			value="'独立'" />
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
								每个教师注册的课题数不能超过自己的可指导学生数。
								<hr SIZE="3">
								题目类型说明：
								<br>
								&nbsp;1.设计类
								<br>
								&nbsp;2.软件设计类
								<br>
								&nbsp;3.课题研究类
								<br>
								&nbsp;4.其他类
								<hr SIZE="3">
								题目性质说明：
								<br>
								&nbsp;1.纵向课题
								<br>
								&nbsp;2.横向课题
								<br>
								&nbsp;3.自选课题
								<br>
								&nbsp;4.模拟课题
								<br>
								&nbsp;5.其他
								<hr SIZE="3">
								<font color="#ff6600"><s:actionerror /> </font>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<center>
			<A HREF="teacher/main.jsp">返回</A>
		</center>



	</body>
</html>

