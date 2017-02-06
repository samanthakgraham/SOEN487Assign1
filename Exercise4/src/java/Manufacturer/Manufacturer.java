package Manufacturer;

import static Manufacturer.PurchaseOrderMarshalling.orders;
import java.io.File;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

/**
 *
 * @author Samantha Graham
 */
@WebService(serviceName = "Manufacturer")
public class Manufacturer {

    /**
     * Processes a purchase order
     * @param purchaseOrder The PurchaseOrder to process
     * @return success Whether or not the order was purchased
     * @throws JAXBException
     */
    @WebMethod(operationName = "processPurchaseOrder")
    public boolean processPurchaseOrder(PurchaseOrder purchaseOrder) throws JAXBException{   
        boolean success = false;
        
        // Get products by unmarshalling the file
        JAXBContext jaxbContextProducts = JAXBContext.newInstance(Products.class);
        Unmarshaller jaxbUnmarshaller = jaxbContextProducts.createUnmarshaller();
        Products products = (Products) jaxbUnmarshaller.unmarshal(new File("C:\\Users\\Kayleigh\\workspace\\scotch-box\\public\\SOEN487\\Assignment1\\Exercise4\\products.xml"));
        
        // Go thru products
        for (Product product : products.getProducts()) {
            // Find the one in our order and make sure our order's unit price is more than the product's unit price
            if(product.getProductType().equals(purchaseOrder.getProduct().getProductType()) && purchaseOrder.getUnitPrice() >= product.getUnitPrice()) {
                // Produce the order
                int quantity = purchaseOrder.getQuantity();
                
                while(quantity > 100) {
                    produce(purchaseOrder.getProduct().getProductType(), 100);                    
                    quantity -= 100;
                }                
                success = produce(purchaseOrder.getProduct().getProductType(), quantity);
                
                // If we were able to produce the order
                if(success) {
                    // Marshal it to the XML file
                    PurchaseOrders ordersToMarshal = new PurchaseOrders();
                    ordersToMarshal.setOrders(new ArrayList<PurchaseOrder>());
                    ordersToMarshal.getOrders().add(purchaseOrder);
                    JAXBContext jaxbContextPurchaseOrders = JAXBContext.newInstance(PurchaseOrders.class);
                    Marshaller jaxbMarshaller = jaxbContextPurchaseOrders.createMarshaller();
                    jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);                    
                    jaxbMarshaller.marshal(ordersToMarshal, new File("C:\\Users\\Kayleigh\\workspace\\scotch-box\\public\\SOEN487\\Assignment1\\Exercise4\\orders.xml"));
                }
                
                // Break out of the for loop
                break;
            }
        }
        
        return success;
    }

    /**
     * Returns product information as defined in the XML file
     * @param productName The name of the product to look up
     * @return Product information or null
     * @throws JAXBException
     */
    @WebMethod(operationName = "getProductInfo")
    public Product getProductInfo(@WebParam(name = "productName") String productName) throws JAXBException {
        // Get the list of products by unmarshalling
        JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Products prods = (Products) jaxbUnmarshaller.unmarshal(new File("C:\\Users\\Kayleigh\\workspace\\scotch-box\\public\\SOEN487\\Assignment1\\Exercise4\\products.xml"));
        
        // Go thru the products
        for (Product prod : prods.getProducts()) {
            // If we've found the one we want, return it
            if(prod.getProductType().toLowerCase().equals(productName.toLowerCase())) {
                return prod;
            }
        }
        
        // Otherwise we return null
        return null;
    }
        
    /**
     * Records payment and sets the corresponding order to "paid"
     * @param orderNum The order number
     * @param totalPrice The price of the order
     * @return boolean
     * @throws JAXBException
     */
    @WebMethod(operationName = "receivePayment")
    public boolean receivePayment(@WebParam(name = "orderNum") String orderNum, @WebParam(name = "totalPrice") float totalPrice) throws JAXBException{  
        boolean success = false;
        
        // Get orders from XML by unmarshaling
        JAXBContext jaxbContext = JAXBContext.newInstance(PurchaseOrders.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        PurchaseOrders orders = (PurchaseOrders) jaxbUnmarshaller.unmarshal(new File("C:\\Users\\Kayleigh\\workspace\\scotch-box\\public\\SOEN487\\Assignment1\\Exercise4\\orders.xml"));
        
        // Go thru orders
        for(PurchaseOrder order: orders.getOrders()) {
            // Find the one we want
            if(order.getOrderNum().equals(orderNum) && totalPrice == order.getUnitPrice()) {
                // Remove it from the list
                orders.getOrders().remove(order);
                
                // Change its status
                order.setPaidStatus(true);
                
                // Put it back in the list
                orders.getOrders().add(order);
                
                success = true;
            }
        }
        
        // Re-marshal the file
        jaxbMarshaller.marshal(orders, new File("C:\\Users\\Kayleigh\\workspace\\scotch-box\\public\\SOEN487\\Assignment1\\Exercise4\\orders.xml"));
        
        // Return
        return success;
    }
    
    /*
    * Simulates production of a product
    */
    private boolean produce(String productName, int quantity) {
        if(quantity < 0 || quantity > 100) {
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
