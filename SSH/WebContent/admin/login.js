/**
 * admin/login.jsp
 */
//$(document).ready(function() {
//			// 输入用户名
//			$("#name").val("输入用户名");
//			$("#name").focus(function() {
//						var value = $(this).val();
//						if (value == "输入用户名") {
//							$(this).val("");
//						}
//					});
//			$("#name").blur(function() {
//						var value = $(this).val();
//						if (value == "") {
//							$(this).val("输入用户名");
//						}
//					});
			// 输入6位以上密码
//			$("#password").val("输入6位以上密码");
//			$("#password").focus(function() {
//						var value = $(this).val();
//						if (value == "输入6位以上密码") {
//							$(this).val("");
//						}
//					});
//			$("#password").blur(function() {
//						var value = $(this).val();
//						if (value == "") {
//							$(this).val("输入6位以上密码");
//						}
//					});
//		});

$(document).ready(function() {
			if ($("#actionerror").text().length > 0)
				$("#actionerror").dialog({
							title : '出错信息！',
							modal : true,
							buttons : {
								Ok : function() {
									$(this).dialog("close");
								}
							}
						});
			if ($("#fielderror").text().length > 0)
				$("#fielderror").dialog({
							title : '出错信息！',
							modal : true,
							buttons : {
								Ok : function() {
									$(this).dialog("close");
								}
							}
						});
		});