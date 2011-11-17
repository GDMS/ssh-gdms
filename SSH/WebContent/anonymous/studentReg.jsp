<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>注册新学生</title>
		<link rel="stylesheet" type="text/css" href="css/master.css">
		<script type="text/javascript" src="/SSH/anonymous/studentReg.js"></script>
	</head>
	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td align="left">
					<table border="0px" width="450;">
						<tr valign="top">
							<td id="title">
								注册信息页面
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
														请输入你的注册信息：
													</td>
												</tr>
												<tr>
													<td>
														<div align="center">
															<font color="red"><s:actionerror id="actionerror" />
															</font>
															<br />
															<font color="red"><s:fielderror id="fielderror" />
															</font>
														</div>
													</td>
												</tr>
												<tr>
													<td id="box">
														<s:form theme="simple" action="studentReg" id="RegForm"
															namespace="/anonymous" method="post">
															<table border="0px">
																<tr valign="top">
																	<td class="textfield_label">
																		学 号：
																	</td>
																	<td id="name">
																		<s:textfield theme="simple" cssClass="textfield"
																			id="studentno" name="student.studentno" size="32" />

																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		密 码：
																	</td>
																	<td id="name">
																		<s:password theme="simple" cssClass="textfield"
																			id="password" name="student.password" size="32" />
																		<br>
																	</td>
																</tr>
																<tr valign="top">
																	<td class="textfield_label">
																		姓 名：
																	</td>
																	<td id="name">
																		<s:textfield theme="simple" cssClass="textfield"
																			id="name" name="student.name" size="32" />
																		<br>
																	</td>
																</tr>
																<tr>
																	<td class="radio_label">
																		性 别：
																	</td>
																	<td id="sex">
																		<s:radio theme="simple" cssClass="radio"
																			name="student.gender" list="%{#{'男':'男','女':'女'}}" />
																		<br>
																	</td>
																</tr>
																<tr>
																	<td>
																		<table class="select">
																			<tr>
																				<td class="select_label">
																					专业：
																				</td>
																			</tr>
																			<tr>
																				<td class="select_label">
																					班级：
																				</td>
																			</tr>
																		</table>
																	</td>
																	<td style="padding-top: 7px">
																		<s:doubleselect name="majorno" list="major"
																			listKey="majorno" listValue="name"
																			value="student.stuClass.major.majorno"
																			cssClass="select1" doubleName="classno"
																			doubleList="classname.get(top.majorno)"
																			doubleValue="student.stuClass.classno"
																			doubleListKey="classno" doubleListValue="name"
																			doubleCssClass="select2"></s:doubleselect>
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label">
																		学分绩点：
																	</td>
																	<td>
																		<s:textfield theme="simple" id="credit"
																			name="student.credit" value="%{student.credit}"
																			size="32" cssClass="textfield" />
																		<br>
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label">
																		联系电话：
																	</td>
																	<!--<td><s:textfield  id="phone" name="student.phone" value="%{student.phone}" size="32"/><br></td> -->
																	<td>
																		<s:textfield theme="simple" id="phone"
																			name="student.phone" value="%{student.phone}"
																			size="32" cssClass="textfield" />
																		<br>
																	</td>
																</tr>
																<tr>
																	<td class="textfield_label">
																		电子邮箱：
																	</td>
																	<td>
																		<s:textfield theme="simple" id="email"
																			name="student.email" value="%{student.email}"
																			size="32" cssClass="textfield" />
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
								<font color=slategray>请提交你的真实信息。系统将在指定的日期后停止接受注册信息。</font>
								<hr SIZE="3">
								<font color=#ff6600><s:actionerror /> </font>
							</td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
		<center>
			<A HREF="#">返回</A>
		</center>
		<script type="text/javascript">
	$("#studentno")
			.focusout(
					function() {
						var studentno = $("#studentno").val();
						if (studentno == "") {
							$("#error_studentno").remove();
							var div = "<div id='error_studentno' style='color:#FF0000'>请输入学号</div>";
							$("#studentno").after(div);
						} else {
							$("#error_studentno").remove();
						}
					});

	$("#password")
			.focusout(
					function() {
						var password = $("#password").val();
						if (password == "") {
							$("#error_password").remove();
							var div = "<div id='error_password' style='color:#FF0000'>请输入密码</div>";
							$("#password").after(div);
						} else {
							$("#error_password").remove();
						}
					});

	$("#credit")
			.focusout(
					function() {
						reg = /^[0-9]d*.d*|0.d*[0-9]d*$/;
						reg_ = /^[0-9]d*$/;
						var credit = $("#credit").val();
						if (credit == "") {
							$("#error_credit").remove();
							var div = "<div id='error_credit' style='color:#FF0000'>请输入绩点</div>";
							$("#credit").after(div);
						} else if (!(reg.test(credit) || reg_.test(credit))) {
							$("#error_credit").remove();
							var div = "<div id='error_credit' style='color:#FF0000'>请输入正确的绩点</div>";
							$("#credit").after(div);
						} else if (credit > 5 || credit < 0) {
							$("#error_credit").remove();
							var div = "<div id='error_credit' style='color:#FF0000'>绩点无效</div>";
							$("#credit").after(div);
						} else {
							$("#error_credit").remove();
						}
					});
	$("#email")
			.focusout(
					function() {
						reg = /^[\w-]+(\.[\w-]+)*@[\w-]+(\.[\w-]+)+$/;
						var email = $("#email").val();
						if (email == "") {
							$("#error_email").remove();
							var div = "<div id='error_email' style='color:#FF0000'>请输入Email</div>";
							$("#email").after(div);
						} else if (!(reg.test(email))) {
							$("#error_email").remove();
							var div = "<div id='error_email' style='color:#FF0000'>请输入正确的Email</div>";
							$("#email").after(div);
						} else {
							$("#error_email").remove();
						}
					});
</script>
	</body>
</html>

