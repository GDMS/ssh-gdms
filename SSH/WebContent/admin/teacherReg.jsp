<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-注册新教师</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
	</head>

	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td align="left">
					<table border="0px" width="450;">
						<tr valign="top">
							<td id="title">
								教师注册页面
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
														请输入教师的注册信息：
													</td>
												</tr>
												<tr>
													<td id="box">
														<s:form theme="simple" action="teacherReg"
															namespace="/admin" method="post">
															<table border="0px">
																<tr valign="top">
																	<td class="textfield_label">
																		姓名：
																	</td>
																	<td id="name">
																		<s:textfield theme="simple" cssClass="textfield"
																			name="teacher.name" size="32" />
																	</td>
																</tr>
																<tr>
																	<td align="right">
																		<table class="select" style="padding-right: -10px;">
																			<tr>
																				<td class="select_label">
																					系别：
																				</td>
																			</tr>
																		</table>
																	</td>
																	<td style="padding-top: 0px;">
																		<s:select name="deptno" list="teacherDept"
																			listKey="deptno" listValue="name"></s:select>
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label" style="padding-top: 3px">
																		可指导学生数：
																	</td>
																	<td>
																		<s:textfield theme="simple" id="credit"
																			name="teacher.subnum" size="32" />
																		<br>
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label" style="padding-top: 3px">
																		教师最大指派数：
																	</td>
																	<!--<td><s:textfield  id="phone" name="student.phone" value="%{student.phone}" size="32"/><br></td> -->
																	<td>
																		<s:textfield theme="simple" id="phone"
																			name="teacher.maxassign" size="32" />
																		<br>
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label" style="padding-top: 3px">
																		教工号：
																	</td>
																	<td>
																		<s:textfield theme="simple" id="email"
																			name="teacher.teacherno" size="32" />
																		<br>
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label" style="padding-top: 3px">
																		密码：
																	</td>
																	<td>
																		<s:password theme="simple" id="email"
																			name="teacher.password" size="32" />
																		<br>
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label" style="padding-top: 3px">
																		电话号码：
																	</td>
																	<td>
																		<s:textfield theme="simple" id="email"
																			name="teacher.tel" size="32" />
																		<br>
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label" style="padding-top: 3px">
																		E-mail：
																	</td>
																	<td>
																		<s:textfield theme="simple" id="email"
																			name="teacher.mail" size="32" />
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
								注册成功后，系统将自动返回登录页面。
								</font>
								<hr SIZE="3">
								<font color=#ff6600><s:actionerror />
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

