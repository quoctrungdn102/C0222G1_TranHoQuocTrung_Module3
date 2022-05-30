<%--
  Created by IntelliJ IDEA.
  User: ADMIN
  Date: 5/26/2022
  Time: 3:00 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
  <form action="Product" method="post">
    <div>
      <h1> Product Discount Calculator</h1>
      <label>Product Description:</label>
      <input type="text" name="Description" placeholder="Description" required><br>
      <label> List Price: </label>
      <input style="margin-left: 65px" type="number" name="price" placeholder="price" value="0" required ><br>
      <label> Discount Percent: </label>
      <input style="margin-left: 15px" type="number" name="DiscountPercent" required><br>
      <input type="submit" id="submit" value="submit">
      <input type="reset" id ="reset" value="reset">
    </div>
  </form>

  </body>
</html>
