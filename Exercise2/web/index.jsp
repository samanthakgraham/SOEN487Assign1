<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SOEN487 Winter 2017 Assignment 2 Exercise 2</title>
    </head>
    <body>
        <h4>Convert temperatures from Fahrenheit to Celsius and back</h4>
        <form action="ConvertServlet" method="POST">
            <label for="temperature">Temperature to convert: </label>
            <input type="number" name="temperature" id="temperature" />
            <select name="units">
                <option value="f">Fahrenheit</option>
                <option value="c">Celsius</option>
            </select>
            <input type="submit" value="Convert" />
        </form>
        <%
            if((String)request.getAttribute("convertedTemp") != null) {
                %>
                Result: <%=(String)request.getAttribute("convertedTemp")%>
                <%
            }
        %>
    </body>
</html>
