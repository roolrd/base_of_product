<%@ page import="java.util.List" %>
<%@ page import="app.entities.Product" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 12.08.2019
  Time: 7:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List products</title>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
</head>
<body class="w3-light-grey">
<div class="w3-container w3-blue-grey w3-opacity w3-right-align">
    <h2>List products</h2>
</div>
<div class="w3-container w3-padding">

<table border="1">
    <tr>
        <th>Id:</th>
        <th>Name:</th>
        <!--th>CategoryId:</th-->
        <th>Date of produce:</th>
        <th>Date of expired:</th>
        <th>Amount:</th>
        <th>Price:</th>
        <th>Provider:</th>
        <th>Phone number provider:</th>
        <th>Date of delivery:</th>
        <th>Number of warehouse:</th>
        <th>Description:</th>
        <th>Notes:</th>
        <th colspan="2">What to DO:</th>

    </tr>
    <%
        for (Product product : (List<Product>)request.getAttribute("list of products")) {
            %>
    <tr>
        <td><%=product.getId()%></td>
        <td><%=product.getName()%></td>
        <td><%=product.getDateOfProduce()%></td>
        <td><%=product.getDateOfExpired()%></td>
        <td><%=product.getAmount()%></td>
        <td><%=product.getPrice()%></td>
        <td><%=product.getProvider()%></td>
        <td><%=product.getnPhoneProvider()%></td>
        <td><%=product.getDateOfDelivery()%></td>
        <td><%=product.getNoWarehouse()%></td>
        <td><%=product.getDescription()%></td>
        <td><%=product.getNotes()%></td>
        <td>
            <a class="w3-btn w3-hover-gray w3-round-large" href="edit?id=<%=product.getId()%>"> Edit</a>
        </td>
        <td>
            <a class="w3-btn w3-hover-red w3-round-large" href="delete?id=<%=product.getId()%>"> Delete</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
<br/>
</div>
    <div class="w3-container w3-grey w3-opacity w3-right-align w3-padding">
<input type="button" class="w3-btn w3-round-large" onclick='location.href="/"' value="Main page"/>
</div>
</body>
</html>
