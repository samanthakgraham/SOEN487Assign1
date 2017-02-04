<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Assignment 1 Exercise 2 - SOEN 487</title>
    </head>
    <body>
        <h4>Temperature Converter Tests</h4>    
    <%-- start web service invocation --%><hr/>
    <%
    try {
	org.me.temperatureconverter.TemperatureConverterWS_Service service = new org.me.temperatureconverter.TemperatureConverterWS_Service();
	org.me.temperatureconverter.TemperatureConverterWS port = service.getTemperatureConverterWSPort();
	 
	java.lang.String tempInCelsius = "0";
	
	java.lang.String result = port.celsiusToFahrenheit(tempInCelsius);
	out.println(tempInCelsius + " in Fahrenheit is " + result + "F");
    } catch (Exception ex) {
	out.println("exception" + ex);
    }
    %>
    <%-- end web service invocation --%><hr/>
    <%-- start web service invocation --%><hr/>
    <%
    try {
	org.me.temperatureconverter.TemperatureConverterWS_Service service = new org.me.temperatureconverter.TemperatureConverterWS_Service();
	org.me.temperatureconverter.TemperatureConverterWS port = service.getTemperatureConverterWSPort();
	 
	java.lang.String tempInFahrenheit = "100";
	
	java.lang.String result = port.fahrenheitToCelsius(tempInFahrenheit);
	out.println(tempInFahrenheit + " in Celsius is " + result + "C");
    } catch (Exception ex) {
	out.println("exception" + ex);
    }
    %>
    <%-- end web service invocation --%><hr/>

    </body>
</html>
