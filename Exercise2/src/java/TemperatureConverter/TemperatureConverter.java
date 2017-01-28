package TemperatureConverter;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Samantha Graham
 */
@WebService(serviceName = "TemperatureConverter")
public class TemperatureConverter {

    /**
     * Converts Fahrenheit to Celsius
     * @param fahrenheit The temperature in Fahrenheit to convert
     * @return The converted temperature in Celsius
     */
    @WebMethod(operationName = "FahrenheitToCelsius")
    public String FahrenheitToCelsius(@WebParam(name = "fahrenheit") String fahrenheit) {                
        return Double.toString(((Double.parseDouble(fahrenheit) - 32) / 9) * 5);
    }
    
    /*
    * Converts Celsius to Fahrenheit
    * @param celsius The temperature in Celsius to convert
    * @return The converted temperature in Fahrenheit
    */
    @WebMethod(operationName = "CelsiusToFahrenheit")
    public String CelsiusToFahrenheit(@WebParam(name = "celsius") String celsius){
        return Double.toString(((Double.parseDouble(celsius) / 5) * 9) + 32);
    }
}
