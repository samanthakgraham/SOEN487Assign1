package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import TemperatureConverter.TemperatureConverter;

/**
 *
 * @author Samantha Graham
 */
public class ConvertServlet extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get POST data
        String temperature = request.getParameter("temperature");
        String temperatureUnits = request.getParameter("units");
        
        // Initialize what we need to convert
        String convertedTemperature = "";
        TemperatureConverter tc = new TemperatureConverter();
        
        // Convert
        switch(temperatureUnits) {
            case "f": 
                convertedTemperature = tc.FahrenheitToCelsius(temperature) + " C";
                break;
            case "c": convertedTemperature = tc.CelsiusToFahrenheit(temperature) + " F";
                break;
        }
        
        // Redirect to index and display the result
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        request.setAttribute("convertedTemp", convertedTemperature);
        rd.forward(request, response);
    }
}
