<%-- 
    Document   : userView
    Created on : 3 Mar, 2018, 2:34:19 PM
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
    <body>
        <h1>User View!</h1>
        
        User Name: ${requestScope.user.fName} ${requestScope.user.lName}
        User Id: ${requestScope.user.id}<br />
        <c:forEach items="${requestScope.user.courses}" var="courses" >
         ${courses}
        </c:forEach>
    </body>
</html>
