<%-- 
    Document   : loginForm
    Created on : 17 Feb, 2018, 1:58:03 PM
    Author     : Bengre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login Page</h1>
        <form:form commandName="login">
            User Name: <form:input path="username" /><form:errors path="username" /> <br/><br/>
            Password: <form:password path="password" /><form:errors path="password" /> <br/><br/>
            <input type="submit" value="login" />
        </form:form>
        
    </body>
</html>
