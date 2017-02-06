package controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.RequestDispatcher;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBException;
import Warehouse.*;
import Manufacturer.*;

/**
 *
 * @author Samantha Graham
 */
public class OrderController extends HttpServlet {

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {        
        RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
        List shippingResultList = null;
        
        // Keep track of what's in the order
        ArrayList<WarehouseItem> order = new ArrayList<WarehouseItem>();
        
        // Get the products requested (checkboxes)
        String products[] = request.getParameterValues("product[]");
        
        // If no product checkbox was checked
        if (products == null) {
            // Return an error
            request.setAttribute("error", "You must choose at least one product.");
            rd.forward(request, response);
        } else {
            // Otherwise, loop thru selected products
            for (String product : products) {
                String productQuantity = request.getParameter(product + "-qty");
                
                // If the quantity for a given product is empty
                if(productQuantity.isEmpty()) {
                    // Return an error
                    request.setAttribute("error", "You must specify a quantity for each chosen product.");
                    rd.forward(request, response);
                } else {
                    // Otherwise, add the product and its specified quantity to the order
                    try {
                        Manufacturer manu = new Manufacturer();
                        Product productObject = manu.getProductInfo(product);
                        WarehouseItem wi = new WarehouseItem(productObject, Integer.parseInt(productQuantity));                        
                        order.add(wi); 
                    } catch(JAXBException e) {
                        System.out.println(e.toString());
                    }                                       
                }
            }
            
            // Attempt to ship
            Warehouse wr = new Warehouse();
            try {
                shippingResultList = wr.shipGoods(order);
                
                // Return lists to user
                request.setAttribute("shippingResult", shippingResultList);
                rd.forward(request, response);
            } catch(JAXBException e) {
                System.out.println(e.toString());
            }
            
        }
    }
}
