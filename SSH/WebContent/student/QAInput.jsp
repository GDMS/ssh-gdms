<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>学生-答辩信息输入</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td align="left">
					<table border="0px" width="450;">
						<tr valign="top">
							<td id="title">
								答辩信息输入页面
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
														请输入你的答辩信息：
													</td>
												</tr>
												<tr>
													<td id="box" width="509">
														<s:form theme="simple" action="qaInput"
															namespace="/student" method="post">
															<table border="0px">
																<tr valign="top">
																	<td class="textfield_label">
																		对于毕业课题的摘要的描述：
																	</td>
																	<td id="name">
																		<s:textarea id="projDesc" name="studentscore.projDesc"
																			value="%{studentscore.projDesc}"
																			style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		对于毕业课题的特点的描述：
																	</td>
																	<td id="name">
																		<s:textarea id="thesDesc" name="studentscore.thesDesc"
																			value="%{studentscore.thesDesc}"
																			style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		答辩时第一个问题：
																	</td>
																	<td id="name">
																		<s:textarea id="question1"
																			name="studentscore.question1"
																			value="%{studentscore.question1}"
																			style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		第一个问题的回答：
																	</td>
																	<td id="name">
																		<s:textarea id="answer1" name="studentscore.answer1"
																			value="%{studentscore.answer1}"
																			style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		答辩时第二个问题：
																	</td>
																	<td id="name">
																		<s:textarea id="question2"
																			name="studentscore.question2"
																			value="%{studentscore.question2}"
																			style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		第二个问题的回答：
																	</td>
																	<td id="name">
																		<s:textarea id="answer2" name="studentscore.answer2"
																			value="%{studentscore.answer2}"
																			style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		答辩时第三个问题：
																	</td>
																	<td id="name">
																		<s:textarea id="question3"
																			name="studentscore.question3"
																			value="%{studentscore.question3}"
																			style="WIDTH: 282px; HEIGHT: 86px" rows="3" cols="32" />
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		第三个问题的回答：
																	</td>
																	<td id="name">
																		<s:textarea id="answer3" name="studentscore.answer3"
																			value="%{studentscore.answer1}"
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

