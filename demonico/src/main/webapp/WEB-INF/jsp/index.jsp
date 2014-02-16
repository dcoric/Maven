<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="includes/common.inc" %>
<%@ include file="includes/navbar.jsp" %>
	
	<!-- Container begins -->
	<div class="col-lg-10 col-lg-offset-1">
		<!-- Example row of columns -->
		<div class="col-lg-4">
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
			<div class="jumbotron" style=" background-image: url(<c:url value='/img/BG_BillboardLeaf.png'/>);">
					<h1>Hello, world!</h1>
					<p>...</p>
					<p>
						<a class="btn btn-primary btn-lg" href="addUser">Add user</a>
						<a class="btn btn-info btn-lg" href="viewUsers">View all users</a>
						<a class="btn btn-danger btn-lg" href="logout">Sign out</a>
					</p>
			</div>
			<div class="well">
			<c:choose>
			<c:when test="${success == true}"><h2>Saved!</h2></c:when>
			<c:when test="${addUser == true}">
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
				      <button type="submit" class="btn btn-default">Add user</button>
				    </div>
				  </div>
				</form>
			</c:when>
			<c:when test="${fn:length(allUsers) gt 0 }">
				<table class="table table-striped">
					<thead>
						<tr>
							<th>Username</th>
							<th>First name</th>
							<th>Last name</th>
							<th>Birth date</th>
							<th>User since</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach var="user" items="${allUsers}">
					<tr>
						<td>${user.username}</td>
						<td>${user.firstName}</td>
						<td>${user.lastName}</td>
						<td><fmt:formatDate pattern="dd.MM.&#39;yy." 
          								value="${user.birthDate}" /></td>
        			    <td><fmt:formatDate pattern="dd.MM.&#39;yy." 
           								value="${user.insertionDate}" /></td>
					</tr>
					</c:forEach>
					</tbody>
				</table>
			</c:when>
			<c:when test="${empty user.username }">
				<c:if test="${not empty errorMessage }">
					<div class="alert alert-danger">${errorMessage }</div>
				</c:if>
				<form class="form-horizontal" role="form" method="POST" action="login">
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
				    <div class="col-sm-offset-9 col-sm-2">
				      <button type="submit" class="btn btn-default">Sign in</button>
				    </div>
				  </div>
				</form>
			</c:when>
			<c:otherwise>
					<h1 class="text-success">Dobro došli, ${user.firstName}</h1>
			</c:otherwise>
			</c:choose>
			</div>
		</div>

	</div>
	<!-- /container -->

<%@ include file="includes/footer.jsp" %>