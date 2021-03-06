<!DOCTYPE html>
<html>
<head>
<title>Commulade - <s:property value="title" /></title>

<meta name="viewport" content="width=device-width, initial-scale=1.0">

<base href="${pageContext.request.contextPath}/" />

<%-- jQuery 3.3.1 --%>
<script src="js/jquery-3.3.1.min.js"></script>

<%-- Bootstrap 4.0.0 --%>
<link rel="stylesheet" type="text/css" href="css/bootstrap-4.0.0-grid.min.css" media="screen">
<script src="js/bootstrap-4.0.0.min.js"></script>


<%-- Commulade --%>

<%-- Common --%>
<link rel="stylesheet" type="text/css" href="css/common-css.css" media="screen" />

<%-- Page --%>
<s:if test="css!=null">
	<link rel="stylesheet" type="text/css" href="css/<s:property value="css" />.css" media="screen" />
</s:if>
</head>
<body class="flexCol noMarPad">
	<s:include value="/WEB-INF/content/jsp/parts/header.jsp"></s:include>

	<div id="mainContent" class="autoMar">
		<s:include value="/WEB-INF/content/jsp/%{contentJsp}.jsp"></s:include>
	</div>

	<s:include value="/WEB-INF/content/jsp/parts/footer.jsp"></s:include>

	<%-- Script --%>
	<script src="js/common-js.js"></script>
	<s:if test="js!=null">
		<script src="js/<s:property value="js" />.js"></script>
	</s:if>
</body>
</html>
