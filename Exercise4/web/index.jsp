<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.ArrayList" %>
<%@page import="Warehouse.*" %>
<%@page import="Manufacturer.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Supply Chain Management Application - SOEN487 Winter 2017 Assignment 1 Exercise 4</title>
        
        <link rel="stylesheet" href="css/main.css">
        
        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">

        <!-- Bootstrap JavaScript -->
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous"></script>
    </head>
    <body>
        <div class="container">
            <h4>Place your order below:</h4>
            <form action="OrderController" method="POST">
                <div class="form-group">
                    <input type="checkbox" name="product[]" value="tv" /> Brand1 TV
                    <input type="number" name="tv-qty" placeholder="Quantity" />
                </div>
                <div class="form-group">
                    <input type="checkbox" name="product[]" value="dvd player" /> Brand2 DVD Player
                    <input type="number" name="dvd player-qty" placeholder="Quantity" />
                </div>
                <div class="form-group">
                    <input type="checkbox" name="product[]" value="video camera" /> Brand3 Video Camera
                    <input type="number" name="video camera-qty" placeholder="Quantity" />
                </div>        
                <div class="form-group">
                    <input type="submit" value="Place Order" class="btn btn-success" />
                </div>
            </form>
            <%
                if((String)request.getAttribute("error") != null) {
                %>
                <p class="bg-danger text-danger">
                    <%=(String)request.getAttribute("error")%>
                </p>                
                <%
            }            
            if((ArrayList)request.getAttribute("shippingResult") != null) {
                ArrayList<ArrayList> shippingResult = (ArrayList)request.getAttribute("shippingResult");
                ArrayList<WarehouseItem> shippedItems = shippingResult.get(0);
                ArrayList<WarehouseItem> notShippedItems = shippingResult.get(1);

                if(!shippedItems.isEmpty()) {
                %>
                <h3>The following products were successfully shipped:</h3>
                <%
                    for(WarehouseItem item : shippedItems) {
                        String productName = item.getProduct().getManufacturerName() + " " + item.getProduct().getProductType();
                        %>
                        <p><%=productName%></p>
                        <%
                    }
                }

                if(!notShippedItems.isEmpty()) {
                %>
                    <h3>The following products could not be shipped due to lack of stock; they have been ordered from the manufacturer:</h3>
                <%
                    for(WarehouseItem item : notShippedItems) {
                        String productName = item.getProduct().getManufacturerName() + " " + item.getProduct().getProductType();
                        %>
                        <p><%=productName%></p>
                        <%
                    }
                }
            }
            %>
        </div>
    </body>
</html>
