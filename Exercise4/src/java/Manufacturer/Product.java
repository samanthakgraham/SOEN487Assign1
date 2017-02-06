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
    "manufacturerName",
    "productType",
    "unitPrice"
})
@XmlRootElement(name = "product")
public class Product {
    @XmlElement(required = true)
    private String manufacturerName;
    @XmlElement(required = true)
    private String productType;
    @XmlElement(required = true)
    private float unitPrice;
    
    public Product() {
        manufacturerName = "default";
        productType = "default";
        unitPrice = 0;
    }
    
    public Product(String manufacturer, String type, float price) {
        this.manufacturerName = manufacturer;
        this.productType = type;
        this.unitPrice = price;
    }
    
    public String getManufacturerName() {
        return manufacturerName;
    }
    
    public void setManufacturerName(String manufacturer) {
        this.manufacturerName = manufacturer;
    }
    
    public String getProductType() {
        return productType;
    }
    
    public void setProductType(String type) {
        this.productType = type;
    }
    
    public float getUnitPrice() {
        return unitPrice;
    }
    
    public void setUnitPrice(float price) {
        this.unitPrice = price;
    }
    
    public boolean equals(Product prod) {
        return (this.manufacturerName.equals(prod.getManufacturerName()) && this.productType.equals(prod.getProductType()) && this.unitPrice == prod.getUnitPrice());
    }
}
