<%@ page language="java" pageEncoding="utf-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="footer">
	<div class="footer-inner">
		<!-- #section:basics/footer -->
		<div class="footer-content">
			Copyright @
			<spring:message code="footer.company" />
			&nbsp;&nbsp;&nbsp;
			<spring:message code="footer.legal" />
			&nbsp;|&nbsp;
			<spring:message code="footer.privacy" />
			&nbsp;&nbsp;&nbsp;
			<spring:message code="footer.record" />
			&nbsp;&nbsp;&nbsp; <a href="javascript:changeLanguage('zh')"><spring:message
					code="footer.chinese" /></a> &nbsp;&nbsp;|&nbsp;&nbsp;<a
				href="javascript:changeLanguage('en')"><spring:message
					code="footer.english" /></a>

		</div>
	</div>
</div>

<script>
	var changeLanguage = function(lan) {
		var str1 = window.location.href;
		var idx = str1.indexOf('?');
		if (idx > 0) {
			str1 = str1.substring(0, idx);
		}
		str1 = str1 + "?locale=" + lan;
		window.location.href = str1;
	}
</script>