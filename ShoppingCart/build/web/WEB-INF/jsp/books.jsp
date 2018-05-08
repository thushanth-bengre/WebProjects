

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Shop for Books:</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <a href="cart.htm?action=view"/>[View Cart]</a>
        <form method='post' action='cart.htm'>
        <h2> Shop for Books: </h2>
		<input type="checkbox" name="item" value="Java Servlet Programming [$29.95]"/> Java Servlet Programming [$29.95] 
        <br>
        <input type="checkbox" name="item" value="Oracle Database Programming [$48.95] "/> Oracle Database Programming [$48.95] 
        <br>
		<input type="checkbox" name="item" value="System Analysis and Design with UML [$14.95]"/> System Analysis and Design with UML [$14.95] 
        <br>
        <input type="checkbox"  name="item" value="Object Oriented Software Engineering [$35.99]"/> Object Oriented Software Engineering [$35.99] 
        <br>
		<input type="checkbox"  name="item" value="Java Web Services [$27.95]"/> Java Web Services [$27.95]
        <br><br>
        
        <input type='hidden' name='action' value='add'/>

        <input type='submit' value='Add books to cart'>
        </form>
    </body>
</html>
