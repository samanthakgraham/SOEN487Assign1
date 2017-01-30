<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SOEN487 Winter 2017 Assignment 1 Exercise 4: Supply Chain Management Application</title>

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
                    <input type="number" name="dvd-qty" placeholder="Quantity" />
                </div>
                <div class="form-group">
                    <input type="checkbox" name="product[]" value="video camera" /> Brand3 Video Camera
                    <input type="number" name="video-qty" placeholder="Quantity" />
                </div>        
                <div class="form-group">
                    <input type="submit" value="Place Order" class="btn btn-success" />
                </div>
            </form>
        </div>

    </body>
</html>
