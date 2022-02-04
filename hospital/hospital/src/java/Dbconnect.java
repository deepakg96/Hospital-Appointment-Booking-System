/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Akshay
 */
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class Dbconnect {
    Connection con;
    public Connection getCon(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital","root","");

        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(Dbconnect.class.getName()).log(Level.SEVERE, null, ex);
        }
            return con;
    }

    
     
    
}
