<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Debts Management</title>

<spring:url value="/resources/core/css/login.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />
</head>

<spring:url value="/resources/core/css/login.js" var="coreJs" />
<spring:url value="/resources/core/css/bootstrap.min.js" var="bootstrapJs" />

<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script type="text/javascript" src="jquery-1.12.3.js"></script>

<body>
<div class="container">
  
  <div class="row" id="pwd-container">
    <div class="col-md-4"></div>
    
    <div class="col-md-4">
      <section class="login-form">
        <form method="post" role="login">
        	<form:form method="POST" action="login" modelAttribute="user">
          		<img src="http://www.nqn.org.uk/wp-content/uploads/2015/09/Post-4.jpeg" class="img-responsive" alt="" />
          		<form:input path="username" placeholder="Email" cssClass="form-control input-lg" />
          		<form:input path="password" placeholder="Password" cssClass="form-control input-lg" />
          		<input type="submit" name ="login" value="Sign in" class="btn btn-lg btn-primary btn-block">
          		<input type="submit" name ="createAccount" value="Create account" class="btn btn-lg btn-primary btn-block">
           </form:form>
        </form>
       
      </section>  
   </div>
  </div>   
</div>
</body>
</html>