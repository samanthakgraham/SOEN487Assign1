package Manufacturer;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class PurchaseOrderMarshalling {

//Initialize the orders list
    static PurchaseOrders orders = new PurchaseOrders();

    static {
        orders.setOrders(new ArrayList<PurchaseOrder>());
        
        // Create some orders
        Product prod1 = new Product("Brand2", "DVD Player", 75);
        PurchaseOrder order1 = new PurchaseOrder("1", "1", prod1, 1, 75, false);
        PurchaseOrder order2 = new PurchaseOrder("2", "2", prod1, 2, 150, false);
        
        Product prod2 = new Product("Brand1", "TV", 500);
        PurchaseOrder order3 = new PurchaseOrder("3", "1", prod2, 1, 500, false);
        
        orders.getOrders().add(order1);
        orders.getOrders().add(order2);
        orders.getOrders().add(order3);
    }

    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(PurchaseOrders.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Marshal the orders list in file
        jaxbMarshaller.marshal(orders, new File("orders.xml"));
    }
}
