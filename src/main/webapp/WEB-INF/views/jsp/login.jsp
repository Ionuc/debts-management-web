<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Debts Management</title>

<link rel="stylesheet" type="text/css" href="/../../../resources/css/login.css" type="text/css">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
</head>

<body>
	<div class="container">
		<div class="row" id="pwd-container">
			<div class="col-md-4"></div>
			<div class="col-md-4">
				<section class="login-form">
					<form method="post" role="login">
						<form:form method="POST" action="login" modelAttribute="user">
							<img
								src="http://www.nqn.org.uk/wp-content/uploads/2015/09/Post-4.jpeg"
								class="img-responsive" alt="" />
							<form:input path="username" placeholder="Email"
								cssClass="form-control input-lg" />
							<form:input path="password" placeholder="Password"
								cssClass="form-control input-lg" />
							<input type="submit" name="login" value="Sign in"
								class="btn btn-lg btn-primary btn-block">
							<input type="submit" name="createAccount" value="Create account"
								class="btn btn-lg btn-primary btn-block">
						</form:form>
					</form>
				</section>
			</div>
		</div>
	</div>

	<script
		src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.2/jquery.min.js"></script>
	<script
		src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
</body>
</html>