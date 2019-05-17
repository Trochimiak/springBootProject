<%--
  Created by IntelliJ IDEA.
  User: troch
  Date: 13.05.2019
  Time: 23:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <!--meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1"-->
    <title>Student</title>
    <link href="http://localhost:8095/webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
    <script src="http://localhost:8095/webjars/bootstrap/4.1.3/js/bootstrap.min.js"/>
    <script src="http://localhost:8095/webjars/jquery/3.0.0/jquery.min.js"/>
</head>
<body>
    <div class="container">
        <spring:url value="/student/save" var="saveURL"></spring:url>
        <h2>Student</h2>
        <form:form modelAttribute="studentForm" method="POST" action="${saveURL}" cssClass="<form">
            <form:hidden path="id"></form:hidden>
            <div class="form-group">
                <label for="firstName">First Name</label>
                <form:input path="firstName" cssClass="form-control" id="firstName"></form:input>
            </div>
            <div class="form-group">
                <label for="lastName">Last Name</label>
                <form:input path="lastName" cssClass="form-control" id="firstName"></form:input>
            </div>
            <div class="form-group">
                <label for="indexNumber">Index Number</label>
                <form:input path="indexNumber" cssClass="form-control" id="firstName"></form:input>
            </div>
            <button type="submit" class="btn-primary">Save</button>
        </form:form>

    </div>
</body>
</html>
