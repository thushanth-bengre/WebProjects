<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CSV Data Loaded</title>
</head>
<body>
	<c:set var="contextPath" value="${pageContext.request.contextPath}" />
	<c:set var="pageCounterStart" value="${pageContext.request.contextPath}" />
	<c:if test="${sessionScope.ROWS_TO_DISPLAY != null}">
		<c:set var="ROWS_TO_DISPLAY" value="${sessionScope.ROWS_TO_DISPLAY}" />
	</c:if>
	<c:if test="${sessionScope.rowCount != null}">
		<c:set var="numberOfRows" value="${sessionScope.rowCount}" />
		<c:choose>
		<c:when test="${param['page'] == null}"><c:set var="pageVal" value="1" /></c:when>
		<c:when test="${param['page'] != null}"><c:set var="pageVal" value="${param['page']}" /></c:when>
		</c:choose>
		<c:if test="${pageVal > 1}"><a href="${contextPath}/loadData?page=${pageVal-5 < 1 ? 1 : pageVal-5}"> << </a>&nbsp;</c:if>
		
		<c:forEach begin="${pageVal}" end="${pageVal + 4}" var="val" varStatus="loop">
			<c:set var="startVal" value="${ROWS_TO_DISPLAY * (loop.index - 1)}"></c:set>
			<a href="${contextPath}/loadData?page=${loop.index}&start=${startVal}">${loop.index}</a>&nbsp;&nbsp;
			<c:set var="nextVal" value="${ROWS_TO_DISPLAY * (loop.index)}"></c:set>
			<c:set var="nextPage" value="${loop.index + 1}"></c:set> 
		</c:forEach>
		<a href="${contextPath}/loadData?page=${nextPage}&start=${nextVal}"> >></a>
	</c:if>

	<table>
		<tr>
			<th>SalesOrderID</th>
			<th>RevisionNumber</th>
			<th>OrderDate</th>
			<th>DueDate</th>
			<th>ShipDate</th>
			<th>Status</th>
			<th>OnlineOrderFlag</th>
			<th>SalesOrderNumber</th>
			<th>PurchaseOrderNumber</th>
			<th>AccountNumber</th>
			<th>CustomerID</th>
			<th>SalesPersonID</th>
			<th>TerritoryID</th>
			<th>BillToAddressID</th>
			<th>ShipToAddressID</th>
			<th>ShipMethodID</th>
			<th>CreditCardID</th>
			<th>CreditCardApprovalCode</th>
			<th>CurrencyRateID</th>
			<th>SubTotal</th>
			<th>TaxAmt</th>
			<th>Freight</th>
			<th>TotalDue</th>
			<th>Comment</th>
			<th>ModifiedDate</th>
		</tr>
		<c:forEach items="${success}" var="dataText" varStatus="loop">
			<tr>
				<td><input type="text" name="SalesOrder${loop.index}"
					value="${dataText.getSalesOrder()}" /></td>
				<td><input type="text" name="RevisionNumber${loop.index}"
					value="${dataText.getRevisionNumber()}" /></td>
				<td><input type="text" name="OrderDate${loop.index}"
					value="${dataText.getOrderDate()}" /></td>
				<td><input type="text" name="DueDate${loop.index}"
					value="${dataText.getDueDate()}" /></td>
				<td><input type="text" name="ShipDate${loop.index}"
					value="${dataText.getShipDate()}" /></td>
				<td><input type="text" name="Status${loop.index}"
					value="${dataText.getStatus()}" /></td>
				<td><input type="text" name="OnlineOrderFlag${loop.index}"
					value="${dataText.getOnlineOrderFlag()}" /></td>
				<td><input type="text" name="SalesOrderNumber${loop.index}"
					value="${dataText.getSalesOrderNumber()}" /></td>
				<td><input type="text" name="PurchaseOrderNumber${loop.index}"
					value="${dataText.getPurchaseOrderNumber()}" /></td>
				<td><input type="text" name="AccountNumber${loop.index}"
					value="${dataText.getAccountNumber()}" /></td>
				<td><input type="text" name="CustomerId${loop.index}"
					value="${dataText.getCustomerID()}" /></td>
				<td><input type="text" name="SalesPersonId${loop.index}"
					value="${dataText.getSalesPersonID()}" /></td>
				<td><input type="text" name="TerritoryId${loop.index}"
					value="${dataText.getTerritoryID()}" /></td>
				<td><input type="text" name="BillToAddress${loop.index}"
					value="${dataText.getBillToAddressID()}" /></td>
				<td><input type="text" name="ShipToAddress${loop.index}"
					value="${dataText.getShipToAddressID()}" /></td>
				<td><input type="text" name="ShipMethod${loop.index}"
					value="${dataText.getShipMethodID()}" /></td>
				<td><input type="text" name="CreditCardId${loop.index}"
					value="${dataText.getCreditCardID()}" /></td>
				<td><input type="text" name="CreditCardApproval${loop.index}"
					value="${dataText.getCreditCardApprovalCode()}" /></td>
				<td><input type="text" name="CurrencyRate${loop.index}"
					value="${dataText.getCurrencyRateID()}" /></td>
				<td><input type="text" name="SubTotal${loop.index}"
					value="${dataText.getSubTotal()}" /></td>
				<td><input type="text" name="TaxAmt${loop.index}"
					value="${dataText.getTaxAmt()}" /></td>
				<td><input type="text" name="Freight${loop.index}"
					value="${dataText.getFreight()}" /></td>
				<td><input type="text" name="TotalDue${loop.index}"
					value="${dataText.getTotalDue()}" /></td>
				<td><input type="text" name="Comment${loop.index}"
					value="${dataText.getComment()}" /></td>
				<td><input type="text" name="ModifiedDate${loop.index}"
					value="${dataText.getModifiedDate()}" /></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>