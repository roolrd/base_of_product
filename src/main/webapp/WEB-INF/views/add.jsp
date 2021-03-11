<%@ page import="app.entities.Category" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12.08.2019
  Time: 7:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add product</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <meta charset="UTF-8">
</head>
<body class="w3-light-grey">
<!-- header -->
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h1>The base of product nomenclature</h1>
</div>
<div class="w3-container w3-padding">
        <%
                if (request.getAttribute("productName") != null) {
                    out.println("<div class=\"w3-panel w3-green w3-display-container w3-card-4 w3-round\">\n" +
                            "   <span onclick=\"this.parentElement.style.display='none'\"\n" +
                            "   class=\"w3-button w3-margin-right w3-display-right w3-round-large w3-hover-green w3-border w3-border-green w3-hover-border-grey\">×</span>\n" +
                            "   <h5>Product '" + request.getAttribute("productName") + "' added!</h5>\n" +
                            "</div>");
                }
            %>
    <div class="w3-card-4">
<div class="w3-container w3-center w3-green">
    <h2>Add product</h2>
</div>

<form method="post" class="w3-selection w3-light-grey w3-padding">
    <!--label>ID:
        <input type="number" name="idJ"><br />
    </label-->

    <label>Name:
    <input type="text" name="nameJ" required="this field must be filled out"><br />
    </label>


    <label>CategoryID:
        <input type="text" name="categoryId" placeholder="must be a number"><br />
    </label>


        <label>Date of produce:
        <input type="date" name="dateOfProduceJ" placeholder="DD.MM.YYYY" required><br />
    </label>

    <label>Date of expired:
        <input type="date" name="dateOfExpiredJ" required placeholder="DD.MM.YYYY"><br />
    </label>

    <label>Amount:
        <input type="number" name="amountJ" required><br />
    </label>

    <label>Price:
        <input type="number" name="priceJ" step="any" required placeholder="0.00"><br />
    </label>

    <label>Provider:
        <input type="text" name="providerJ" required><br />
    </label>

    <label>Phone number provider:
        <input type="tel" name="nPhoneProviderJ"><br />
    </label>

    <label>Date of delivery:
        <input type="date" name="dateOfDeliveryJ" required placeholder="DD.MM.YYYY"><br />
    </label>

    <label>Number of warehouse:
        <input type="text" name="noWarehouseJ" required><br />
    </label>

    <label>Description:
        <input type="text" name="descriptionJ"><br />
    </label>

    <label>Notes:
        <input type="text" name="notesJ"><br />
    </label>

    <hr>
     <button type="submit"> Submit </button>
    <button type="reset"> Clear </button>


<!--input type="button" onclick='location.href="http://localhost:8080/"' value="Main page"/-->

</form>

    </div>
</div>

<div>
  <button onclick="location.href='/base-of-product'">Back to main</button>
    <!--<button onclick="location.href='../..'">Back to main</button>-->
</div>

</body>
</html>
