<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SOEN 487 Assignment 1 Exercise 1</title>
    </head>
    <body>
        <h1>Le Devoir titles</h1>
        <%
            if(request.getAttribute("titles") != null) {
                ArrayList<String> titles = (ArrayList<String>)request.getAttribute("titles");
            
                for(String title : titles) {
                    %>
                    <p><%=title%></p>
                    <%
                }
            }            
        %>
    </body>
</html>
