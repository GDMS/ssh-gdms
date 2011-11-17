<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">

<html>
	<head>
		<title>学生-更改课题名称</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td align="left">
					<table border="0px" width="450;">
						<tr valign="top">
							<td id="title">
								课题名称修改页面
							</td>
						</tr>
						<tr>
							<td>
								<table width="auto">
									<tr valign="top">
										<td width="100px;"></td>
										<td>
											<table>
												<tr valign="top">
													<td id="info">
														请输入您要修改的信息：
													</td>
												</tr>
												<tr>
													<td id="box">
														<s:form theme="simple" action="subNameMod"
															namespace="/student" method="post">
															<table border="0px">
																<tr valign="top">
																	<td class="textfield_label">
																		教师姓名：
																	</td>
																	<td id="name">
																		<s:textfield theme="simple" cssClass="textfield"
																			value="%{student.thesis.teacher.name}" size="24"
																			readonly="true" />
																		<br>
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label">
																		原课题名称：
																	</td>
																	<td>
																		<s:textfield cssClass="textfield" theme="simple"
																			value="%{student.thesis.name}" size="24"
																			readonly="true" />
																		<br>
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label">
																		新课题名称：
																	</td>
																	<td>
																		<s:textfield cssClass="textfield" theme="simple"
																			id="subname" name="newstudent.thesis.name" />
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
								只有最终分配到课题后才能修改论文题目。请根据导师要求修改！
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

