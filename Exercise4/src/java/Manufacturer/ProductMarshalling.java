package Manufacturer;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class ProductMarshalling {

    // Initialize the products list
    static Products products = new Products();

    static {
        products.setProducts(new ArrayList<Product>());
        
        // Create some products
        Product prod1 = new Product("Brand1", "TV", 500);
        Product prod2 = new Product("Brand2", "DVD Player", 99);
        Product prod3 = new Product("Brand3", "video camera", 150);
        
        // Add them to the list
        products.getProducts().add(prod1);
        products.getProducts().add(prod2);
        products.getProducts().add(prod3);
    }

    public static void main(String[] args) throws Exception {
        JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
        Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
        jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        // Marshal the products list in file
        jaxbMarshaller.marshal(products, new File("products.xml"));
    }
}
