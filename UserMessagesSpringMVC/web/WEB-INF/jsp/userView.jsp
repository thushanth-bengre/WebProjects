<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Message View</h1>
        <table border="1">
            <TD>MessageId<TD>Receiver<TD>From<TD>Message<TD>Message Date<TR>
        <c:forEach items="${requestScope.userlist}" var="user">
            <TD>${user.messageId}
            <TD>${user.sender}
            <TD>${user.receiver}
            <TD>${user.message}
            <TD>${user.messageDate}<TR>
        </c:forEach>
       </table>
    </body>
</html>
