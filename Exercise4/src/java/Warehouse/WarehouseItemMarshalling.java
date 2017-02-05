package Warehouse;

import Manufacturer.Product;
import Manufacturer.Products;
import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

/**
 *
 * @author Samantha Graham
 */
public class WarehouseItemMarshalling {
    // Initialize the items list
    static WarehouseItems items = new WarehouseItems();

    static {
        items.setItems(new ArrayList<WarehouseItem>());
        
        // Create some items
        Product prod1 = new Product("Brand1", "TV", 500);
        Product prod2 = new Product("Brand2", "DVD Player", 99);
        Product prod3 = new Product("Brand3", "video camera", 150);
        
        WarehouseItem item1 = new WarehouseItem(prod1, 25);
        WarehouseItem item2 = new WarehouseItem(prod2, 100);
        WarehouseItem item3 = new WarehouseItem(prod3, 10);
        
        // Add them to the list
        items.getItems().add(item1);
        items.getItems().add(item2);
        items.getItems().add(item3);
    }

    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(WarehouseItems.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Marshal the products list in file
        jaxbMarshaller.marshal(items, new File("inventory.xml"));
    }
}
