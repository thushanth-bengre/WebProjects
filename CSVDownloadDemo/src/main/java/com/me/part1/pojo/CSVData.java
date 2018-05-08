package com.me.part1.pojo;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "csvdata")
public class CSVData {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rowid", unique = true, nullable = false)
	private int rowid;

	@Column(name = "salesorder")
	private String SalesOrder;
	@Column(name = "revisionnum")
	private String RevisionNumber;
	@Column(name = "orderdate")
	private String OrderDate;
	@Column(name = "duedate")
	private String DueDate;
	@Column(name = "shipdate")
	private String ShipDate;
	@Column(name = "status")
	private String Status;
	@Column(name = "onlineorderflag")
	private String OnlineOrderFlag;
	@Column(name = "salesordernum")
	private String SalesOrderNumber;
	@Column(name = "purchaseordernum")
	private String PurchaseOrderNumber;
	@Column(name = "accountnum")
	private String AccountNumber;
	@Column(name = "customerid")
	private String CustomerID;
	@Column(name = "salespersonid")
	private String SalesPersonID;
	@Column(name = "territoryid")
	private String TerritoryID;
	@Column(name = "shiptoaddressid")
	private String ShipToAddressID;
	@Column(name = "shipmethodid")
	private String ShipMethodID;
	@Column(name = "ccid")
	private String CreditCardID;
	@Column(name = "ccapprovalcode")
	private String CreditCardApprovalCode;
	@Column(name = "currencyrateid")
	private String CurrencyRateID;
	@Column(name = "subtotal")
	private String SubTotal;
	@Column(name = "taxamt")
	private String TaxAmt;
	@Column(name = "freight")
	private String Freight;
	@Column(name = "totaldue")
	private String TotalDue;
	@Column(name = "comment")
	private String Comment;
	@Column(name = "modifieddate")
	private String ModifiedDate;
	@Column(name = "billtoaddressid")
	private String BillToAddressID;

	public int getRowid() {
		return rowid;
	}

	public void setRowid(int rowid) {
		this.rowid = rowid;
	}

	public String getSalesOrder() {
		return SalesOrder;
	}

	public void setSalesOrder(String salesOrder) {
		SalesOrder = salesOrder;
	}

	public String getRevisionNumber() {
		return RevisionNumber;
	}

	public void setRevisionNumber(String revisionNumber) {
		RevisionNumber = revisionNumber;
	}

	public String getOrderDate() {
		return OrderDate;
	}

	public void setOrderDate(String orderDate) {
		OrderDate = orderDate;
	}

	public String getDueDate() {
		return DueDate;
	}

	public void setDueDate(String dueDate) {
		DueDate = dueDate;
	}

	public String getShipDate() {
		return ShipDate;
	}

	public void setShipDate(String shipDate) {
		ShipDate = shipDate;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public String getOnlineOrderFlag() {
		return OnlineOrderFlag;
	}

	public void setOnlineOrderFlag(String onlineOrderFlag) {
		OnlineOrderFlag = onlineOrderFlag;
	}

	public String getSalesOrderNumber() {
		return SalesOrderNumber;
	}

	public void setSalesOrderNumber(String salesOrderNumber) {
		SalesOrderNumber = salesOrderNumber;
	}

	public String getPurchaseOrderNumber() {
		return PurchaseOrderNumber;
	}

	public void setPurchaseOrderNumber(String purchaseOrderNumber) {
		PurchaseOrderNumber = purchaseOrderNumber;
	}

	public String getAccountNumber() {
		return AccountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		AccountNumber = accountNumber;
	}

	public String getCustomerID() {
		return CustomerID;
	}

	public void setCustomerID(String customerID) {
		CustomerID = customerID;
	}

	public String getSalesPersonID() {
		return SalesPersonID;
	}

	public void setSalesPersonID(String salesPersonID) {
		SalesPersonID = salesPersonID;
	}

	public String getTerritoryID() {
		return TerritoryID;
	}

	public void setTerritoryID(String territoryID) {
		TerritoryID = territoryID;
	}

	public String getShipToAddressID() {
		return ShipToAddressID;
	}

	public void setShipToAddressID(String shipToAddressID) {
		ShipToAddressID = shipToAddressID;
	}

	public String getShipMethodID() {
		return ShipMethodID;
	}

	public void setShipMethodID(String shipMethodID) {
		ShipMethodID = shipMethodID;
	}

	public String getCreditCardID() {
		return CreditCardID;
	}

	public void setCreditCardID(String creditCardID) {
		CreditCardID = creditCardID;
	}

	public String getCreditCardApprovalCode() {
		return CreditCardApprovalCode;
	}

	public void setCreditCardApprovalCode(String creditCardApprovalCode) {
		CreditCardApprovalCode = creditCardApprovalCode;
	}

	public String getCurrencyRateID() {
		return CurrencyRateID;
	}

	public void setCurrencyRateID(String currencyRateID) {
		CurrencyRateID = currencyRateID;
	}

	public String getSubTotal() {
		return SubTotal;
	}

	public void setSubTotal(String subTotal) {
		SubTotal = subTotal;
	}

	public String getTaxAmt() {
		return TaxAmt;
	}

	public void setTaxAmt(String taxAmt) {
		TaxAmt = taxAmt;
	}

	public String getFreight() {
		return Freight;
	}

	public void setFreight(String freight) {
		Freight = freight;
	}

	public String getTotalDue() {
		return TotalDue;
	}

	public void setTotalDue(String totalDue) {
		TotalDue = totalDue;
	}

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public String getModifiedDate() {
		return ModifiedDate;
	}

	public void setModifiedDate(String modifiedDate) {
		ModifiedDate = modifiedDate;
	}

	public String getBillToAddressID() {
		return BillToAddressID;
	}

	public void setBillToAddressID(String billToAddressID) {
		BillToAddressID = billToAddressID;
	}

}
