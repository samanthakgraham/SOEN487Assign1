package exercise3;

import java.math.BigInteger;
import org.netbeans.j2ee.wsdl.creditreport.CreditReport;

/**
 *
 * @author Samantha Graham
 */
public class Exercise3 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        CreditReport cr = new CreditReport();
        cr.setFirstName("Samantha");
        cr.setLastName("Graham");
        cr.setDob("1989/01/09");
        cr.setScore("900");
        cr.setSsn("123-45-6789");

        cr.setLatestAddress1("123 Some Ave");
        cr.setLatestAddress2("Apt 456");
        cr.setCity("Montreal");
        cr.setState("Quebec");
        cr.setCountry("Canada");
        cr.setPostalCode("H1H1H1");

        cr.setCurrency("CAD");
        cr.setLiability(BigInteger.valueOf(2000000));
        cr.setLiquidAssests(BigInteger.valueOf(3000000));
        cr.setImmovableAssests(BigInteger.valueOf(5000000));
        
        try {            
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(cr.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8");
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(cr, System.out);
        } catch (javax.xml.bind.JAXBException ex) {            
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex);
        }
    }

}
