<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="breadcrumbs" id="breadcrumbs">

	<ul class="breadcrumb">
		<li><i class="icon-home home-icon"></i> <a href="index"><spring:message
					code="crumbs.home" /></a></li>
		<li><a href="index"><spring:message code="menu.auto" /></a></li>
		<li class="active"><spring:message code="menu.auto.ssm" /></li>
	</ul>
	<!-- .breadcrumb -->

	<div class="nav-search" id="nav-search"></div>
	<!-- #nav-search -->
</div>

<div class="page-content">
	<div class="row">
		<div class="col-xs-12">
			<!-- PAGE CONTENT BEGINS -->

			<div class="row">
				<div class="col-xs-12">
					<!-- PAGE CONTENT BEGINS -->
					<form class="form-horizontal" id="createSsmForm"
						action="codeGenerator/doCreate" method="post"
						data-bv-message="This value is not valid"
						data-bv-feedbackicons-valid="glyphicon glyphicon-ok"
						data-bv-feedbackicons-invalid="glyphicon glyphicon-remove"
						data-bv-feedbackicons-validating="glyphicon glyphicon-refresh">
						<div class="form-group">
							<label class="col-md-2 control-label no-padding-right"
								for="form-field-1">数据库类型</label>
							<div class="col-sm-10">
								<select id="dbType" name="dbType" class="col-xs-6 col-sm-3"
									style="width: 200px;">
									<option value="">-- 数据库类型 --</option>
									<c:forEach var="dbItem" items="${dbTypeList}">
										<option value="${ dbItem.key }">${ dbItem.value }</option>
									</c:forEach>
								</select>
							</div>
						</div>
						<div class="form-group">
							<label class="col-md-2 control-label no-padding-right"
								for="form-field-1">数据库名</label>
							<div class="col-sm-10">
								<input type="text" name="tableSchema" id="tableSchema" value="wallet"
									placeholder="例如：beacon" class="col-xs-10 col-sm-3">&nbsp;&nbsp;
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right"
								for="form-field-1">数据表名</label>
							<div class="col-sm-10">
								<input type="text" name="tableName" id="tableName"
									placeholder="例如：T_USER" class="col-xs-10 col-sm-3">&nbsp;&nbsp;
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right"
								for="form-field-1">包名</label>
							<div class="col-sm-10">
								<input type="text" name="targetPackage" id="targetPackage" value="com.hnapay.wallet.front" 
									placeholder="例如:com.hnapay.projectname"
									class="col-xs-10 col-sm-3">&nbsp;&nbsp;
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right"
								for="form-field-1">模块名</label>
							<div class="col-sm-10">
								<input type="text" name="moduleName" id="moduleName"
									placeholder="通常和数据表名对应，例如user。" class="col-xs-10 col-sm-3">&nbsp;&nbsp;建议和model类名相同，首字母小写。会影响到view文件所在的文件夹名；类名；controller的方法映射路由。
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right"
								for="form-field-1">上级模块名</label>
							<div class="col-sm-10">
								<input type="text" name="parentModule" id="parentModule"
									placeholder="parent module name" class="col-xs-10 col-sm-3">&nbsp;&nbsp;会影响到controller的类映射路由，例如system/user。
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right"
								for="form-field-1">View路径</label>
							<div class="col-sm-10">
								<input type="text" name="targetViewPath" value="F:\devfile\EclipseWorkSpace\wallet-front\trunk\src\main\webapp\WEB-INF\views\"
									placeholder="生成的View文件的目标位置，最后要有斜杠\" class="col-xs-10 col-sm-8">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right"
								for="form-field-1">Controller路径</label>
							<div class="col-sm-10">
								<input type="text" name="targetControllerPath"
									value="F:\devfile\EclipseWorkSpace\wallet-front\trunk\src\main\java\com\hnapay\wallet\front\web\controller\" placeholder="生成的Controller文件的目标位置，最后要有斜杠\"
									class="col-xs-10 col-sm-8">
							</div>
						</div>
						<div class="form-group">
							<label class="col-sm-2 control-label no-padding-right"
								for="form-field-1">Service路径</label>
							<div class="col-sm-10">
								<input type="text" name="targetServicePath" value="F:\devfile\EclipseWorkSpace\wallet-front\trunk\src\main\java\com\hnapay\wallet\front\web\service\"
									placeholder="生成的Service文件的目标位置，最后要有斜杠\" class="col-xs-10 col-sm-8">
							</div>
						</div>

						<div class="clearfix form-actions">
							<div class="col-md-offset-3 col-md-9">
								<button class="btn btn-info" type="submit">
									<i class="icon-ok bigger-110"></i>
									<spring:message code="common.btn.submit" />
								</button>
								&nbsp; &nbsp; &nbsp;
								<button class="btn" type="reset">
									<i class="icon-undo bigger-110"></i>
									<spring:message code="common.btn.reset" />
								</button>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
		<!-- /.col -->
	</div>
	<!-- /.row -->
</div>
<!-- /.page-content -->


<script src="assets/js/jquery.validate.js"></script>
<script type="text/javascript">
	$(document).ready(
			function() {

				$('#createSsmForm').validate(
						{
							errorElement : 'div',
							errorClass : 'help-block',
							focusInvalid : false,
							ignore : "",
							rules : {
								LOGIN_NAME_ : {
									required : true,
									minlength : 3
								},
								PASSWORD_ : {
									required : true,
									minlength : 3
								}
							},
							messages : {
								LOGIN_NAME_ : {
									required : "请输入用户名.",
									minlength : "用户名最小长度为3."
								},
								PASSWORD_ : {
									required : "请输入密码.",
									minlength : "密码最小长度为3."
								}
							},
							highlight : function(e) {
								$(e).closest('.form-group').removeClass(
										'has-info').addClass('has-error');
							},
							success : function(e) {
								$(e).closest('.form-group').removeClass(
										'has-error');//.addClass('has-info');
								$(e).remove();
							},
							errorPlacement : function(error, element) {
								error.insertAfter(element.parent());
							},
							submitHandler : function(form) {
								form.submit();
							},
							invalidHandler : function(form) {
							}
						});

			});
</script>