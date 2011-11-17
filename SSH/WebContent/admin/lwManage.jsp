<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-论文管理</title>
		<link rel="stylesheet" type="text/css" href="css/headrow.css">
	</head>

	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td>
					<div height="60px" valign="middle" align="left"
						style="color: #ff8800; font-size: 23; padding-top: 10px;">
						<b>论文管理页面</b>
					</div>
					<div id="thirdcol">
						<div id="mainmenu">
							<ul>
								<li>
									<A href="admin/lwAdd.jsp">新增论文</A>
								</li>
								<li>
									<A href="admin/lwDel!query.action">删除论文</A>
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
							&nbsp;可以增加或删除论文。
							</font>
							<hr SIZE="3">
							<font color=#ff6600><s:actionerror />
							</font>
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
