/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdbcdemo;



import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author Bengre
 */
public class JDBCDemo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws SQLException {
        try {
            //Step0: Connect to DB
            Class.forName("com.mysql.jdbc.Driver");
            
            //Step 1: Use Connect string  
            Connection con = DriverManager.getConnection("jdbc:mysql://newton.neu.edu:3306/moviedb", "student", "p@ssw0rd");
            //Step2: Pass a sql query to the DB and get the result
            Statement st=con.createStatement();
            String sql="SELECT * FROM movies";
            ResultSet rs= st.executeQuery(sql);
            
            //Step3: Print the result set using a loop
            while(rs.next()){
                System.out.println("Movie " +rs.getString("title"));
                System.out.println("Actor " +rs.getString("actor"));
            }
           
                    
                    
            
        } catch (ClassNotFoundException ex) {
            System.out.println("Exception Found" + ex.getMessage());
        }
    }
    
}
