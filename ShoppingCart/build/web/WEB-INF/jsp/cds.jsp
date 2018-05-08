<%-- 
    Document   : cds
    Created on : 15 Feb, 2018, 11:04:52 PM
    Author     : Bengre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Shop for CDs:</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <a href="cart.htm?action=view"/>[View Cart]</a>
        <form method='post' action='cart.htm'>
            <h2> Shop for CDs: </h2>
		<input type="checkbox" name="item" value="GTA Vice City" /> GTA Vice City [$12.95] <br>
        <input type="checkbox" name="item" value="RoadRash"/> RoadRash [$150.95] <br>
		<input type="checkbox" name="item" value="Mario"/> Mario [$14.95] <br>
        <input type="checkbox"  name="item" value="Counter Strike"/> Counter Strike [$15.99] <br>
		<input type="checkbox"  name="item" value="Dave"/> Dave [$27.95] <br>
        <br>
            
        <input type='hidden' name='action' value='add'/>
        <input type='submit' value='Add CDs to cart'>
        </form>
    </body>
</html>
