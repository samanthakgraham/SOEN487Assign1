package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import javax.servlet.RequestDispatcher;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import java.util.ArrayList;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

/**
 *
 * @author Samantha Graham
 */
public class IndexController extends HttpServlet {

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {  
        // Get the RSS feed and save it in an InputStream
        URL url = new URL("http://www.ledevoir.com/rss/ledevoir.xml");
        
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setRequestProperty("Accept", "application/xml");        
        InputStream xml = connection.getInputStream();

        // Use DocumentBuilder to parse the XML
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        
        // We'll redirect to titles.jsp to display the titles
        RequestDispatcher rd = request.getRequestDispatcher("titles.jsp");

        try {
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(xml);            
            NodeList nList = doc.getElementsByTagName("item");
            
            // Save the titles in a list of Strings that we'll send to the view
            ArrayList<String> titles = new ArrayList<String>();

            for (int i = 0; i < nList.getLength(); i++) {
                Node nNode = nList.item(i);
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    
                    // Create a link to the article using the <link> and <title> elements of the RSS feed
                    String title = eElement.getElementsByTagName("title").item(0).getTextContent();
                    String link = eElement.getElementsByTagName("link").item(0).getTextContent();
                    titles.add("<a href='" + link + "' target='_blank'>" + title + "</a>");
                }
            }

            request.setAttribute("titles", titles);
            rd.forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
