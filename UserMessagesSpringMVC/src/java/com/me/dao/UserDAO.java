/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import com.me.pojo.Message;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bengre
 */
public class UserDAO {
    public ArrayList<Message> getMessages() {
        java.sql.Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://newton.neu.edu:3306/usersdb", "student", "p@ssw0rd");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        } 
        String query = "SELECT * FROM messages";
        ArrayList<Message> msgList = new ArrayList<Message>();
        try {
            ResultSet rs = stmt.executeQuery(query);
     
            while(rs.next()){
                Message msg = new Message();
                msg.setMessageId(rs.getInt("messageId"));
                msg.setReceiver(rs.getString("userName"));
                msg.setSender(rs.getString("fromUser"));
                msg.setMessage(rs.getString("message"));
                msg.setMessageDate(rs.getString("messageDate"));
                msgList.add(msg);
            }
        } catch (SQLException ex) {
               System.out.println(ex);
        }finally {
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
        
        return msgList;
    }
}
