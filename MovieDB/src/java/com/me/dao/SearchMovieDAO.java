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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bengre
 */
public class SearchMovieDAO {
    public List<Movies> getMovieList(String key, String by){
        List<Movies> list = new ArrayList<>();
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
        
        
        String query = getQuery(key, by);
        System.out.println(query);
        try {
            ResultSet rs = stmt.executeQuery(query);            
            while(rs.next()){
                Movies m = new Movies();
                m.setName(rs.getString("title"));
                m.setActor(rs.getString("actor"));
                m.setActress(rs.getString("actress"));
                m.setGenre(rs.getString("genre"));
                m.setYear(rs.getInt("year"));
                list.add(m);
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
        return list;
    }
    
    private String getQuery(String key, String by){
        if(by.equals("name")){
            return "SELECT * FROM movies WHERE title LIKE '%"+ key +"%' ";
        }else if(by.equals("actor")){
            return "SELECT * FROM movies WHERE actor LIKE '%"+ key +"%' ";
        }else if(by.equals("actress")){
            return "SELECT * FROM movies WHERE actress LIKE '%"+ key +"%' ";
        }else if(by.equals("genre")){
            return "SELECT * FROM movies WHERE genre LIKE '%"+ key +"%' ";    
        } else {
            return "SELECT * FROM movies WHERE year LIKE '%"+ key +"%' ";
        }
        
        
    }
    
}
