$(document).ready(function() {
			$(".parts").keyup(function() {
						update();
					});
			total();

		});

function random(min, max) {
	min -= 1;
	return Math.ceil(Math.random() * (max - min) + min);
}

function ran(score) {
	var s = score + random(-3, 3);
	s = Math.round(s);
	if (Math.abs(score - s) <= 3)
		return s;
	else
		return ran(score);
}
function split() {
	// var vTable = $("#tbin");
	var averscore = parseInt($("#aver").val());
	var score = 0;
	var arr = [0.15, 0.05, 0.05, 0.05, 0.2, 0.1, 0.1, 0.3];
	var arr2 = [];
	var sum = 0;
	var k = 0;
	$(".parts").each(function(i) {
				var s = averscore * arr[k];
				s = Math.round(s * 10) / 10;
				sum += s;
				arr2.push(s);
				k++;
			});

	var b7 = 0;
	var b4 = 0;
	var r = sum - averscore;
	if (r == 2) {
		arr2[7] -= 1;
		b7 = -1;
		arr2[4] -= 1;
		b4 = -1;
	} else if (r == 1) {
		arr2[7] -= 1;
		b7 = -1;
	} else if (r == -2) {
		arr2[7] += 1;
		b7 = 1;
		arr2[4] += 1;
		b4 = 1;
	} else if (r == -1) {
		arr2[7] += 1;
		b7 = 1;
	}

	var j = 0;
	$(".parts").each(function(i) {
				var s = arr2[j];
				var partScore = ran(averscore);
				// alert("partScore:" + partScore);
				var partScoreCal = Math.round((partScore * arr[j]) * 10) / 10;
				var res = partScoreCal - s;
				while (Math.abs(res) >= 0.5) {
					if (j == 4 && b4 == -1) {
						partScore = averscore - 3;
						break;
					}
					if (j == 4 && b4 == 1) {
						partScore = averscore + 3;
						break;
					}

					if ((j == 7) && b7 == -1) {
						partScore = averscore - 3;
						break;
					}
					if ((j == 7) && b7 == 1) {
						partScore = averscore + 3;
						break;
					}
					partScore = ran(averscore);
					partScoreCal = Math.round((partScore * arr[j]) * 10) / 10;
					res = partScoreCal - s;
				}
				if (partScore > 100) {
					$(this).val("99");
				} else {
					$(this).val(parseInt(partScore));
				}
				j++;
			});

	update();

	var vTable = $("#tbin");
	var vTotal = vTable.find("#Total");
	var totalscore = vTotal.val();
	totalscore = Math.round(totalscore);
	if (totalscore != averscore) {
		split();
	} else {
		vTotal.val(totalscore);
	}
}
function total() {
	var totalscore = 0;// ��������
	var vTable = $("#tbin");// �õ�����jquery����
	var vTotal = vTable.find("#Total");// �õ��ܽ�����
	$(".partscores").each( // ʹ��jQuery��each�������ÿ�з��ö���,�ۼӳ��ܽ��
			function(i) {
		if ($(this).val() == "") {
			$(this).val(0);
		}
		totalscore = totalscore + parseFloat($(this).val());// �����ܷ���
	});// �������
	vTotal.val(totalscore); // ���ܷ�����ʾ����Ӧ�ı��������
}
function update() {
	var arr = [0.15, 0.05, 0.05, 0.05, 0.2, 0.1, 0.1, 0.3];
	$("#partscore1").val(Math.round($("#part1").val() * arr[0] * 10) / 10);
	$("#partscore2").val(Math.round($("#part2").val() * arr[1] * 10) / 10);
	$("#partscore3").val(Math.round($("#part3").val() * arr[2] * 10) / 10);
	$("#partscore4").val(Math.round($("#part4").val() * arr[3] * 10) / 10);
	$("#partscore5").val(Math.round($("#part5").val() * arr[4] * 10) / 10);
	$("#partscore6").val(Math.round($("#part6").val() * arr[5] * 10) / 10);
	$("#partscore7").val(Math.round($("#part7").val() * arr[6] * 10) / 10);
	$("#partscore8").val(Math.round($("#part8").val() * arr[7] * 10) / 10);
	total();
}
