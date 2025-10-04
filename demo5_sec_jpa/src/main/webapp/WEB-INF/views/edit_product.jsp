<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit Product</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
            background-color: #f4f4f4;
        }
        .container {
            max-width: 600px;
            margin: 50px auto;
            background-color: white;
            padding: 30px;
            border-radius: 8px;
            box-shadow: 0 2px 10px rgba(0,0,0,0.1);
        }
        h1 {
            text-align: center;
            color: #333;
        }
        table {
            width: 100%;
            margin-top: 20px;
        }
        td {
            padding: 10px;
        }
        td:first-child {
            font-weight: bold;
            width: 30%;
            color: #555;
        }
        input[type="text"] {
            width: 100%;
            padding: 8px;
            border: 1px solid #ddd;
            border-radius: 4px;
            box-sizing: border-box;
        }
        input[readonly] {
            background-color: #e9ecef;
        }
        button {
            width: 100%;
            padding: 12px;
            background-color: #007bff;
            color: white;
            border: none;
            border-radius: 4px;
            cursor: pointer;
            font-size: 16px;
            font-weight: bold;
        }
        button:hover {
            background-color: #0056b3;
        }
        .back-link {
            display: block;
            text-align: center;
            margin-top: 20px;
            color: #007bff;
            text-decoration: none;
        }
        .back-link:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <div class="container">
        <h1>Edit Product</h1>
        
        <form action="${pageContext.request.contextPath}/save" method="post">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <input type="hidden" name="id" value="${product.id}"/>
            
            <table>
                <tr>
                    <td>Product ID:</td>
                    <td><input type="text" name="id" value="${product.id}" readonly/></td>
                </tr>
                <tr>
                    <td>Product Name:</td>
                    <td><input type="text" name="name" value="${product.name}" required/></td>
                </tr>
                <tr>
                    <td>Brand:</td>
                    <td><input type="text" name="brand" value="${product.brand}" required/></td>
                </tr>
                <tr>
                    <td>Made in:</td>
                    <td><input type="text" name="madein" value="${product.madein}" required/></td>
                </tr>
                <tr>
                    <td>Price:</td>
                    <td><input type="text" name="price" value="${product.price}" required/></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <button type="submit">Save</button>
                    </td>
                </tr>
            </table>
        </form>
        
        <a href="${pageContext.request.contextPath}/" class="back-link">Back to Product List</a>
    </div>
</body>
</html>