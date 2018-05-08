<%-- 
    Document   : result
    Created on : 21 Feb, 2018, 2:45:42 AM
    Author     : Bengre
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#2ECC71">
        <form>
            <h1> Results found </h1>            
            <c:forEach items="${requestScope.movieList}" var="movies">
              
               <b><font color = #78281F>Movie Name:</b> </font> <c:out value="${movies.name}"  /><br><br>
               <b><font color = #78281F>Actor:</b> </font>     <c:out value="${movies.actor}" /><br><br>
               <b><font color = #78281F>Actress:</b> </font>     <c:out value="${movies.actress}" /><br><br>
               <b><font color = #78281F>Genre:</b>  </font>      <c:out value="${movies.genre}" /><br><br>
               <b><font color = #78281F>Year:</b> </font>        <c:out value="${movies.year}" /><br><br>
               <hr>
            </c:forEach>            
            <a href="/part3">Click Here to go to main page!</a>
        </form>
    </body>
</html>
