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