package Manufacturer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Samantha Graham
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "orderNum",
    "customerRef",
    "product",
    "quantity",
    "unitPrice"
})

@XmlRootElement(name = "purchaseOrder")
public class PurchaseOrder {
    @XmlElement(required = true)
    private String orderNum;
    @XmlElement(required = true)
    private String customerRef;
    @XmlElement(required = true)
    private Product product;
    @XmlElement(required = true)
    private int quantity;
    @XmlElement(required = true)
    private float unitPrice;
    
    public PurchaseOrder() {
        orderNum = "0";
        customerRef = "0";
        product = null;
        quantity = 0;
        unitPrice = 0;
    }
    
    public PurchaseOrder(String order, String customer, Product prod, int qty, float price) {
        this.orderNum = order;
        this.customerRef = customer;
        this.product = prod;
        this.quantity = qty;
        this.unitPrice = price;
    }
    
    public String getOrderNum() {
        return orderNum;
    }
    
    public void setOrderNum(String order) {
        this.orderNum = order;
    }
    
    public String getCustomerRef() {
        return customerRef;
    }
    
    public void setCustomerRef(String customer) {
        this.customerRef = customer;
    }
    
    public Product getProduct() {
        return product;
    }
    
    public void setProduct(Product prod) {
        this.product = prod;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public void setQuantity(int qty) {
        this.quantity = qty;
    }
    
    public float getUnitPrice() {
        return unitPrice;
    }
    
    public void setUnitPrice(float price) {
        this.unitPrice = price;
    }
}
