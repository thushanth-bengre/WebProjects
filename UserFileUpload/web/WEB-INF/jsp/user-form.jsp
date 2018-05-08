<%-- 
    Document   : user-form
    Created on : 24 Feb, 2018, 1:31:22 PM
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
        <h1>User Form</h1>
        <form:form commandName="user" method="POST" enctype="multipart/form-data">
            User Name: <form:input path="username" /><br /><br />
            <input type="file" name="file" value="Choose File" /><br /><br />
            <input type="submit" value="submit" />
        </form:form>
    </body>
</html>
