<!-- <%@page import="java.util.ArrayList"%> -->
<!DOCTYPE html>
<html>
    <head>
        <title>Shop for Laptops:</title>
    </head>
    <body>
        <jsp:include page="menu.jsp"/>
        <a href="cart.jsp"/>[View Cart]</a>
        <form method='post' action='cart'>
            <h2> Shop for Laptops: </h2>
		<input type="checkbox" name="item" value="Apple MacBook Pro [$1229.95]" /> Apple MacBook Pro [$1229.95] <br>
        <input type="checkbox" name="item" value=" Dell XPS [$1508.95]"/> Dell XPS [$1508.95] <br>

		<input type="checkbox" name="item" value="HP Pavlion [$1114.95]"/> HP Pavlion [$1114.95] 
        <br>
        
        <input type="checkbox"  name="item" value="Asus [$1135.99]"/> Asus [$1135.99] <br>
		<input type="checkbox" name="item" value="Samsung [$927.95]"/> Samsung [$927.95]
        <br>
        <br>
            
            <input type='hidden' name='action' value='add'/>
            <input type='submit' value='Add laptops to cart'>
        </form>
    </body>
</html>