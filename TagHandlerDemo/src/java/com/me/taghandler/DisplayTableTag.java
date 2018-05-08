/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.taghandler;

import com.me.pojo.SalesOrder;
import java.io.IOException;
import java.io.StringWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

/**
 *
 * @author Bengre
 */
public class DisplayTableTag extends SimpleTagSupport{
    
    
    
    @Override
    public void doTag() throws JspException, IOException{
        JspWriter out = getJspContext().getOut();
        java.sql.Connection connection = null;
        Statement stmt = null;
        String csvName = null;
        List<SalesOrder> salesOrderList = new ArrayList<>();
        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            connection = DriverManager.getConnection("jdbc:relique:csv:" + "C:\\Users\\thush\\Documents\\NetBeansProjects\\HW5Part6\\csv");
            stmt = connection.createStatement();
            StringWriter sw = new StringWriter();
            getJspBody().invoke(sw);
            csvName = sw.toString();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        String query = "SELECT * FROM " + csvName;
        System.out.println(query);
        try {
            ResultSet rs = stmt.executeQuery(query);
            while(rs.next() && rs.getInt("SalesOrderID") > 0){                
                SalesOrder so = new SalesOrder();
                so.setSalesOrderId(rs.getInt("SalesOrderID"));
                so.setRevisionNumber(rs.getInt("RevisionNumber"));
                so.setOrderdate(rs.getString("OrderDate"));
                so.setDueDate(rs.getString("DueDate"));
                so.setShipDate(rs.getString("ShipDate"));
                so.setStatus(rs.getString("Status"));
                int k=rs.getInt("OnlineOrderFlag");
                if(k == 0) so.setOnlineOrder(false);
                else so.setOnlineOrder(true);                
                so.setSalesOrderNumber(rs.getString("SalesOrderNumber"));
                so.setPurchaseOrderNumber(rs.getString("PurchaseOrderNumber"));
                so.setAccountNumber(rs.getString("AccountNumber"));
                so.setCustomerId(rs.getString("CustomerID"));
                so.setSalesPersonId(rs.getString("SalesPersonID"));
                so.setTerritoryId(rs.getString("TerritoryID"));
                so.setBillToAddressId(rs.getString("BillToAddressID"));
                so.setShipToAddressId(rs.getString("ShipToAddressID"));
                so.setShipMethodId(rs.getString("ShipMethodID"));
                so.setCreditCardId(rs.getString("CreditCardID"));
                so.setCreditCardApprovalCode(rs.getString("CreditCardApprovalCode"));
                so.setCurrencyRateId(rs.getString("CurrencyRateID"));
                so.setSubTotal(rs.getFloat("SubTotal"));
                so.setTaxAmount(rs.getFloat("TaxAmt"));
                so.setFreight(rs.getFloat("Freight"));
                so.setTotalDue(rs.getFloat("TotalDue"));
                so.setComments(rs.getString("Comment"));
                so.setModifiedDate(rs.getString("ModifiedDate"));                
                salesOrderList.add(so);
            }
            getJspContext().setAttribute("salesOrderList", salesOrderList,PageContext.SESSION_SCOPE);
            
            
            out.print("<table border='1'>");
            out.print("<tr>");
            out.print("<th>SalesOrderID</th><th>RevisionNumber</th><th>OrderDate</th><th>DueDate</th><th>ShipDate</th><th>Status</th>");
            out.print("<th>OnlineOrderFlag</th><th>SalesOrderNumber</th><th>PurchaseOrderNumber</th><th>AccountNumber</th><th>CustomerID</th>");
            out.print("<th>SalesPersonID</th><th>TerritoryID</th><th>BillToAddressID</th><th>ShipToAddressID</th><th>ShipMethodID</th><th>CreditCardID</th>");
            out.print("<th>CreditCardApprovalCode</th><th>CurrencyRateID</th><th>SubTotal</th><th>TaxAmt</th><th>Freight</th><th>TotalDue</th>");
            out.print("<th>Comment</th><th>ModifiedDate</th>");
            out.print("</tr>");
            for(SalesOrder so:salesOrderList){
            out.print("</tr>");
            out.print("<th><input type='text' value=" + so.getSalesOrderId() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getRevisionNumber() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getOrderdate() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getDueDate() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getShipDate() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getStatus() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.isOnlineOrder() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getSalesOrderNumber() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getPurchaseOrderNumber() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getAccountNumber() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getCustomerId() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getSalesPersonId() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getTerritoryId() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getBillToAddressId() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getShipToAddressId() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getShipMethodId() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getCreditCardId() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getCreditCardApprovalCode() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getCurrencyRateId() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getSubTotal() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getTaxAmount() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getFreight() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getTotalDue() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getComments() + " readonly /></th>");
            out.print("<th><input type='text' value=" + so.getModifiedDate() + " readonly /></th>");
            out.print("</tr>");
            }
            out.print("</table>");
            
            } catch (SQLException ex) {
            System.out.println("SQl Exception: " + ex);
        } finally {
            try {
                if (stmt != null) {
                    stmt.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
            }
        }
    }
}
