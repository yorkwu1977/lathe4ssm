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
		<li class="active"><spring:message code="crumbs.list" /></li>
	</ul>
	<!-- .breadcrumb -->
</div>
<div class="page-content">
	<div class="page-header">
		<div class="row">
			<div class="col-md-12">
				<form class="form-horizontal" id="${moduleName}Form" action="${parentModule}${moduleName}/list"
					method="get">
					<div class="col-md-10">
						Condition1:&nbsp;<input type="text" id="cdt1" name="cdt1" placeholder="" size="20" maxlength="20">
					</div>
					<div class="col-md-1" style="text-align: right;">
						<button class="btn btn-info btn-sm" type="submit">
							<spring:message code="common.btn.search" />
						</button>
					</div>
					<div class="col-md-1" style="text-align: right;">
						<a href="${parentModule}${moduleName}/create"><span class="btn btn-info btn-sm"><spring:message code="common.btn.add" /></span></a>
					</div>
				</form>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="col-md-12">
					<table id="sample-table"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>
								
<#list columns as col> 
								<th>${col["COLUMN_NAME"]}</th>
</#list>
								<th style="width: 10%;"></th>
								</tr>
							</thead>
							<tbody>

							 <c:forEach var="rowItem" items="${r'${page.getResult()}'}">  
							 	<tr>	
							 	<#list columns as col> 
									<td>${r'$'}{ rowItem.${col["COLUMN_NAME"]} }</td>
								</#list>
								    <td class="center">
										<div class="visible-md visible-lg hidden-sm hidden-xs action-buttons">
											<a class="green" href="${parentModule}${moduleName}/edit?${ keyName }=${r'$'}{ rowItem.${ keyName } }">
												<i class="ace-icon fa fa-pencil bigger-120"></i>
											</a>&nbsp;&nbsp;
											<a class="red" href="${parentModule}${moduleName}/delete?${ keyName }=${r'$'}{ rowItem.${ keyName } }">
												<i class="ace-icon fa fa-trash-o bigger-120"></i>
											</a>
										</div>
									</td>
							    </tr>
							 </c:forEach>  
     
							</tbody>
						</table>
				</div>
		</div>
		<div class="row">
						<div class="col-md-3">
										
										<#assign seq = ['5', '10', '20', '50', '100']> 					
										<form id="${moduleName}Form" action="${parentModule}${moduleName}/list" method="get">
											每页显示&nbsp;<select id="selectPageSize"
											name="pageSize" onChange="javascript:this.form.submit();">
												<#list seq as row> 
													<option value="${row}">${row}</option>
												</#list>
											</select>&nbsp;条记录
										</form>
						</div>
						<div class="col-md-9"
							style="text-align: right; padding-top: 5px;">
										<a href="${parentModule}${moduleName}/list?pageNo=1&pageSize=${r'$'}{page.getPageSize()}">首页</a>&nbsp;
										<c:choose>
											<c:when test="${r'$'}{page.getPageNo() - 1 > 0}">
												<a
													href="${parentModule}${moduleName}/list?pageNo=${r'$'}{page.getPageNo() - 1}&pageSize=${r'$'}{page.getPageSize()}">上一页</a>&nbsp;
											</c:when>
											<c:when test="${r'$'}{page.getPageNo() - 1 <= 0}">
												<a href="${parentModule}${moduleName}/list?pageNo=1&pageSize=${r'$'}{page.getPageSize()}">上一页</a>&nbsp;
											</c:when>
										</c:choose> <c:choose>
											<c:when test="${r'$'}{page.getTotalPages()==0}">
												<a
													href="${parentModule}${moduleName}/list?pageNo=${r'$'}{page.getPageNo()}&pageSize=${r'$'}{page.getPageSize()}">下一页</a>&nbsp;
											</c:when>
											<c:when test="${r'$'}{page.getPageNo() + 1 < page.getTotalPages()}">
												<a
													href="${parentModule}${moduleName}/list?pageNo=${r'$'}{page.getPageNo() + 1}&pageSize=${r'$'}{page.getPageSize()}">下一页</a>&nbsp;
											</c:when>
											<c:when
												test="${r'$'}{page.getPageNo() + 1 >= page.getTotalPages()}">
												<a
													href="${parentModule}${moduleName}/list?pageNo=${r'$'}{page.getTotalPages()}&pageSize=${r'$'}{page.getPageSize()}">下一页</a>&nbsp;
											</c:when>
										</c:choose> <c:choose>
											<c:when test="${r'$'}{page.getTotalPages()==0}">
												<a
													href="${parentModule}${moduleName}/list?pageNo=${r'$'}{page.getPageNo()}&pageSize=${r'$'}{page.getPageSize()}">尾页</a>&nbsp;
											</c:when>
											<c:otherwise>
												<a
													href="${parentModule}${moduleName}/list?pageNo=${r'$'}{page.getTotalPages()}&pageSize=${r'$'}{page.getPageSize()}">尾页</a>&nbsp;
											</c:otherwise>
										</c:choose>
										&nbsp;&nbsp;共 ${r'$'}{page.getTotalPages()} 页&nbsp;第
										${r'$'}{page.getPageNo()} 页
							</div>
					</div>
				
</div>
<script type="text/javascript">

var jsPageSize = "${r'$'}{ page.getPageSize() }";
${r'$'}("#selectPageSize").val(jsPageSize);

</script>