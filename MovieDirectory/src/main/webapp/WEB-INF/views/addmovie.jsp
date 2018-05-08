<%-- 
    Document   : addmovies
    Created on : 21 Feb, 2018, 12:30:59 AM
    Author     : Bengre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#66a3ff">
        <h1>Please Enter Movie Details Below!!</h1>
        <form:form action ="savemovie" method="post" modelAttribute="movie">
            Title:   <form:input path="name"/> <form:errors path="name"/><br /><br />
            Actor:   <form:input path="actor"/> <form:errors path="actor"/><br/><br/>
            Actress: <form:input path="actress"/> <form:errors path="actress"/><br/><br/>
            Genre:   <form:input path="genre"/> <form:errors path="genre"/><br/><br/>
            Year:    <form:input path="year"/> <form:errors path="year"/><br/><br/>
           <input type="submit" value="Add Movie"/> 
            
        </form:form>
    </body>
</html>
