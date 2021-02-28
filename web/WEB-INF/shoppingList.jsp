<%-- 
    Document   : shoppingList
    Created on : Feb 25, 2021, 1:09:13 PM
    Author     : 841898
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List!</h1>
        <p>Hello, ${username}</p>
        <a href="ShoppingList?Logout">Logout</a> <br />
        <h2>List</h2>
        <form action="" method="POST">
            <span>Add item: </span>
            <input type="text" name="item" />
            <input type="submit" value="Add">
            <input type="hidden" name="action" value="add">
        </form>
        
        <form action="" method="post">
            <ul>
                <c:forEach items="${itemList}" var="item"> 
                    <li style="list-style: none"><input type="radio" name="item" value="${item}"/>${item}</li>
                </c:forEach>
            </ul>
            <input type="submit" value="Delete" />
            <input type="hidden" name="action" value="delete"/> 
            
        </form>
        
    </body>
</html>
