package exercise3;

import java.math.BigInteger;
import org.wsdl.creditreport.CreditReport;

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
        cr.setDob("1989/01/01");
        cr.setScore("800");
        cr.setSsn("143-45-6799");
        cr.setLatestAddress1("2501 Ste-Catherine");
        cr.setLatestAddress2("Apt 203");
        cr.setCity("Montreal");
        cr.setState("Quebec");
        cr.setCountry("Canada");
        cr.setPostalCode("H2M 0A3");
        cr.setCurrency("CAD");
        cr.setLiability(BigInteger.valueOf(4000000));
        cr.setLiquidAssests(BigInteger.valueOf(5000000));
        cr.setImmovableAssests(BigInteger.valueOf(6000000));
        
        try {            
            javax.xml.bind.JAXBContext jaxbCtx = javax.xml.bind.JAXBContext.newInstance(cr.getClass().getPackage().getName());
            javax.xml.bind.Marshaller marshaller = jaxbCtx.createMarshaller();
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_ENCODING, "UTF-8"); //NOI18N
            marshaller.setProperty(javax.xml.bind.Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(cr, System.out);
        } catch (javax.xml.bind.JAXBException ex) {
            // XXXTODO Handle exception
            java.util.logging.Logger.getLogger("global").log(java.util.logging.Level.SEVERE, null, ex); //NOI18N
        }

    }

}
