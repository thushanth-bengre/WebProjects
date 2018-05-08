<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
    "http://www.w3.org/TR/html4/loose.dtd">

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Welcome to Spring Web MVC project</title>
    </head>

    <body bgcolor="#838eef">
        <form action="read.htm">
            <h1> Enter the name of CSV that you want to Load!!</h1>
            <input type="text" name="csv" />
            <input type="hidden" name="action" value="loadcsv" />
            <input type="submit" value="SUBMIT"/>
        </form>
                    
        <c:if test="${sessionScope.view eq 'csvData'}">
                <form action="read.htm">
                <table border="1">
                    <tr>
                        <th>SalesOrderID</th><th>RevisionNumber</th><th>OrderDate</th><th>DueDate</th><th>ShipDate</th><th>Status</th>
                        <th>OnlineOrderFlag</th><th>SalesOrderNumber</th><th>PurchaseOrderNumber</th><th>AccountNumber</th><th>CustomerID</th>
                        <th>SalesPersonID</th><th>TerritoryID</th><th>BillToAddressID</th><th>ShipToAddressID</th><th>ShipMethodID</th><th>CreditCardID</th>
                        <th>CreditCardApprovalCode</th><th>CurrencyRateID</th><th>SubTotal</th><th>TaxAmt</th><th>Freight</th><th>TotalDue</th>
                        <th>Comment</th><th>ModifiedDate</th>
                    </tr>
                    <c:forEach items="${salesOrderList}" var="so">
                    <tr>
                        <th><input type="text" value="${so.salesOrderId}" readonly /></th>
                        <th><input type="text" value="${so.revisionNumber}" readonly /></th>
                        <th><input type="text" value="${so.orderdate}" readonly /></th>
                        <th><input type="text" value="${so.dueDate}" readonly /></th>
                        <th><input type="text" value="${so.shipDate}" readonly /></th>
                        <th><input type="text" value="${so.status}" readonly /></th>
                        <th><input type="text" value="${so.onlineOrder}" readonly /></th>
                        <th><input type="text" value="${so.salesOrderNumber}" readonly /></th>
                        <th><input type="text" value="${so.purchaseOrderNumber}" readonly /></th>
                        <th><input type="text" value="${so.accountNumber}" readonly /></th>
                        <th><input type="text" value="${so.customerId}" readonly /></th>
                        <th><input type="text" value="${so.salesPersonId}" readonly /></th>
                        <th><input type="text" value="${so.territoryId}" readonly /></th>
                        <th><input type="text" value="${so.billToAddressId}" readonly /></th>
                        <th><input type="text" value="${so.shipToAddressId}" readonly /></th>
                        <th><input type="text" value="${so.shipMethodId}" readonly /></th>
                        <th><input type="text" value="${so.creditCardId}" readonly /></th>
                        <th><input type="text" value="${so.creditCardApprovalCode}" readonly /></th>
                        <th><input type="text" value="${so.currencyRateId}" readonly /></th>
                        <th><input type="text" value="${so.subTotal}" readonly /></th>
                        <th><input type="text" value="${so.taxAmount}" readonly /></th>
                        <th><input type="text" value="${so.freight}" readonly /></th>
                        <th><input type="text" value="${so.totalDue}" readonly /></th>
                        <th><input type="text" value="${so.comments}" readonly /></th>
                        <th><input type="text" value="${so.modifiedDate}" readonly /></th>
                    </tr>
                    </c:forEach>
                </table>                    
                   <input type="hidden" name="action" value="load" />
                    <input type="submit" value="Upload"/>
                </form>
            </c:if>
        
        <c:if test="${sessionScope.view eq 'uploaded'}">
            <form action="read.htm">
                <h1><c:out value="${sessionScope.rows}" /> Rows are inserted to the database</h1>
            </form>
        </c:if>
        
    </body>
</html>
