<%-- 
    Document   : browsepage
    Created on : 21 Feb, 2018, 2:13:08 AM
    Author     : Bengre
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body bgcolor="#66a3ff">
        <h1>Searching Movies</h1>
        <form name='search' action="browse">
               KeyWord:   <input type="text" name="keyword"  /><br/><br/>
                <input type="radio" name="search"  value="name" /> Search by Title<br/><br/>                
                <input type="radio" name="search"  value="actor" /> Search by Actor<br/><br/>
                <input type="radio" name="search"  value="actress" /> Search by Actress<br/><br/>  
                <input type="radio" name="search"  value="genre" /> Search by Genre<br/><br/>
                <input type="radio" name="search"  value="year" /> Search by Year<br/><br/>
                <input type="hidden" name="action" value="fetch" />
                <input type="submit" value="Search" />
            </form>
    </body>
</html>
