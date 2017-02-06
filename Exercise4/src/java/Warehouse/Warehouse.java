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
import java.util.Date;

import Manufacturer.*;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Samantha Graham
 */
@WebService(serviceName = "Warehouse")
public class Warehouse {

    private final int MIN_THRESHOLD = 5;

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
        WarehouseItems inventory = (WarehouseItems) jaxbUnmarshaller.unmarshal(new File("C:\\Users\\Kayleigh\\workspace\\scotch-box\\public\\SOEN487\\Assignment1\\Exercise4\\inventory.xml"));

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
                        // We need to update its quantity in inventory. Remove it from inventory
                        inventory.getItems().remove(inventoryItem);
                        // Update its quantity
                        inventoryItem.setQuantity(inventoryItem.getQuantity() - orderedItem.getQuantity());
                        // Put it back in the inventory
                        inventory.getItems().add(inventoryItem);

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
        jaxbMarshaller.marshal(inventory, new File("C:\\Users\\Kayleigh\\workspace\\scotch-box\\public\\SOEN487\\Assignment1\\Exercise4\\inventory.xml"));

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
        WarehouseItems inventory = (WarehouseItems) jaxbUnmarshaller.unmarshal(new File("C:\\Users\\Kayleigh\\workspace\\scotch-box\\public\\SOEN487\\Assignment1\\Exercise4\\inventory.xml"));

        // Go thru inventory items
        for (WarehouseItem item : inventory.getItems()) {
            // If the quantity of an item on hand is less than the defined threshold
            if (item.getQuantity() < MIN_THRESHOLD) {
                // Remove item from list
                inventory.getItems().remove(item);

                // Order the item from the manufacturer                
                PurchaseOrder order = new PurchaseOrder(new Date().toString(), "Warehouse A", item.getProduct(), 150, item.getProduct().getUnitPrice(), false);
                Manufacturer manu = new Manufacturer();

                // If the order was successful
                if (manu.processPurchaseOrder(order)) {
                    // Update item quantity
                    item.setQuantity(item.getQuantity() + 150);
                }
            }
        }

        // Re-marshal the file
        jaxbMarshaller.marshal(inventory, new File("C:\\Users\\Kayleigh\\workspace\\scotch-box\\public\\SOEN487\\Assignment1\\Exercise4\\inventory.xml"));
    }
}
