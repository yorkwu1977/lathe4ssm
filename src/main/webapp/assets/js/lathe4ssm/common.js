// -----------------------------------------------------------------
// 1，处理ajax调用时session超时
//   * sessionStatus状态在SessionTimeoutInterceptor中设置
// 2， 处理ajax调用时发生异常
//   * errorstatus状态在MyActFilter中设置
// -----------------------------------------------------------------
$.ajaxSetup({
	complete : function(xhr, status) {
		var sessionStatus = xhr.getResponseHeader("sessionstatus");
		if (sessionStatus == "ajax_session_timeout") {
			window.location.href = "/lathe4ssm/rest/login";
		}

		var errorstatus = xhr.getResponseHeader("errorstatus");
		if (errorstatus == "ajax_error") {
			var str = "输入内容不符合规范！";
			var preUrl = "";
			window.location.href = "/lathe4ssm/rest/page/500?msg=" + str
					+ "&preurl=" + preUrl;
		}
	}
});

$(window).scroll(function() {
	// 垂直滚动条的offset大于90
	if ($(window).scrollTop() > 90) {
		$("#btn-scroll-up").css({
			// 修改相关div样式为显示
			"visibility" : "visible"
		});
	} else {
		$("#btn-scroll-up").css({
			// 修改相关div样式为隐藏
			"visibility" : "hidden"
		});
	}
});

$(document).ready(
		function() {

			// ----------------------------------------
			// ----- 设置当前页面所属菜单项是否激活状态
			// ----------------------------------------
			var pn = window.location.pathname;
			var beginIndex = pn.indexOf("rest/");
			var endIndex = pn.lastIndexOf("/");
			var pageUrl = pn.substring(beginIndex + 5).replace(
					/\//g, "-");
			var category = pageUrl.substring(0, pageUrl.indexOf("-"));

//			 alert(pn);
//			 alert(category + " >>>> " + pageUrl);

			// 设置菜单选中状态
			$("#" + pageUrl).attr("class", "active");
			$("#" + category).attr("class", "active open");

		});
