<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>管理员-查看视图</title>
		<link rel="stylesheet" type="text/css" href="css/headrow.css">
	</head>

	<body>
		<table align="center" width="740px" border="0px">
			<tr valign="top">
				<td>
					<div height="60px" valign="middle" align="left"
						style="color: #ff8800; font-size: 23; padding-top: 10px;">
						<b>管理员查看视图</b>
					</div>
					<div id="thirdcol">
						<div id="mainmenu">
							<ul>
								<li>
									<A href="admin/views1!query.action">差生分配结果</A>
								</li>
								<li>
									<A href="admin/views2!query.action">差生预选情况</A>
								</li>
								<li>
									<A href="admin/views3!query.action">教师指导学生名单</A>
								</li>
								<li>
									<A href="admin/views4!query.action">教师指导学生数</A>
								</li>
								<li>
									<A href="admin/views5!query.action">未分配学生数</A>
								</li>
								<li>
									<A href="admin/views6!query.action">学生预选信息</A>
								</li>
								<li>
									<A href="admin/views7!query.action">学生毕业设计成绩信息</A>
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
							&nbsp;请选择需要查看的视图。
							</font>
							<hr SIZE="3">
							<font color="#ff6600"><s:actionerror />
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
