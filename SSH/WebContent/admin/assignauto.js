function gotoPage(totalPage) {
	var pageNo = $("#pageNo").val();
	if (pageNo > 0 && pageNo <= totalPage)
		window.location.href = '/SSH/admin/assignAuto!query.action?page='
				+ pageNo;
	else if (pageNo > totalPage)
		window.location.href = '/SSH/admin/assignAuto!query.action?page='
				+ totalPage;
	else
		window.location.href = '/SSH/admin/assignAuto!query.action';
};
var assignMethod = 1;
function assignAuto() {
	window.location.href = '/SSH/admin/assignAuto.action?assignMethod='
			+ assignMethod;
}
function assignClean() {
	window.location.href = '/SSH/admin/assignAuto.action?assignMethod=0';
}
function assignConfirm() {
	window.location.href = '/SSH/admin/assignAuto.action?assignMethod=9';
}
$(function() {
	$("#assignSelect").change(function() {
		assignMethod = $("#assignSelect option:selected").val();
	});
});
$(document).ready(function() {
	var page = $("#page").text();
	var totalPage = $("#totalPage").text();
	if (page == 1)
		$("#pre").removeAttr("href").text("第一页");
	if (page == totalPage)
		$("#next").removeAttr("href").text("最后页");
});