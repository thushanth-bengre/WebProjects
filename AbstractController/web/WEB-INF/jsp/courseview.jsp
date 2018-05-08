<%@page import="com.me.model.Course"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Available Courses are:</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <form method='post' action='courses.htm'>
            <h2> Results found </h2>
            <%   //<jsp:scriplet>-> for new tags
              ArrayList<Course> results =  (ArrayList<Course>) request.getAttribute("searchResults");
              for(Course c : results) {
                  out.println("<input type='checkbox' name='crn' value='" + c.getCrn() + "' />" + c.getCrn() + " - " + c.getName() + " [<a href='course.htm?action=add&crn=" + c.getCrn() + "'>Add course</a>]<br />");
              }
            %>
            <input type='hidden' name='action' value='add'/>
            <input type='submit' value='Add selected courses'>
        </form>
    </body>
</html>
