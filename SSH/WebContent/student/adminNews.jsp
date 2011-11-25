<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入Struts2标签库 --%>
<%@taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>学生-查看管理员通知</title>
<link rel="stylesheet" type="text/css" href="css/master.css">
</head>

<body>
	<table align="center" width="740px" border="0px">
		<tr valign="top">
			<td align="left">
				<table border="0px" width="450;">
					<tr valign="top">
						<td id="title">学生查看管理员通知页面</td>
					</tr>
					<tr>
						<td>
							<table width="auto">
								<tr valign="top">
									<td width="120px;"></td>
									<td>
										<table>
											<tr valign="top">
												<td id="info">请留意：</td>
											</tr>
											<tr>
												<td id="box" class="textfield_label" style="text-align: left;">各位同学：<br>
													<textarea style="WIDTH: 282px; HEIGHT: 86px" rows=3 cols=32
														readonly="readonly">${sessionScope.sessionNews}</textarea>
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
		</tr>
	</table>

	<center>
		<a HREF="student/main.jsp">返回</a>
	</center>
</body>
</html>