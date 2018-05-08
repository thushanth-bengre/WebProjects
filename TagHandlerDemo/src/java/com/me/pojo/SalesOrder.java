/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.pojo;

/**
 *
 * @author Bengre
 */
public class SalesOrder {
     private int salesOrderId;
    private int revisionNumber;
    private String orderdate;
    private String dueDate;
    private String shipDate;
    private String status;
    private boolean onlineOrder;
    private String salesOrderNumber;
    private String purchaseOrderNumber;
    private String accountNumber;
    private String customerId;
    private String salesPersonId;
    private String territoryId;
    private String billToAddressId;
    private String shipToAddressId;
    private String shipMethodId;
    private String creditCardId;
    private String creditCardApprovalCode;
    private String currencyRateId;
    private double subTotal;
    private double taxAmount;
    private double freight;
    private double totalDue;
    private String comments;
    private String modifiedDate;

    public SalesOrder() {
    }

    public int getSalesOrderId() {
        return salesOrderId;
    }

    public void setSalesOrderId(int salesOrderId) {
        this.salesOrderId = salesOrderId;
    }

    public int getRevisionNumber() {
        return revisionNumber;
    }

    public void setRevisionNumber(int revisionNumber) {
        this.revisionNumber = revisionNumber;
    }

    public String getOrderdate() {
        return orderdate;
    }

    public void setOrderdate(String orderdate) {
        this.orderdate = orderdate;
    }

    public String getDueDate() {
        return dueDate;
    }

    public void setDueDate(String dueDate) {
        this.dueDate = dueDate;
    }

    public String getShipDate() {
        return shipDate;
    }

    public void setShipDate(String shipDate) {
        this.shipDate = shipDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isOnlineOrder() {
        return onlineOrder;
    }

    public void setOnlineOrder(boolean onlineOrder) {
        this.onlineOrder = onlineOrder;
    }

    public String getSalesOrderNumber() {
        return salesOrderNumber;
    }

    public void setSalesOrderNumber(String salesOrderNumber) {
        this.salesOrderNumber = salesOrderNumber;
    }

    public String getPurchaseOrderNumber() {
        return purchaseOrderNumber;
    }

    public void setPurchaseOrderNumber(String purchaseOrderNumber) {
        this.purchaseOrderNumber = purchaseOrderNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getSalesPersonId() {
        return salesPersonId;
    }

    public void setSalesPersonId(String salesPersonId) {
        this.salesPersonId = salesPersonId;
    }

    public String getTerritoryId() {
        return territoryId;
    }

    public void setTerritoryId(String territoryId) {
        this.territoryId = territoryId;
    }

    public String getBillToAddressId() {
        return billToAddressId;
    }

    public void setBillToAddressId(String billToAddressId) {
        this.billToAddressId = billToAddressId;
    }

    public String getShipToAddressId() {
        return shipToAddressId;
    }

    public void setShipToAddressId(String shipToAddressId) {
        this.shipToAddressId = shipToAddressId;
    }

    public String getShipMethodId() {
        return shipMethodId;
    }

    public void setShipMethodId(String shipMethodId) {
        this.shipMethodId = shipMethodId;
    }

    public String getCreditCardId() {
        return creditCardId;
    }

    public void setCreditCardId(String creditCardId) {
        this.creditCardId = creditCardId;
    }

    public String getCreditCardApprovalCode() {
        return creditCardApprovalCode;
    }

    public void setCreditCardApprovalCode(String creditCardApprovalCode) {
        this.creditCardApprovalCode = creditCardApprovalCode;
    }

    public String getCurrencyRateId() {
        return currencyRateId;
    }

    public void setCurrencyRateId(String currencyRateId) {
        this.currencyRateId = currencyRateId;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public double getTaxAmount() {
        return taxAmount;
    }

    public void setTaxAmount(double taxAmount) {
        this.taxAmount = taxAmount;
    }

    public double getFreight() {
        return freight;
    }

    public void setFreight(double freight) {
        this.freight = freight;
    }

    public double getTotalDue() {
        return totalDue;
    }

    public void setTotalDue(double totalDue) {
        this.totalDue = totalDue;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(String modifiedDate) {
        this.modifiedDate = modifiedDate;
    }
}