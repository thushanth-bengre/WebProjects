<!--By default this is true-->
<!--Even if this line is removed, by default the session will continue.-->
<!--Session is an implicit object in JSP-->
<%@ page session="true" %>     <!--true by default but it is for us to decide--> 
<!--create a Scriplet-->
<% 
    String user = (String)session.getAttribute("username");
     String remMe = (String) session.getAttribute("rememberMe"); 
     if(user!= null){
         if(remMe != null){
              Cookie c = new Cookie("username", user);
              c.setMaxAge(24*60*60);
              response.addCookie(c);
         }
         
    response.sendRedirect("searchCourse.jsp");
    
}
     

%>

<!--remember me - cookie compare to username pwd and redirect to searchCourse-->
<!DOCTYPE html>
<html>
    <head>
        <title>NEU Courses</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        
    </head>
    <body>
        <div>
            <h1>Login</h1>
            <form name='myForm' method="post" action="login.htm?action=login">     
                <input type="text" name="username" placeholder="Username" /><br/><br/>
                <input type="password" name="password" placeholder="Password"  /><br/><br/>                
                <input type="checkbox" name="rememberMe" value="remember" /> Remember me  <br/><br/>
                <input type="submit" value="Log In" />
            </form>
        </div>
    </body>
</html>
