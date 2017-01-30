package Manufacturer;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Samantha Graham
 */
@WebService(serviceName = "Manufacturer")
public class Manufacturer {

    /**
     * Processes a purchase order
     */
    @WebMethod(operationName = "processPurchaseOrder")
    public boolean processPurchaseOrder() {        
        return true;
    }

    /**
     * Returns product information as defined in the XML file
     * @param productName The name of the product to look up
     * @return Product information or null
     */
    @WebMethod(operationName = "getProductInfo")
    public Product getProductInfo(@WebParam(name = "productName") String productName) {
        //TODO write your implementation code here:
        return null;
    }
        
    /**
     * Records payment and sets the corresponding order to "paid"
     * @param orderNum The order number
     * @param totalPrice The price of the order
     * @return boolean
     */
    @WebMethod(operationName = "receivePayment")
    public boolean receivePayment(@WebParam(name = "orderNum") String orderNum, @WebParam(name = "totalPrice") float totalPrice) {        
        return true;
    }
    
    /*
    * Simulates production of a product
    */
    private boolean product(String productName, int quantity) {
        if(quantity > 100) {
            return false;
        } else {
            switch(productName.toLowerCase()) {
                case "dvd player":
                case "tv":
                case "video camera":
                    return true;                    
                default:
                    return false;
            }
        }
    }
}
