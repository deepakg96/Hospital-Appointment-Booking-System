/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Akshay
 */
public class bloodbank extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            String name = request.getParameter("name");
            String dt = request.getParameter("ymd");
            String pno = request.getParameter("phno");
            String bgroup = request.getParameter("bg");
            Dbconnect db = new Dbconnect();
            Connection con = db.getCon();
            Statement st = con.createStatement();
            
            st.executeUpdate("Insert into bloodbank values ('"+name+"','"+dt+"','"+pno+"','"+bgroup+"');");
            out.println("<html>");
            out.println("<body>");
            out.println("<h1 style='text-align:center;'>Booking Successful!</h1>");
            out.println("<br/>");
            
            out.println("<h2>Details</h2><br/>");
            out.println("<table border='1' width='100%' padding='12px'");
            out.println("<tr>");
            out.println("<th>NAME</th>"+"<th>DATE</th>"+"<th>PHONE NUMBER</th>"+"<th>BLOOD GROUP</th>");
            out.println("</tr><br/>");
            out.println("<tr>");
            out.println("<td>"+name+"</td>");
            out.println("<td>"+dt+"</td>");
            out.println("<td>"+pno+"</td>");
            out.println("<td>"+bgroup+"</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<a href='Homepage.html'><h1>Click to go homepage</h2></a>");
            out.println("</body>");
            out.println("</html>");
            
        }
        catch(SQLException e){
            System.out.println("Invalid query");
        }
    }

}
