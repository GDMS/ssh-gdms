<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>教师-修改添加学生信息</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td align="left">
					<table border="0px" width="450;">
						<tr valign="top">
							<td id="title">
								中期检查页面
							</td>
						</tr>
						<tr>
							<td>
								<table width="auto">
									<tr valign="top">
										<td width="30px;"></td>
										<td>
											<table>
												<tr valign="top">
													<td id="info">
														请输入您为该同学输入评语：
													</td>
												</tr>
												<tr>
													<td id="box">
														<s:form theme="simple" action="teacherSetRemark"
															namespace="/teacher" method="post">
															<table border="0px">
																<tr valign="top">
																	<td class="textfield_label">
																		学 号:
																	</td>
																	<td id="name">
																		<s:textfield theme="simple" cssClass="textfield"
																			value="%{student.studentno}" name="student.studentno"
																			readonly="true"></s:textfield>
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		姓 名:
																	</td>
																	<td id="name">
																		<s:textfield theme="simple" cssClass="textfield"
																			value="%{student.name}" readonly="true"></s:textfield>
																		<br>
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label">
																		工作进度:
																	</td>
																	<td>
																		<s:textarea style="WIDTH: 282px; HEIGHT: 86px"
																			rows="3" cols="32"
																			value="%{student.studentScore.progress}"
																			readonly="true"></s:textarea>
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label">
																		质 量:
																	</td>
																	<!--<td><s:textfield  id="phone" name="student.phone" value="%{student.phone}" size="32"/><br></td> -->
																	<td>
																		<s:textarea style="WIDTH: 282px; HEIGHT: 86px"
																			rows="3" cols="32"
																			value="%{student.studentScore.quality}"
																			readonly="true"></s:textarea>
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label">
																		工作态度:
																	</td>
																	<td>
																		<s:textarea style="WIDTH: 282px; HEIGHT: 86px"
																			rows="3" cols="32"
																			value="%{student.studentScore.attitude}"
																			readonly="true"></s:textarea>
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label">
																		出勤情况:
																	</td>
																	<td>
																		<s:textarea style="WIDTH: 282px; HEIGHT: 86px"
																			rows="3" cols="32"
																			value="%{student.studentScore.duty}" readonly="true"></s:textarea>
																	</td>
																</tr>
															
																<tr>
																	<td>
																		<table class="select">
																			<tr>
																				<td class="select_label">
																					添加警告:
																				</td>
																			</tr>
																		</table>
																	</td>
																	<td style="padding-top: 0px; margin-left: -137px;">
																		<s:select list="%{#{'':'','黄':'黄','红':'红'}}"
																			value="%{student.studentScore.warn}"
																			name="student.studentScore.warn"></s:select>
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
								&nbsp;&nbsp;
								<font color=slategray>如果学生各项内容为空，表明该生还没有提交自己的中期检查信息。</font>
								<hr SIZE="3">
								&nbsp;&nbsp;
								<font color=slategray>请注意学生的添加警告选项，默认选择为无。</font>
								<hr SIZE="3">
								&nbsp;&nbsp;
								<font color=slategray>请您留意输入的评语应在150个汉字以内，包括空格以及标点。</font>
								<hr SIZE="3">
								<font color="#ff6600"><s:actionerror /> </font>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>

		<center>
			<A HREF="teacher/teaMidternCheck.action">返回</A>
		</center>



	</body>
</html>

