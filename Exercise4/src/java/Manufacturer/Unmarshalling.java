package Manufacturer;

import java.io.File;
import java.util.ArrayList;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;



public class Unmarshalling {

    public static void main(String[] args) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(Products.class);
        Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();

        Products prods = (Products) jaxbUnmarshaller.unmarshal(new File("products.xml"));

//        for (Student std : stds.getStudents()) {
//            System.out.println(std.getId());
//            System.out.println(std.getName());
//            System.out.println(std.getMajor());
//            System.out.println(std.getStartYear());
//            System.out.println(std.getEndYear());
//        }
    }
}
