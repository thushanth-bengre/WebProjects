/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import com.me.pojo.Books;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bengre
 */
public class BooksDAO {
    public void insertBooks(Books b){
        java.sql.Connection connection = null;
        PreparedStatement prepStat = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdb?" + "user=root&password=admin");            
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        
        
        
        
        try {
            String query = "INSERT INTO books VALUES (?,?,?,?);";
            prepStat = connection.prepareStatement(query);
            prepStat.setString(1, b.getIsbn());
            prepStat.setString(2, b.getName());
            prepStat.setString(3, b.getAuthor());
            prepStat.setFloat(4, (float) b.getPrice());            
            int rs = prepStat.executeUpdate();         
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
    }
    
    public List<Books> getMovieList(){
        List<Books> list = new ArrayList<>();
        java.sql.Connection connection = null;
        PreparedStatement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/booksdb?" + "user=root&password=admin");            
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        
        
        try {
            String query = "SELECT * FROM books";
            stmt = connection.prepareStatement(query);            
            ResultSet rs = stmt.executeQuery();            
            while(rs.next()){
                Books b = new Books();
                b.setName(rs.getString("title"));
                b.setAuthor(rs.getString("authors"));
                b.setIsbn(rs.getString("isbn"));
                b.setPrice(Double.valueOf(rs.getString("price")));
                list.add(b);
            }
            return list;
            
        } catch (SQLException ex) {
            System.out.println("SQL Exception: " + ex);
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
