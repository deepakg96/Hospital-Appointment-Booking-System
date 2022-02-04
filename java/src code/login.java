/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

/**
 *
 * @author Akshay
 */
public class login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        boolean value=false;
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter pw = response.getWriter()){
            String name = request.getParameter("uname");
            String pass = request.getParameter("passwd");
            Dbconnect db = new Dbconnect();
            Connection con = db.getCon();
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("Select * from userdetails");
            while(rs.next()){
                String uname = rs.getString("name");
                String pwd = rs.getString("Passwd");
                if(name.equals(uname) && pass.equals(pwd)){
                    pw.println("<h1 style='text-align:center;'>Login Successful!</h1>");
                    pw.println("<br/>");
                    pw.println("<a href='Homepage.html'><h1>Click to go homepage</h1></a>");
                    value=true;
                    break;
                }

                
            }
            if(value==false){
               pw.println("Invalid username or passwd");
               pw.println("<br/>");
               pw.println("<a href='index.html'>Re-enter</a>");
            
            
            }
        }
        catch(SQLException e){
                System.out.println("Invalid Query!");
            }
    }

}
