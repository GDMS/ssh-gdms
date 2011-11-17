<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-管理教师信息-修改</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td align="left">
					<table border="0px" width="450;">
						<tr valign="top">
							<td id="title">
								修改教师信息页面
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
														请修改该教师的信息：
													</td>
												</tr>
												<tr>
													<td id="box">
														<s:form theme="simple" action="teacherInfoMod"
															namespace="/admin" method="post">
															<table border="0px">
																<tr valign="top">
																	<td class="textfield_label">
																		工号：
																	</td>
																	<td id="name">
																		<s:textfield theme="simple" cssClass="textfield"
																			name="teacher.teacherno" value="%{teacher.teacherno}"
																			size="20" readonly="true" />
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		姓名：
																	</td>
																	<td id="name">
																		<s:textfield theme="simple" cssClass="textfield"
																			name="teacher.name" value="%{teacher.name}" size="20" />
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		密码：
																	</td>
																	<td id="name">
																		<s:textfield theme="simple" cssClass="textfield"
																			name="teacher.password" value="%{teacher.password}"
																			size="20" />
																		<br>
																	</td>
																</tr>
																<tr>
																	<td>
																		<table class="select">
																			<tr>
																				<td class="select_label">
																					所属系别：
																				</td>
																			</tr>
																		</table>
																	</td>
																	<td style="padding-top: 0px; margin-left: -137px;">
																		<s:select name="deptno" list="teacherDept"
																			listKey="deptno" listValue="name"
																			value="teacher.teacherDept.deptno"></s:select>
																	</td>
																</tr>
																<tr valign="top">

																	<td class="textfield_label">
																		可指导学生数：
																	</td>
																	<td id="name">
																		<s:textfield theme="simple" cssClass="textfield"
																			name="teacher.subnum" value="%{teacher.subnum}"
																			size="32" />
																		<br>
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label">
																		电话号码：
																	</td>
																	<td>
																		<s:textfield theme="simple" cssClass="textfield"
																			id="tel" name="teacher.tel" value="%{teacher.tel}"
																			size="32" />
																		<br>
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label">
																		E-mail：
																	</td>
																	<!--<td><s:textfield  id="phone" name="student.phone" value="%{student.phone}" size="32"/><br></td> -->
																	<td>
																		<s:textfield theme="simple" id="mail"
																			name="teacher.mail" value="%{teacher.mail}" size="32" />
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
								如果该教师的可指导学生数发生变动，请及时修改。系统将根据修改结果，为该教师分配学生。
								<br>
								可指导学生数必须大于等于已指导学生数以及已开设的课题数。
								<hr SIZE="3">
								<font color=#ff6600><s:actionerror /> </font>
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

