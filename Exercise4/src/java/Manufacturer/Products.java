package Manufacturer;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "Products", namespace= "http://www.example.com")
@XmlAccessorType(XmlAccessType.FIELD)

/**
 *
 * @author Samantha Graham
 */
public class Products {
    @XmlElement(name = "product", namespace= "http://www.example.com/a")
    private List<Product> products = null;

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
