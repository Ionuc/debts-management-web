<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">

<head>
<link rel="stylesheet" type="text/css"
	href="../../../../static/core/css/register.css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">

<!-- Website Font style -->
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.6.1/css/font-awesome.min.css">

<!-- Google Fonts -->
<link href='https://fonts.googleapis.com/css?family=Passion+One'
	rel='stylesheet' type='text/css'>
<link href='https://fonts.googleapis.com/css?family=Oxygen'
	rel='stylesheet' type='text/css'>

<title>Admin</title>
</head>
<body>
	<div class="container">
		<div class="row main">
			<div class="panel-heading">
				<div class="panel-title text-center">
					<h1 class="title">User profile</h1>
					<hr />
				</div>
			</div>
			<div class="main-login main-center">
				<form class="form-horizontal" method="post" action="#">
					<form:form method="POST" action="registerUser"
						modelAttribute="user">
						<div class="form-group">
							<label for="name" class="cols-sm-2 control-label"> Name</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"> <i
										class="fa fa-user fa" aria-hidden="true"></i>
									</span>
									<form:input path="name" placeholder="Enter your Name"
										cssClass="form-control" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="email" class="cols-sm-2 control-label">
								Surname</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"> <i
										class="fa fa-user fa" aria-hidden="true"></i>
									</span>
									<form:input path="surname" placeholder="Enter your Surname"
										cssClass="form-control" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="username" class="cols-sm-2 control-label">Username</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-users fa" aria-hidden="true"></i></span>
									<form:input path="username" placeholder="Enter your Username"
										cssClass="form-control" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Password</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"><i
										class="fa fa-lock fa-lg" aria-hidden="true"></i></span>
									<form:input path="password" placeholder="Enter your Passowrd"
										cssClass="form-control" />
								</div>
							</div>
						</div>

						<div class="form-group">
							<label for="password" class="cols-sm-2 control-label">Age</label>
							<div class="cols-sm-10">
								<div class="input-group">
									<span class="input-group-addon"> <i
										class="fa fa-user fa" aria-hidden="true"></i>
									</span>
									<form:input path="age" placeholder="Enter your age"
										cssClass="form-control" />
								</div>
							</div>
						</div>

						<div class="form-group ">
							<input type="submit" name="register" value="Register"
								class="btn btn-primary btn-lg btn-block login-button ">
						</div>
						<div class="form-group ">
							<input type="submit" name="goToLogin" value="Login"
								class="btn btn-primary btn-lg btn-block login-button">
						</div>
					</form:form>
				</form>
			</div>
		</div>
	</div>
	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>