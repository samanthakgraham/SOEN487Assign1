package Warehouse;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.bind.Marshaller;
import java.util.Date;

import Manufacturer.*;

/**
 *
 * @author Samantha Graham
 */
@WebService(serviceName = "Warehouse")
public class Warehouse {

    private final int MIN_THRESHOLD = 5;
    private final int ORDER_QUANTITY = 150;
    private final String INVENTORY_FILE_LOCATION = "C:\\Users\\Kayleigh\\workspace\\scotch-box\\public\\SOEN487\\Assignment1\\Exercise4\\inventory.xml";

    /**
     * Ships items in the given list to the customer if available
     *
     * @param itemList The list of items to ship
     * @return The list of items shipped and not shipped
     * @throws JAXBException
     */
    @WebMethod(operationName = "shipGoods")
    public List shipGoods(@WebParam(name = "itemList") List<WarehouseItem> itemList) throws JAXBException {
        // Get inventory by unmarshalling the file
        JAXBContext jaxbContext = JAXBContext.newInstance(WarehouseItems.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        WarehouseItems inventory = (WarehouseItems) jaxbUnmarshaller.unmarshal(new File(INVENTORY_FILE_LOCATION));

        // Lists we'll need
        ArrayList<WarehouseItem> shippedItems = new ArrayList<WarehouseItem>();
        ArrayList<WarehouseItem> notShippedItems = new ArrayList<WarehouseItem>();
        ArrayList<ArrayList> returnList = new ArrayList<ArrayList>();

        // Loop thru list of items in customer order
        for (WarehouseItem orderedItem : itemList) {
            boolean existsInInventory = false;

            for (WarehouseItem inventoryItem : inventory.getItems()) {
                // If this item exists in our inventory
                if (inventoryItem.getProduct().equals(orderedItem.getProduct())) {
                    existsInInventory = true;

                    if (inventoryItem.getQuantity() >= orderedItem.getQuantity()) {
                        // Update its quantity
                        inventoryItem.setQuantity(inventoryItem.getQuantity() - orderedItem.getQuantity());

                        // Ship it                        
                        shippedItems.add(orderedItem);
                    } else {
                        // We can't ship it                        
                        notShippedItems.add(orderedItem);
                    }
                }
            }

            if (!existsInInventory) {
                // We can't ship it                
                notShippedItems.add(orderedItem);
            }
        }

        // Re-marshal the file
        jaxbMarshaller.marshal(inventory, new File(INVENTORY_FILE_LOCATION));

        // Replenish inventory
        replenish();

        // Return the lists
        returnList.add(shippedItems);
        returnList.add(notShippedItems);
        return returnList;
    }

    /*
     * Orders items if they fall below a given threshold 
     */
    private void replenish() throws JAXBException {
        // Get inventory by unmarshalling the file
        JAXBContext jaxbContext = JAXBContext.newInstance(WarehouseItems.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        WarehouseItems inventory = (WarehouseItems) jaxbUnmarshaller.unmarshal(new File(INVENTORY_FILE_LOCATION));

        // Go thru the inventory
        for(WarehouseItem item: inventory.getItems()) {
            // If we need to order more
            if (item.getQuantity() < MIN_THRESHOLD) {                                
                // Order the item from the manufacturer
                String orderNum = Long.toString(new Date().getTime());
                float orderTotal = item.getProduct().getUnitPrice() * ORDER_QUANTITY;
                
                PurchaseOrder order = new PurchaseOrder(orderNum, "Warehouse A", item.getProduct(), ORDER_QUANTITY, orderTotal, false);
                Manufacturer manu = new Manufacturer();

                // If the order was successful
                if (manu.processPurchaseOrder(order)) {
                    // Update item quantity in the inventory                    
                    item.setQuantity(item.getQuantity() + ORDER_QUANTITY);
                    
                    // Pay for the order
                    manu.receivePayment(orderNum, orderTotal);
                }
            } 
        }

        // Re-marshal the file
        jaxbMarshaller.marshal(inventory, new File(INVENTORY_FILE_LOCATION));
    }
}
