<%@ page language="java" pageEncoding="utf-8" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  

<div class="breadcrumbs" id="breadcrumbs">
	<script type="text/javascript">
		try {
			ace.settings.check('breadcrumbs', 'fixed')
		} catch (e) {
		}
	</script>

	<ul class="breadcrumb">
		<li><i class="ace-icon fa fa-home home-icon"></i> <a href="index"><spring:message
					code="crumbs.home" /></a></li>
		<li><a href="${parentModule}${moduleName}/list">${moduleName}</a></li>
		<li class="active"><spring:message code="crumbs.delete" /></li>
	</ul>
	<!-- .breadcrumb -->
</div>
<div class="page-content">
	<div class="page-header">
	
	</div>
	<div class="row">
		<div class="col-sm-12">
			<!-- PAGE CONTENT BEGINS -->

			<div class="row">
				<div class="col-sm-12">
					<form class="form-horizontal" action="${parentModule}${moduleName}/delOk" method="post" >
						<input type="hidden" name="${ keyName }" value="${r'$'}{${moduleName}.${ keyName }}">
<#list columns as col>
	<#if col["DATA_TYPE"] != "bit">
						<div class="form-group">
							<label class="col-sm-3 control-label no-padding-right" for="form-field-1">${col["COLUMN_NAME"]}</label>
							<div class="col-sm-9">
								${r'$'}{${moduleName}.${col['COLUMN_NAME']}}
							</div>
						</div>
	</#if>			
</#list>
						
					<div class="clearfix form-actions">
						<div class="col-sm-offset-3 col-sm-9">
							<button class="btn btn-info" type="submit">
								<i class="icon-ok bigger-110"></i>
								Delete
							</button>
							&nbsp; &nbsp; &nbsp;
							<a href="${parentModule}${moduleName}/list"><span
								class="btn">Back List</span></a>
						</div>
					</div>
					
					</form>
					
					<!-- /widget-main -->
				</div>
				<!-- /widget-body -->
			</div>
		</div>
	</div>
</div>