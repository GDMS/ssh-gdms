<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>关于我们</title>
		<style type="text/css">
.STYLE1 {
	font-family: "宋体";
	font-size: 24px
}

.STYLE2 {
	font-family: "宋体";
	font-size: 18px
}
</style>
	</head>
	<body>
		<br />
		<center>
			<h1 style="color: #0000FF" class="STYLE1">
				The Graduate Design Management System of DHU
			</h1>
		</center>
		<br />
		<br />
		<p align="center">
			<span class="STYLE2">本系统为毕业管理系统，使用Struts2+Spring+Hibernate流行开发框架。</span>
			<br />
			<span class="STYLE2">由08级李琦宇完成软件架构设计，居雯平，郦俊杰，沈喆参与开发。<br />
				目前由李琦宇进行维护。联系方式：QQ 105628009</span>
		</p>
		<div id="dxw" align="center"
			style="visibility: hidden; color: grey; font-size: 12px">
			感谢丁祥武老师对本次实验中搭建SSH框架的大力支持
		</div>
		<br />
		<div align="center">
			2011年11月11日 11:11 PM
		</div>
		<script language="javascript">
	$(function() {
		var title = "关于我们";
		var $dxw = $("#dxw");
		var $title = $("title");
		$("p").mouseover(function() {
			$dxw.css('visibility', 'visible');
			$title.text($dxw.text());
		}).mouseleave(function() {
			$dxw.css('visibility', 'hidden');
			$title.text(title);
		});
	});
</script>
	</body>

</html>
