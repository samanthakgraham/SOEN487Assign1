package org.me.temperatureconverter;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.ejb.Stateless;

/**
 *
 * @author Samantha Graham
 */
@WebService(serviceName = "TemperatureConverterWS")
@Stateless()
public class TemperatureConverterWS {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "fahrenheitToCelsius")
    public String fahrenheitToCelsius(@WebParam(name = "tempInFahrenheit") String tempInFahrenheit) {
        return Double.toString(((Double.parseDouble(tempInFahrenheit) - 32) / 9) * 5);
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "celsiusToFahrenheit")
    public String celsiusToFahrenheit(@WebParam(name = "tempInCelsius") String tempInCelsius) {
        return Double.toString(((Double.parseDouble(tempInCelsius) / 5) * 9) + 32);
    }
}
