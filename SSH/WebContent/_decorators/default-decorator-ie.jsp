<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%-- 引入SiteMesh标签库 --%>
<%@ taglib uri="http://www.opensymphony.com/sitemesh/decorator"
	prefix="decorator"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta http-equiv="keywords" content="GDMS,李琦宇,沈喆,郦俊杰,居雯平">
		<meta http-equiv="description" content="GDMS">
		<title>欢迎进入ＧＤＭＳ： <decorator:title />
		</title>
		<!-- jQuery -->
		<script type="text/javascript"
			src="http://ajax.googleapis.com/ajax/libs/jquery/1.6.1/jquery.min.js"></script>
		<script>
	!window.jQuery
			&& document
					.write('<script src="http://ajax.aspnetcdn.com/ajax/jQuery/jquery-1.6.1.min.js"><\/script>');
</script>
		<script type="text/javascript"
			src="https://ajax.googleapis.com/ajax/libs/jqueryui/1.8.12/jquery-ui.min.js"></script>
		<link rel="stylesheet" type="text/css"
			href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.12/themes/start/jquery-ui.css">
		<!-- jQuery Finish -->

		<link rel="stylesheet" type="text/css" href="_decorators/base.css" />
		<link rel="stylesheet" type="text/css"
			href="_decorators/default-decorator.css" />
		<script type="text/javascript" src="_decorators/default-decorator.js"></script>
		<script type="text/javascript" src="_decorators/jquery.layout.js"></script>
		<script type="text/javascript"
			src="_decorators/jquery-simpleTreeMenu-1.0.1.js"></script>
		<link rel="stylesheet" href="css/jquery-simpleTreeMenu-1.0.1.css" />

		<decorator:head />
	</head>

	<body>
		<!-- 引入JavaScript -->
		<script>
	var outerLayout;
	$(document).ready(function() {
		outerLayout = $('body').layout({
			applyDefaultStyles : false,
			center__paneSelector : ".outer-center",
			north__paneSelector : ".outer-north",
			south__paneSelector : ".outer-south",
			west__paneSelector : ".outer-west",
			west__size : 210,
			//south__size : 55,
			spacing_open : 5, // ALL panes
			spacing_closed : 7, // ALL panes
			north_spacing_open : 0,
			south_spacing_open : 0,
			showOverflowOnHover : false,
			north__resizable : false,
			north__slidable : false,
			south__resizable : false,
			south__slidable : false
		});
	});
</script>
		<script type="text/javascript">
	$(document).ready(function() {
		$('.tree').simpleTreeMenu();
		var type = $("#sessionType").text();
		if (type == 1) {
			$('#studentMainpage').click();
		}
		if (type == 2) {
			$('#teacherMainpage').click();
		}
		if (type == 3) {
			$('#adminMainpage').click();
		}
	});
	$(function() {
		if ($("#sessionType").text().length >= 0) {
			$("#message_box").show();
			//scroll the message box to the top offset of browser's scrool bar
			$(window).scroll(function() {
				$('#message_box').animate({
					top : $(window).scrollTop() + "px"
				}, {
					queue : false,
					duration : 350
				});
			});
			//when the close button at right corner of the message box is clicked 
			$("#close_message").click(function() {
				//the messagebox gets scrool down with top property and gets hidden with zero opacity 
				$("#message_box").animate({
					top : "+=15px",
					opacity : 0
				}, "slow");
				$("#message_box").hide();
			});
		} else
			$("#message_box").hide();
	});
</script>
		<style media="all" type="text/css">
