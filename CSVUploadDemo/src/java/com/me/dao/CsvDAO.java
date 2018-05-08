/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import com.me.pojo.SalesOrder;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bengre
 */
public class CsvDAO {
    public List<SalesOrder> getSalesOrder(String csvName){
        List<SalesOrder> list = new ArrayList<>();
        java.sql.Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("org.relique.jdbc.csv.CsvDriver");
            connection = DriverManager.getConnection("jdbc:relique:csv:" + "C:\\Users\\thush\\Documents\\NetBeansProjects\\HW5Part6\\csv");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        
        String query = "SELECT * FROM " + csvName;
        
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
                list.add(so);                
            }
            System.out.println(list.size());
            return list;
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
    return null;
}
}
