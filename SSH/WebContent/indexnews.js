$(document).ready(function() {
			// 判断是否是IE
			// if ($.browser.msie) {
			// window.location.href = 'errorpage/iealert.jsp';
			// return;
			// }
			var $dialog = $("#dialog");
			$dialog.hide();
			if ($("#sessionType").text().length == 0)
				$dialog.hide().dialog({
							modal : true,
							minHeight : 200,
							minWidth : 350,
							buttons : {
								Ok : function() {
									$(this).dialog("close");
								}
							}
						});

		});