/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import com.me.pojo.SalesOrder;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Bengre
 */
public class DatabaseDAO {
    public int save(List<SalesOrder> list){
        java.sql.Connection connection = null;
        PreparedStatement prepStat = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/salesorderdb?" + "user=root&password=admin");            
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        
        
        
        
        try {
            String query = "INSERT INTO salesorder VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?);";
            prepStat = connection.prepareStatement(query);
            for(SalesOrder so:list){
                prepStat.setInt(1, so.getSalesOrderId());
                prepStat.setInt(2, so.getRevisionNumber());
                prepStat.setString(3, so.getOrderdate());
                prepStat.setString(4, so.getDueDate());
                prepStat.setString(5, so.getShipDate());
                prepStat.setString(6, so.getStatus());
                prepStat.setBoolean(7, so.isOnlineOrder());
                prepStat.setString(8, so.getSalesOrderNumber());
                prepStat.setString(9, so.getPurchaseOrderNumber());
                prepStat.setString(10, so.getAccountNumber());
                prepStat.setString(11, so.getCustomerId());
                prepStat.setString(12, so.getSalesPersonId());
                prepStat.setString(13, so.getTerritoryId());
                prepStat.setString(14, so.getBillToAddressId());
                prepStat.setString(15, so.getShipToAddressId());
                prepStat.setString(16, so.getShipMethodId());
                prepStat.setString(17, so.getCreditCardId());
                prepStat.setString(18, so.getCreditCardApprovalCode());
                prepStat.setString(19, so.getCurrencyRateId());
                prepStat.setFloat(20, (float) so.getSubTotal());
                prepStat.setFloat(21, (float) so.getTaxAmount());
                prepStat.setFloat(22, (float) so.getFreight());
                prepStat.setFloat(23, (float) so.getTotalDue());
                prepStat.setString(24, so.getComments());
                prepStat.setString(25, so.getModifiedDate());
                prepStat.addBatch();             
            }          
            int[] rs = prepStat.executeBatch();
            int sum=0;
            for(int i=0;i<rs.length;i++){
                sum= sum +rs[i];
            }
            return sum;
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex);
        } finally {
            try {
                if (prepStat != null) {
                    prepStat.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                System.out.println("SQLException" + ex.getMessage());
            }
        }
        return 0;
    }
}
