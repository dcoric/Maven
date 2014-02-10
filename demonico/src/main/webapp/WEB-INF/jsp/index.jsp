<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="">
<meta name="author" content="">
<link rel="shortcut icon" href="<c:url value='/ico/favicon.png' />">
<!-- <link href="//netdna.bootstrapcdn.com/twitter-bootstrap/2.3.2/css/bootstrap-combined.no-icons.min.css" rel="stylesheet"> -->
<link
	href="http://netdna.bootstrapcdn.com/font-awesome/3.2.1/css/font-awesome.css"
	rel="stylesheet">
<title>Testing Ground for Bootstrap</title>

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
	    weekStart: 1
	});
});

</script>
</head>

<body>
	<nav class="navbar navbar-inverse col-lg-8 col-lg-offset-2" role="navigation">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-ex1-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="#">Brand ${test}</a>
		</div>
		<p class="navbar-text pull-right">
			Signed in as <a href="#" class="navbar-link">
			<c:choose>
				<c:when test="${not empty user.firstName}">
				${user.firstName}
				</c:when>
				<c:otherwise>
					Demonico Admin
				</c:otherwise>
			</c:choose>
			</a>
		</p>
		<!-- /.navbar-collapse -->
	</nav>


	<div class="col-lg-8 col-lg-offset-2">
		<!-- Example row of columns -->
		<div class="col-lg-2">
			<div class="panel panel-info">
				<div class="panel-heading">
					<h3 class="panel-title">Test!</h3>
				</div>
				<ul class="list-group">
					<li class="list-group-item"><span class="icon-stack"> <i
							class="icon-camera"></i> <i
							class="icon-ban-circle icon-stack-base text-danger"></i>
					</span> Ovo radi sjajno!</li>
					<li class="list-group-item"><span class="icon-money"></span>
						Ovo radi sjajno!</li>
					<li class="list-group-item"><h3>
							<span class="icon-stack"> <i class="icon-envelope-alt"></i>
								<i class="icon-mail-forward"></i>
							</span> Ovo radi sjajno!
						</h3></li>
					<li class="list-group-item"><span
						class="glyphicon glyphicon-check"></span> Ovo radi sjajno!</li>
				</ul>
			</div>
		</div>
		<div class="col-lg-8">
			<div class="jumbotron">
				<div class="container">
					<h1>Hello, world!</h1>
					<p>...</p>
					<p>
						<a class="btn btn-primary btn-lg" href="home">Test!</a>
					</p>
				</div>
			</div>
			<div class="well">
			<c:choose>
			<c:when test="success==true"><h2>Saved!</h2></c:when>
			<c:otherwise>
			<h2>New User</h2>
				<form class="form-horizontal" role="form" method="POST" action="newUser">
				  <div class="form-group">
				    <label for="inputUsername" class="col-sm-2 control-label">Username</label>
				    <div class="col-sm-10">
				      <input name="username" type="text" class="form-control" id="inputUsername" placeholder="Username">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputPassword" class="col-sm-2 control-label">Password</label>
				    <div class="col-sm-10">
				      <input name="password" type="password" class="form-control" id="inputPassword" placeholder="Password">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputBirthDate" class="col-sm-2 control-label">Date of birth</label>
				    <div class="span5 col-md-10" id="sandbox-container">
				    	<div class="input-group date">
					  		<input name="birthDate" type="text" class="form-control" placeholder="Birth date"><span class="input-group-addon"><i class="glyphicon glyphicon-th"></i></span>
						</div>
					</div>
				  </div>			
				  <div class="form-group">
				    <label for="inputFirstName" class="col-sm-2 control-label">First name</label>
				    <div class="col-sm-10">
				      <input name="firstName" type="text" class="form-control" id="inputFirstName" placeholder="Name">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="inputLastName" class="col-sm-2 control-label">Last name</label>
				    <div class="col-sm-10">
				      <input name="lastName" type="text" class="form-control" id="inputLastName" placeholder="Last name">
				    </div>
				  </div>
				  
				  <div class="form-group">
				    <div class="col-sm-offset-2 col-sm-10">
				      <button type="submit" class="btn btn-default">Sign in</button>
				    </div>
				  </div>
				</form>
				</c:otherwise>
			</c:choose>
			</div>
		</div>

	</div>
	<!-- /container -->





</body>
</html>