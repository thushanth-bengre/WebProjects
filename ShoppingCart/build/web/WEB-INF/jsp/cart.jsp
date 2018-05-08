<%@page import="java.util.*"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cart View</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <form method='post' action='cart.htm'>
        <h3> Items Added to cart:</h3>
        

            <%
            HashSet<String> myCart = (HashSet<String>) session.getAttribute("myCart");
            if (myCart == null) {
                out.println("<div><p> Your cart is empty</p></div>");
            
            } 

            else {
                
                for (String item : myCart) {
                    out.println("<input type = 'checkbox' name = 'item' value ='" + item + "' /> "+ item);
                    out.println("<br>");
                }
          }  
        %>
        <input type='hidden' name='action' value='remove'/>
        <input type="submit" value="Remove from cart">
        </form>
    </body>
</html>
