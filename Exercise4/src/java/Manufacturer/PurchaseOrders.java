package Manufacturer;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "PurchaseOrders", namespace= "http://www.example.com")
@XmlAccessorType(XmlAccessType.FIELD)

/**
 *
 * @author Samantha Graham
 */
public class PurchaseOrders {
    @XmlElement(name = "purchaseOrder", namespace= "http://www.example.com/a")
    private List<PurchaseOrder> orders = null;

    public List<PurchaseOrder> getOrders() {
        return orders;
    }

    public void setProducts(List<PurchaseOrder> orders) {
        this.orders = orders;
    }
}