#message_box {
	position: absolute;
	top: 0;
	left: 0;
	z-index: 10;
	background: #ffc;
	padding: 5px;
	border: 1px solid #CCCCCC;
	text-align: center;
	font-weight: bold;
	width: 99%;
}
</style>
		<div id="message_box">
			<img id="close_message" style="float: right; cursor: pointer"
				src="_decorators/img/12-em-cross.png" />
			本系统不推荐使用IE系列浏览器！请下载
			<a href="http://www.google.com/chrome/?hl=zh-CN">谷歌(Chrome)浏览器</a>
			<a href="http://firefox.com.cn/">火狐(FireFox)浏览器</a>
			<font style="color: red;">推荐使用<a
				href="http://www.chromeplus.org/">枫叶(ChromePlus)浏览器</a> </font>
		</div>
		<!-- !! Header Start-->
		<div class="outer-north" style="background-color: #C7D4E4">
			<div id="header">
				<div id="logo">
					<h1>
						<IMG height=59 alt=Logo src="images/logo.png">
					</h1>
					<h2>
						The Graduate Design Management System of DHU
					</h2>
				</div>
			</div>
			<div id="menu-wrap">
				<div id="menu">
					<ul>
						<li class="first">
							<a href="index.jsp" accesskey="1" title="">主页</a>
						</li>
						<li>
							<a href="student/login.jsp" accesskey="2" title="">学生登录</a>
						</li>
						<li>
							<a href="teacher/login.jsp" accesskey="3" title="">教师登录</a>
						</li>
						<li>
							<a href="admin/login.jsp" accesskey="4" title="">管理员登录</a>
						</li>
						<li>
							<a href="aboutus.jsp" accesskey="5" title="">关于我们</a>
						</li>
					</ul>
				</div>
			</div>

		</div>
		<!-- --------------------------------------------------------- -->
		<!-- !! Header Finish-->
		<!-- --------------------------------------------------------- -->
		<!-- --------------------------------------------------------- -->
		<div id="navigatorWrap" class="outer-west"
			style="background-color: #FFFFFF">
			<div id="navigator">
				<!-- Session Bar -->
				<div id="session">
					<br>
					<span id="sessionName">${sessionScope.sessionName}</span>
					<div id="session-meta" style="visibility: hidden; display: none;">
						<span id="sessionType">${sessionScope.sessionType}</span>
						<span id="sessionId">${sessionScope.sessionId}</span>
					</div>
				</div>
				<!-- Tree -->
				<div style="width: auto; padding-top: 5px; padding-left: 20px;">
					<ul class="tree">
						<li id="studentMain">
							<span id="studentMainpage">学生主页</span>
							<ul>
								<li>
									<a href="student/main.jsp">主页</a>
								</li>
								<li>
									<a href="student/studentMod!query.action">修改个人信息</a>
								</li>
								<li>
									<a href="student/subChoose!query.action">选择课题</a>
								</li>
								<li>
									<a href="student/subResult.action">管理预选课题</a>
								</li>
								<li>
									<a href="student/subAssign.action">查看课题分配结果</a>
								</li>
								<li>
									<a href="student/subAssign!query.action">更改课题名称</a>
								</li>
								<li>
									<a href="student/kt-reportUp.jsp">开题报告提交</a>
								</li>
								<li>
									<a href="student/assignmentUp.jsp">任务书提交</a>
								</li>
								<li>
									<a href="student/translateUp.jsp">翻译资料提交</a>
								</li>
								<li>
									<a href="student/midternCheck!query.action">中期自检</a>
								</li>
								<li>
									<a href="student/thesisUp.jsp">论文提交</a>
								</li>
								<li>
									<a href="student/qaInput!query.action">答辩信息输入</a>
								</li>
								<li>
									<a href="student/studentPassword!studentquery.action"> 学生修改密码 </a>
								</li>
								<li>
									<a href="logout.action">学生注销</a>
								</li>
							</ul>
						</li>
						<li id="teacherMain">
							<span id="teacherMainpage">教师主页</span>
							<ul>
								<li>
									<a href="teacher/main.jsp">主页</a>
								</li>
								<li>
									<a href="teacher/teacherMod!query.action">修改个人信息</a>
								</li>
								<li>
									<a href="teacher/subReg!query.action">注册新的课题</a>
								</li>
								<li>
									<a href="teacher/subResult.action">管理您的课题信息</a>
								</li>
								<li>
									<a href="teacher/subAssign.action">管理您的课题分配信息</a>
								</li>
								<li>
									<a href="teacher/preview.action">查看学生预选情况</a>
								</li>
								<li>
									<a href="teacher/subReassign.action">为学生重新分配课题</a>
								</li>
								<li>
									<a href="teacher/subnameMod.action">为学生更改课题名称</a>
								</li>
								<li>
									<a href="teacher/fileManage.action">文档管理</a>
								</li>
								<li>
									<a href="teacher/teaMidternCheck.action">中期检查</a>
								</li>
								<li>
									<a href="teacher/gradeInput!query.action"> 输入学生论文成绩和评语 </a>
								</li>
								<li>
									<a href="teacher/gradeSplit!query.action"> 分数拆分 </a>
								</li>
								<li>
									<a href="teacher/printManage.action"> 打印管理 </a>
								</li>
								<li>
									<a href="teacher/teacherPassword!teacherquery.action"> 教师修改密码 </a>
								</li>
								<li>
									<a href="logout.action"> 教师注销 </a>
								</li>
							</ul>
						</li>
						<li id="adminMain">
							<span id="adminMainpage">管理员主页</span>
							<ul>
								<li>
									<a href="admin/main.jsp"> 主页 </a>
								</li>
								<li>
									<a href="admin/newsRelease!query.action"> 信息发布 </a>
								</li>
								<li>
									<a href="admin/teacherReg!query.action"> 注册新教师 </a>
								</li>
								<li>
									<a href="admin/majorReg.action"> 新增专业班级 </a>
								</li>
								<li>
									<a href="admin/pyManage.action"> 管理评语 </a>
								</li>
								<li>
									<a href="admin/studentPercent.jsp"> 设置预选学生比例 </a>
								</li>
								<li>
									<a href="admin/dbOperate.jsp"> 数据库操作 </a>
								</li>
								<li>
									<a href="admin/lwManage.jsp"> 论文管理 </a>
								</li>
								<li>
									<a href="admin/viewSelect.jsp"> 查看视图 </a>
								</li>
								<li>
									<a href="admin/studentInfo!query.action"> 管理学生信息 </a>
								</li>
								<li>
									<a href="admin/teacherInfo!query.action"> 管理教师信息 </a>
								</li>
								<li>
									<a href="admin/subInfoManage!query.action"> 管理课题信息 </a>
								</li>
								<li>
									<a href="admin/studentPreviewInfo!query.action"> 管理学生预选信息 </a>
								</li>
								<li>
									<a href="admin/subAssignInfo.action"> 管理学生课题分配信息 </a>
								</li>
								<li>
									<a href="admin/subAssignedInfo.action"> 管理已分配信息 </a>
								</li>
								<li>
									<a href="admin/assignAuto!query.action"> 自动分配 </a>
								</li>
								<li>
									<a href="admin/printManage!adminuse.action"> 打印管理 </a>
								</li>
								<li>
									<a href="admin/adminPassword!adminquery.action"> 管理员修改密码 </a>
								</li>
								<li>
									<a href="logout.action"> 管理员注销 </a>
								</li>
							</ul>
						</li>
						<li id="studentReg">
							<a href="anonymous/studentReg!query.action">学生注册</a>
						</li>
					</ul>
				</div>
				<!-- Tree Close -->
			</div>
		</div>
		<div id="mainbodyWrap" class="outer-center">
			<div id="mainbody" style="min-height: 400px; margin: auto;">
				<!-- Body位置 -->
				<decorator:body />
			</div>
		</div>
		<!-- --------------------------------------------------------- -->
		<!-- --------------------------------------------------------- -->
		<!-- !! Footer Start-->
		<div id="footer" class="outer-south" style="background-color: #C7D4E4">
			<center>
				<br>
				Copyright 2011 东华大学 计算机科学与技术学院
				<br>
				你可以联系
				<A style="TEXT-DECORATION: none" href="mailto:sxj@dhu.edu.cn">sxj@dhu.edu.cn</A>
			</center>

		</div>
		<!-- !! Footer Finish-->
	</body>
</html>