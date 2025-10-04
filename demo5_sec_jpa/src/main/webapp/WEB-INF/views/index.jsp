<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product Manager</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        table {
            border-collapse: collapse;
            width: 100%;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 10px;
            text-align: left;
        }
        th {
            background-color: #4CAF50;
            color: white;
        }
        a {
            color: #007bff;
            text-decoration: none;
            margin-right: 10px;
        }
        a:hover {
            text-decoration: underline;
        }
        .header-info {
            background-color: #f0f0f0;
            padding: 10px;
            border-radius: 5px;
            margin-bottom: 20px;
        }
        .logout-btn {
            background-color: #dc3545;
            color: white;
            padding: 8px 15px;
            border: none;
            border-radius: 4px;
            cursor: pointer;
        }
        .logout-btn:hover {
            background-color: #c82333;
        }
    </style>
</head>
<body>
    <div class="header-info">
        <sec:authorize access="isAuthenticated()">
            Welcome <b><sec:authentication property="name"/></b>
            <br>
            Roles: <i><sec:authentication property="principal.authorities"/></i>
            <br><br>
            <form action="${pageContext.request.contextPath}/logout" method="post" style="display:inline;">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <button type="submit" class="logout-btn">Logout</button>
            </form>
        </sec:authorize>
    </div>
    
    <div align="center">
        <h1>Product Manager</h1>
        
        <sec:authorize access="hasAnyAuthority('CREATOR', 'ADMIN')">
            <a href="${pageContext.request.contextPath}/new">Create New Product</a>
        </sec:authorize>
        
        <table>
            <thead>
                <tr>
                    <th>Product ID</th>
                    <th>Name</th>
                    <th>Brand</th>
                    <th>Made In</th>
                    <th>Price</th>
                    <sec:authorize access="hasAnyAuthority('ADMIN', 'EDITOR')">
                        <th>Actions</th>
                    </sec:authorize>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="product" items="${listProducts}">
                    <tr>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.brand}</td>
                        <td>${product.madein}</td>
                        <td>${product.price}</td>
                        <sec:authorize access="hasAnyAuthority('ADMIN', 'EDITOR')">
                            <td>
                                <a href="${pageContext.request.contextPath}/edit/${product.id}">Edit</a>
                                <sec:authorize access="hasAuthority('ADMIN')">
                                    <a href="${pageContext.request.contextPath}/delete/${product.id}" 
                                       onclick="return confirm('Are you sure?')">Delete</a>
                                </sec:authorize>
                            </td>
                        </sec:authorize>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>
</body>
</html>