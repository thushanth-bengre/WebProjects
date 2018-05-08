<!DOCTYPE html>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page session="true" %>
<html>
    <head>
        <title>Select Courses</title>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="Cache-Control" content="no-cache, no-store, must-revalidate" />
        <meta http-equiv="Pragma" content="no-cache" />
        <meta http-equiv="Expires" content="0" />
        <!--This is html4 to disable cache-->
        <!--add those line later-->
    </head>
    <body>
        <div>
            <h2> Search Courses</h2>
            <form id="form" action="courses.htm" method="get" >   <!--course.do is course controller-->
                <jsp:include page="menu.jsp"></jsp:include>                
                <br />
                <br />                 
                Search Query <input type="text" name="query"/> <br/><br/>
                <input type="radio" name="searchType" value="crn" checked=""/> Search By CRN
                <input type="radio" name="searchType" value="title"/> Search By Instructor or Title
                <input type="hidden" name="action" value="search" />
                <br/><input type="submit" value="SEARCH"/>
            </form>
        </di>
    </body>
</html>
