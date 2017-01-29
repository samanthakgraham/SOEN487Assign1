package Warehouse;

import java.util.List;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Samantha Graham
 */
@WebService(serviceName = "Warehouse")
public class Warehouse {
    
    private final int MIN_THRESHOLD = 5;

    /**
     * Ships items in the given list to the customer if available
     * @param itemList The list of items to ship
     * @return The list of items shipped and not shipped
     */
    @WebMethod(operationName = "shipGoods")
    public List shipGoods(@WebParam(name = "itemList") List itemList) {        
        return null;
    }

    /*
     * Orders items if they fall below a given threshold 
    */
    private void replenish() {
        
    }
}
