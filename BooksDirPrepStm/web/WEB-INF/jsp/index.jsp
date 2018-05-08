<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body bgcolor="#76D7C4">
        <h1>How Many books do you want to add</h1>        
        <form action="add.htm">
            <input type="text" name="number" />
            <input type='hidden' name='action' value='add'/>
            <input type="submit" value="SUBMIT"/>
            <a href="add.htm?action=view">Click Here to see all Books!</a>
        </form>
    </body>
</html>
