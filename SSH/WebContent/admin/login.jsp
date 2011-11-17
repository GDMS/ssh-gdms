<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员登录</title>
		<link rel="stylesheet" type="text/css" href="css/login.css">
		<script type="text/javascript" src="admin/login.js"></script>
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
					<s:form action="adminLogin" namespace="/admin">
						<table id="admin" class="box" style="border: 0px solid #000;">
							<tr>
								<td>
									<table>
										<tr style="border: 2px">
											<td class=user_main_text>
												工 号：
											</td>
											<td class=user_main_input>
												<s:textfield theme="simple" id="name"
													cssClass="TxtUserNameCssClass" name="administrator.name" />
											</td>
										</tr>
										<tr>
											<td class=user_main_text>
												密 码：
											</td>
											<td class=user_main_input>
												<s:password theme="simple" id="password"
													cssClass="TxtPassWordCssClass" name="administrator.password" />
											</td>
										</tr>
									</table>
									<table>
										<tr>
											<td class=pw_forget>
												<a href="#">忘记密码?</a>
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
