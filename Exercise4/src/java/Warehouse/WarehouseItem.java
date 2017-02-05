package Warehouse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import Manufacturer.Product;

/**
 *
 * @author Samantha Graham
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "product",
    "quantity"
})
@XmlRootElement(name = "warehouseItem")

public class WarehouseItem {
    @XmlElement(required = true)
    private Product product;
    @XmlElement(required = true)
    private int quantity;

    public WarehouseItem() {
        product = null;
        quantity = 0;
    }
    
    public WarehouseItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public void setProduct(Product product) {
        this.product = product;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
