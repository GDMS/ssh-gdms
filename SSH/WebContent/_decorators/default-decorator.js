$(document).ready(function() { // 使用jquery的ready方法似的加载运行
	// 处理Session
	var $studentMain = $("#studentMain");
	var $teacherMain = $("#teacherMain");
	var $adminMain = $("#adminMain");
	var $studentReg = $("#studentReg");
	var type = $("#sessionType").text();
	if (type < 1 || type > 3) {
		$studentReg[0].style.display = '';
	} else {
		if (type == 1) {
			$studentMain[0].style.display = '';
		} else if (type == 2) {
			$teacherMain[0].style.display = '';
		} else if (type == 3) {
			$adminMain[0].style.display = '';
		}
	}

	// 处理Session
	var $sessionName = $("#sessionName");
	var name = $sessionName.text();
	var type = $("#sessionType").text();
	var t = "未知：";
	if (type < 1 || type > 3)
		$("#sessionName").text("游客您好！");
	else {
		if (type == 1) {
			var t = "学生：";
			$("#studentLogin").attr('href', 'student/main.jsp').text('学生主页');
		} else if (type == 2) {
			var t = "教师：";
			$("#teacherLogin").attr('href', 'teacher/main.jsp').text('教师主页');
		} else if (type == 3) {
			var t = "管理员：";
			$("#adminLogin").attr('href', 'admin/main.jsp').text('管理员主页');
		}
		$sessionName.text("欢迎" + t + name);
	}
});
