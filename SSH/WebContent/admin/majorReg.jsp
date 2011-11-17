<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-新增专业班级</title>
		<link rel="stylesheet" type="text/css" href="css/headrow.css">
	</head>

	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td>
					<div height="60px" valign="middle" align="left"
						style="color: #ff8800; font-size: 23; padding-top: 10px;">
						<b>新增专业班级页面</b>
					</div>
					<div id="thirdcol">
						<div id="mainmenu">
							<ul>
								<li>
									<A href="admin/majorAdd!query.action">新增专业</A>
								</li>
								<li>
									<A href="admin/classnoAdd!query.action">新增班级</A>
								</li>
								<li>
									<A href="admin/majorDel!query.action">删除专业</A>
								</li>
								<li>
									<A href="admin/classnoDel!query.action">删除班级</A>
								</li>
							</ul>
						</div>
					</div>
				</td>
				<td width="15%">
					<div class="table_area">
						<div class="table_top">
							提示信息
						</div>
						<div class="table_bodyarea_help">
							&nbsp;可以增加新的专业与班级。
							</font>
							<hr SIZE="3">
							<font color=#ff6600><s:actionerror /> </font>
						</div>
						<div class="table_bottom"></div>
					</div>
				</td>
			</tr>
		</table>

		<center>
			<A HREF="admin/main.jsp">返回</A>
		</center>
	</body>
</html>
