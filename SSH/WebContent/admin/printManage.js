function gotoPage(totalPage) {
	var pageNo = $("#pageNo").val();
	if (pageNo > 0 && pageNo <= totalPage)
		window.location.href = 'admin/printManage!adminuse.action?page=' + pageNo;
	else
		window.location.href = 'admin/printManage!adminuse.action';
};
$(document).ready(function() {
			var page = $("#page").text();
			var totalPage = $("#totalPage").text();
			if (page == 1)
				$("#pre").removeAttr("href").text("");
			if (page == totalPage)
				$("#next").removeAttr("href").text("");
		});