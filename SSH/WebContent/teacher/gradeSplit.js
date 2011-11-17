$(document).ready(function() {
	$(".parts").keyup(function() {
		update();
	});
	total();
});
function boundrandom(bound1, bound2) {
	var bound1 = parseFloat(bound1);
	var bound2 = parseFloat(bound2);
	return Math.random() * (bound1 - bound2) + bound2;
}
function split() {
	var vTable = $("#tbin");
	var averscore = $("#aver");
	var bound1 = 0.93;
	var bound2 = 1.08;
	var score = 0;
	$(".parts").each(function(i) {
		score = boundrandom(bound1, bound2) * averscore.val();
		if (score > 100) {
			$(this).val("99");
		} else {
			$(this).val(parseInt(score));
		}
	});
	update();
}
function total() {
	var totalscore = 0;// 总评分数
	var vTable = $("#tbin");// 得到表格的jquery对象
	var vTotal = vTable.find("#Total");// 得到总金额对象
	$(".partscores").each( // 使用jQuery的each函数遍历每行费用对象,累加成总金额
	function(i) {
		if ($(this).val() == "") {
			$(this).val(0);
		}
		totalscore = totalscore + parseFloat($(this).val());// 计算总费用
	});// 遍历结束
	vTotal.val(totalscore); // 将总费用显示到对应文本框对象中
}
function update() {
	var arr = [ 0.15, 0.05, 0.05, 0.05, 0.2, 0.1, 0.1, 0.3 ];
	$("#partscore1").val(Math.round($("#part1").val() * arr[0]));
	$("#partscore2").val(Math.round($("#part2").val() * arr[1]));
	$("#partscore3").val(Math.round($("#part3").val() * arr[2]));
	$("#partscore4").val(Math.round($("#part4").val() * arr[3]));
	$("#partscore5").val(Math.round($("#part5").val() * arr[4]));
	$("#partscore6").val(Math.round($("#part6").val() * arr[5]));
	$("#partscore7").val(Math.round($("#part7").val() * arr[6]));
	$("#partscore8").val(Math.round($("#part8").val() * arr[7]));
	total();
}
