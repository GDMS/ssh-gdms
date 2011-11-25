$(document).ready(function() {
	var type = $("#sessionType").text();
	if (type == 2)
		$("#actionmessage").dialog({
			title : '重要通知',
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