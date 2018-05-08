<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="/WEB-INF/tlds/taghandler" prefix="cust" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body bgcolor="#838eef">
        <form action="read.htm">
            <h1> Enter the name of CSV that you want to Load!!</h1>
            <input type="text" name="csv" />
            <input type="hidden" name="action" value="loadcsv" />
            <input type="submit" value="SUBMIT"/>
        </form>
                    
        <c:if test="${sessionScope.view eq 'csvData'}">
                <form action="read.htm">
                    <cust:DisplayTable>${sessionScope.csv}</cust:DisplayTable>     
                   <input type="hidden" name="action" value="load" />
                   <input type="submit" value="Upload"/>
                </form>
            </c:if>
        
        <c:if test="${sessionScope.view eq 'uploaded'}">
            <form action="read.htm">
                <h1><c:out value="${sessionScope.rows}" /> Rows are inserted to the database</h1>
            </form>
        </c:if>
        
    </body>
</html>
