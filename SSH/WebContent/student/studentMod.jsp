<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>学生-修改个人信息</title>
<link rel="stylesheet" type="text/css" href="css/master.css">
</head>

<body>
	<table align="center" width="740px" border="0px">
		<tr valign="top">
			<td align="left">
				<table border="0px" width="450;">
					<tr valign="top">
						<td id="title">修改注册信息页面</td>
					</tr>
					<tr>
						<td>
							<table width="auto">
								<tr valign="top">
									<td width="120px;"></td>
									<td>
										<table>
											<tr valign="top">
												<td id="info">请输入你的注册信息：</td>
											</tr>
											<tr>
												<td><font color="red"><s:actionmessage /></font></td>
											</tr>
											<tr>
												<td id="box"><s:form theme="simple" action="studentMod"
														namespace="/student" method="post">
														<table border="0px">
															<tr valign="top">
																<td class="textfield_label">学号：</td>
																<td id="name"><s:textfield theme="simple"
																		cssClass="textfield" name="student.studentno"
																		value="%{student.studentno}" size="20" readonly="true" />
																	<br></td>
															</tr>
															<tr valign="top">
																<td class="textfield_label">姓名：</td>
																<td id="name"><s:textfield theme="simple"
																		cssClass="textfield" name="student.name"
																		value="%{student.name}" size="20" /> <br></td>
															</tr>
															<tr>
																<td class="radio_label">性别：</td>
																<td id="sex"><s:radio theme="simple"
																		cssClass="radio" name="student.gender"
																		list="%{#{'男':'男','女':'女'}}" value="%{student.gender}" />
																	<br></td>
															</tr>
															<tr>
																<td>
																	<table class="select">
																		<tr>
																			<td class="select_label">专业：</td>
																		</tr>
																		<tr>
																			<td class="select_label">班级：</td>
																		</tr>
																	</table>
																</td>
																<td style="padding-top: 7px"><s:doubleselect
																		name="majorno" list="major" listKey="majorno"
																		listValue="name"
																		value="student.stuClass.major.majorno"
																		cssClass="select1" doubleName="classno"
																		doubleList="classname.get(top.majorno)"
																		doubleValue="student.stuClass.classno"
																		doubleListKey="classno" doubleListValue="name"
																		doubleCssClass="select2" /></td>
															</tr>
															<tr>
																<td class="textfield_label">学分绩点：</td>
																<td><s:textfield theme="simple" id="credit"
																		name="student.credit" value="%{student.credit}"
																		size="6" cssClass="textfield" /> <br></td>
															</tr>
															<tr>
																<td class="textfield_label">联系电话：</td>
																<!--<td><s:textfield  id="phone" name="student.phone" value="%{student.phone}" size="32"/><br></td> -->
																<td><s:textfield theme="simple" id="phone"
																		name="student.phone" value="%{student.phone}"
																		size="20" cssClass="textfield" /> <br></td>
															</tr>
															<tr>
																<td class="textfield_label">电子邮箱：</td>
																<td><s:textfield theme="simple" id="email"
																		name="student.email" value="%{student.email}"
																		size="50" cssClass="textfield" /> <br></td>
															</tr>
															<tr valign="baseline">
																<td nowrap align="right">&nbsp; <br>
																</td>
																<td><s:submit theme="simple" type="image"
																		value="提交" src="images/submit.png" /> <br></td>
															</tr>
														</table>
													</s:form></td>
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
						<td class="tableHeading">系统提示:</td>
					</tr>
					<tr bgcolor="#dcdcdc">
						<td class="tableInfo">请提交你的真实信息。系统将在指定的日期后停止接受注册信息。
							<hr SIZE="3"> <font color=#ff6600><s:actionerror />
						</font>
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

