package Warehouse;

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
    "customerRef",
    "firstName",
    "lastName",
    "address",
    "city",
    "province",
    "postalCode", 
    "email",
    "phone"
})

@XmlRootElement(name = "customer")
public class Customer {
    @XmlElement(required = true)
    private String customerRef;
    @XmlElement(required = true)
    private String firstName;
    @XmlElement(required = true)
    private String lastName;
    @XmlElement(required = true)
    private String address;
    @XmlElement(required = true)
    private String city;
    @XmlElement(required = true)
    private String province;
    @XmlElement(required = true)
    private String postalCode;
    @XmlElement(required = true)
    private String email;
    @XmlElement(required = true)
    private String phone;
    
    public Customer() {
        customerRef = "";
        firstName = "";
        lastName = "";
        address = "";
        city = "";
        province = "";
        postalCode = "";
        email = "";
        phone = "";
    }
    
    public Customer(String customerRef, String firstName, String lastName, String address, String city, String province, String postalCode, String email, String phone) {
        this.customerRef = customerRef;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.city = city;
        this.province = province;
        this.postalCode = postalCode;
        this.email = email;
        this.phone = phone;
    }
    
    public String getCustomerRef() {
        return customerRef;
    }
    
    public void setCustomerRef(String ref) {
        customerRef = ref;
    }
    
    public String getFirstName() {
        return firstName;
    }
    
    public void setFirstName(String name) {
        firstName = name;
    }
    
    public String getLastName() {
        return lastName;
    }
    
    public void setLastName(String name) {
        lastName = name;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String addr) {
        address = addr;
    }
    
    public String getCity() {
        return city;
    }
    
    public void setCity(String city) {
        this.city = city;
    }
    
    public String getProvince() {
        return province;
    }
    
    public void setProvince(String prov) {
        province = prov;
    }
    
    public String getPostalCode() {
        return postalCode;
    }
    
    public void setPostalCode(String pc) {
        postalCode = pc;
    }
    
    public String getEmail() {
        return email;
    }
    
    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getPhone() {
        return phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
