/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.dao;

import com.me.pojo.Movies;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Bengre
 */
public class AddMovieDAO {
    public void insertMovie(Movies m){
        java.sql.Connection connection = null;
        Statement stmt = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/moviedb?" + "user=root&password=admin");
            stmt = connection.createStatement();
        } catch (ClassNotFoundException ex) {
            System.out.println("ClassNotFoundException" + ex.getMessage());
        } catch (SQLException ex) {
            System.out.println("SQLException" + ex.getMessage());
        }
        
        
        String query = "INSERT INTO movies VALUES ('" +m.getName() +"','"+m.getActor()+"','"+m.getActress()+"','"+m.getGenre()+"','"+m.getYear()+"');";
        System.out.println(query);
        try {
            int rs = stmt.executeUpdate(query);
            
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
    }
}
