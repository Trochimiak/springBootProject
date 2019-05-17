<%--
  Created by IntelliJ IDEA.
  User: troch
  Date: 13.05.2019
  Time: 22:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <!--meta http-equiv="Content-Type" content="text/html" charset="ISO-8859-1"-->
    <title>Student List</title>
    <link href="../webjars/bootstrap/4.1.3/css/bootstrap.min.css" rel="stylesheet" />
    <script src="../webjars/bootstrap/4.1.3/js/bootstrap.min.js"/>
    <script src="../webjars/jquery/3.0.0/jquery.min.js"/>
</head>
<body>
    <div class="container">
        <h2>Student List</h2>
        <table class="table table-hover">
            <thead>
                <tr>
                    <th scope="row">Student ID</th>
                    <th scope="row">First Name</th>
                    <th scope="row">Last Name</th>
                    <th scope="row">Index Number</th>
                    <th scope="row">Edit Student</th>
                    <th scope="row">Delete Student</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${studentList }" var="student">
                    <tr>
                        <td>${student.firstName }</td>
                        <td>${student.lastName }</td>
                        <td>${student.indexNumber }</td>
                        <td>
                            <spring:url value="/student/update/${student.id }" var="updateURL"></spring:url>
                            <a class="btn btn-primary" href="${updateURL }" role="button">Update</a>
                        </td>
                        <td>
                            <spring:url value="/student/delete/${student.id }" var="deleteURL"></spring:url>
                            <a class="btn btn-primary" href="${deleteURL }" role="button">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
        <spring:url value="/student/add/${student.id }" var="addURL"></spring:url>
        <a class="btn btn-primary" href="${addURL }" role="button">Add Student</a>
    </div>
</body>
</html>
