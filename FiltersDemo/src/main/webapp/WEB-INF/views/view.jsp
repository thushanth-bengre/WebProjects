<%-- 
    Document   : view
    Created on : 22 Feb, 2018, 5:09:48 PM
    Author     : Bengre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#76D7C4">
        <h1>All Books Added!</h1>
        <table border="1">
                    <tr>
                        <th>ISBN</th>
                        <th>Book Title</th>
                        <th>Author</th>
                        <th>Price</th>                    
                    </tr>
                    <c:forEach items="${bookList}" var="book">
                    <tr>
                        <th><c:out value="${book.isbn}"  /></th>
                        <th><c:out value="${book.name}" /></th>
                        <th><c:out value="${book.author}" /></th>
                        <th><c:out value="${book.price}" /></th>                        
                    </tr> 
                </c:forEach>
        </table>          
        <a href="/part4">Click Here to go to main Page!</a>
    </body>
</html>
