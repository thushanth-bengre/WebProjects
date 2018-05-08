<%-- 
    Document   : addbooks
    Created on : 22 Feb, 2018, 4:26:26 PM
    Author     : Bengre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib  uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#76D7C4">
        <form action="added.htm" modelAttribute="bookcollection" method="post">
            <h1>Add Books Here</h1>
           <fmt:parseNumber var="length" value="${num}"></fmt:parseNumber>
            <input type="hidden" name="size" value="${length}">
                <table border="1">
                    <tr>
                        <th>ISBN</th>
                        <th>Book Title</th>
                        <th>Author</th>
                        <th>Price</th>                    
                    </tr>
                <c:forEach var="i" begin="0" end="${length}">
                    <tr>
                        <th><input type="text" name="bookslist[${i}].isbn" /></th>
                        <th><input type="text" name="bookslist[${i}].name" /></th>
                        <th><input type="text" name="bookslist[${i}].author" /></th>
                        <th><input type="text" name="bookslist[${i}].price" /></th>
                    </tr>
                </c:forEach>
                <tr>                        
                    <th><input type="submit" value="ADD BOOKS"/></th>
                </tr>
            </table>
            <input type='hidden' name='action' value='added'/>
        </form>
    </body>
</html>
