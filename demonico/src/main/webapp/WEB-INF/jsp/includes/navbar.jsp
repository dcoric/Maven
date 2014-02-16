<%@ include file="common.inc" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="<c:url value='/ico/favicon.png' />">
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">
<title>Demonico<c:if test="${not empty title}"> : ${title }</c:if></title>

<!-- Bootstrap core CSS -->
<link href="<c:url value='/css/bootstrap.css' />" rel="stylesheet">
<link href="<c:url value='/css/datepicker3.css' />" rel="stylesheet">
<!-- Bootstrap core JavaScript
    ================================================== -->
<script src="<c:url value='/js/jquery.min.js' />"></script>
<script src="<c:url value='/js/bootstrap.min.js' />"></script>
<script src="<c:url value='/js/bootstrap-datepicker.rs-latin.js' />"></script>
<script src="<c:url value='/js/bootstrap-datepicker.js' />"></script>

<script>
$(document).ready(function(){
	var nowTemp = new Date();
	var now = new Date('dd.mm.yyyy', nowTemp);
	$('#sandbox-container .input-group.date').datepicker({
	    format: "dd.mm.yyyy",
	    weekStart: 1,
	    autoclose: true,
	    todayHighlight: true
	});
});

</script>
</head>

<body>
	<nav class="navbar navbar-inverse col-lg-10 col-lg-offset-1" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value='/home'/>">Demonico</a>
		</div>
		<p class="navbar-text pull-right">
			Signed in as <a href="#" class="navbar-link">
			<c:choose>
				<c:when test="${not empty user.firstName}">
				${user.firstName}
				</c:when>
				<c:otherwise>
					Anonymous
				</c:otherwise>
			</c:choose>
			</a>
		</p>
		<!-- /.navbar-collapse -->
	</nav>