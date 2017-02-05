package Warehouse;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "WarehouseItems", namespace= "http://www.example.com")
@XmlAccessorType(XmlAccessType.FIELD)

/**
 *
 * @author Samantha Graham
 */
public class WarehouseItems {
    @XmlElement(name = "warehouseItem", namespace= "http://www.example.com/a")
    private List<WarehouseItem> items = null;

    public List<WarehouseItem> getItems() {
        return items;
    }

    public void setItems(List<WarehouseItem> items) {
        this.items = items;
    }
}
