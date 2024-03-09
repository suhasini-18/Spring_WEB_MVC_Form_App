<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>View Students</title>
</head>
<body>
    <h2>View Students</h2>

    <table border="2" >
        <thead>
            <tr>
                 <th> S.no. </th>
                 <th> Name </th>
                 <th> Email </th>
                 <th> Gender </th>
                 <th> Course </th>
                 <th> Timings </th>
            </tr>
        </thead>
        <tbody>
            <c:forEach items="${students}" var ="s" varStatus="index">
                <tr>
                    <td>${index.count}</td>
                    <td>${s.name}</td>
                    <td>${s.email}</td>
                    <td>${s.gender}</td>
                    <td>${s.course}</td>
                    <td>${s.timings}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
    
        <a href="/"> Register New Student </a>
    
</body>
</html>