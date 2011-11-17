/**
 * student/login.jsp
 */
//$(document).ready(function() {
			// 输入9位学号
//			$("#no").val("输入9位学号");
//			$("#no").focus(function() {
//						var value = $(this).val();
//						if (value == "输入9位学号") {
//							$(this).val("");
//						}
//					});
//			$("#no").blur(function() {
//						var value = $(this).val();
//						if (value == "") {
//							$(this).val("输入9位学号");
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