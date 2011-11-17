<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>学生登录</title>
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<script type="text/javascript" src="student/login.js"></script>
		<!-- <script type="text/javascript">
		//密码显示为（*）号
	function tostar() {
		var num = document.getElementById("SPassword").value;
		var star = "";
		for ( var i = 0; i < num.length; i++) {
			star += "*";
		}
		document.getElementById("SPassword").value = star;

	}
</script> -->
	</head>

	<body>
		<div align="center" style="visibility: hidden">
			<font color="red"><s:actionerror id="actionerror" /> </font>
			<br />
			<font color="red"><s:fielderror id="fielderror" /> </font>
		</div>
		<table id="login" align="center" width="780px" height="400"
			border="0px">
			<tr>
				<td>
					<s:form action="studentLogin" namespace="/student">
						<table id="student" class="box" style="border: 0px solid #000;">
							<tr>
								<td>
									<table>
										<tr style="border: 2px">
											<td class=user_main_text>
												学 号：
											</td>
											<td class=user_main_input>
												<s:textfield theme="simple" id="no"
													cssClass="TxtUserNameCssClass" name="student.studentno" />
											</td>
										</tr>
										<tr>
											<td class=user_main_text>
												密 码：
											</td>
											<td class=user_main_input>
												<s:password theme="simple" id="password"
													cssClass="TxtPassWordCssClass" name="student.password" />
											</td>
										</tr>
									</table>
									<table>
										<tr>
											<td class=student_Reg>
												<a href="anonymous/studentReg!query.action">注册</a>
											</td>
											<td class=student_pw_forget>
												<a href="anonymous/studentForgetPassword.jsp">忘记密码?</a>
											</td>
										</tr>
									</table>
								</td>
								<td
									style="padding-right: 83px; padding-top: 8px; margin-top: 0;">
									<s:submit cssClass="button" theme="simple" type="image"
										value="提交" src="css/images/login/user_botton.png" />
								</td>
							</tr>
						</table>
					</s:form>
				</td>
			</tr>
		</table>
	</body>
</html>
