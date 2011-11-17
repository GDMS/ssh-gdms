function gotoPage(totalPage) {
	var pageNo = $("#pageNo").val();
	if (pageNo > 0 && pageNo <= totalPage) {
		var ie = !-[ 1, ];
		if (!-[ 1, ])
			window.location.href = 'subChoose!query.action?page=' + pageNo;
		else
			window.location.href = 'student/subChoose!query.action?page='
					+ pageNo;
	} else {
		if (!-[ 1, ])
			window.location.href = 'subChoose!query.action';
		else
			window.location.href = 'student/subChoose!query.action';
	}
};
$(document).ready(function() {
	var page = $("#page").text();
	var totalPage = $("#totalPage").text();
	if (page == 1)
		$("#pre").removeAttr("href").text("第一页");
	if (page == totalPage)
		$("#next").removeAttr("href").text("最后页");
});