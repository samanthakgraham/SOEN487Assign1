
package classes;

import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorOrder;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlNs;
import javax.xml.bind.annotation.XmlNsForm;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;
import javax.xml.bind.annotation.XmlType;

/**
 *
 * @author Samantha Graham
 */

@XmlRootElement(name = "newsitem", namespace= "http://www.example.com/a")
@XmlAccessorType(XmlAccessType.FIELD)
public class NewsItem {
    private String title;
    private String category;
    private String link;
    
    public NewsItem() {
        
    }
    
    public NewsItem(String title, String category, String link) {
        this.title = title;
        this.category = category;
        this.link = link;
    }
    
    public String getTitle() {
        return title;
    }
    
    public String getCategory() {
        return category;
    }
    
    public String getLink() {
        return link;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public void setCategory(String category) {
        this.category = category;
    }
    
    public void setLink(String link) {
        this.title = link;
    }
}
