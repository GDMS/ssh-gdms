function gotoPage(totalPage) {
	var pageNo = $("#pageNo").val();
	if (pageNo > 0 && pageNo <= totalPage)
		window.location.href = '/SSH/admin/subAssignedInfo.action?page='
				+ pageNo;
	else if (pageNo > totalPage)
		window.location.href = '/SSH/admin/subAssignedInfo.action?page='
				+ totalPage;
	else
		window.location.href = '/SSH/admin/subAssignedInfo.action';
};
$(document).ready(function() {
	var page = $("#page").text();
	var totalPage = $("#totalPage").text();
	if (page == 1)
		$("#pre").removeAttr("href").text("第一页");
	if (page == totalPage)
		$("#next").removeAttr("href").text("最后页");
});