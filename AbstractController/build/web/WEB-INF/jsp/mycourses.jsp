<%@page import="java.util.HashSet"%>
<%@page import="com.me.model.Course"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Course View</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <h3> Courses Added:</h3>
        <!--if there are no course in the set-->
        <%
            HashSet<Course> myCourseSet = (HashSet<Course>) session.getAttribute("myCourses");
            if (myCourseSet == null) {
                out.println("<div><p> No Course Added for you.</p></div>");
            } else {
                //else if there are courses, display every course in the set
                for (Course course : myCourseSet) {
                    out.println("CRN: " + course.getCrn() + " - Course Name: " + course.getName() + "[<a href='course.htm?action=remove&crn=" + course.getCrn() + "'>Remove Course</a>]<br />");
                }
            }
        %>
    </body>
</html>