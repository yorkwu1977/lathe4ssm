<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>

<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/rest/";
%>
<!DOCTYPE html>
<html>
<head>
<base id="basePath" href="<%=basePath%>">
<title><tiles:getAsString name="title" /></title>
<meta name="keywords" content="" />
<meta name="description" content="" />
<meta name="viewport"
	content="width=device-width,initial-scale=1.0,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no" />
<link rel="shortcut icon" href="assets/img/lathe4ssm_icon.ico" />

<!-- ----- 全局 css ----- -->
<tiles:insertAttribute name="baseCss" />


</head>
<body class="no-skin">
	<tiles:insertAttribute name="header" />
	

	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<!-- Begin 左侧菜单区域 -->
		<tiles:insertAttribute name="menu" />
		<!-- End 左侧菜单区域 -->

		<div class="main-content">
			<div class="main-content-inner">

				<!-- Begin 主体内容区域 -->
				<tiles:insertAttribute name="body" />
				<!-- End 主体内容区域 -->

			</div>
			<!-- /.main-container-inner -->
		</div>

		<!-- Begin 页脚区域 -->
		<tiles:insertAttribute name="footer" />
		<!-- End 页脚区域 -->

		<!-- 置顶按钮 -->
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="ace-icon fa fa-angle-double-up icon-only bigger-110"></i>
		</a>

	</div>
	<!-- /.main-container -->

	<!-- ----- 全局 js ----- -->
	<tiles:insertAttribute name="baseJs" />
</body>
</html>