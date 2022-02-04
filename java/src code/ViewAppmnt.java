/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
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
public class ViewAppmnt extends HttpServlet {

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
            /* TODO output your page here. You may use following sample code.*/ 
            /*String name = request.getParameter("name");
            String dt = request.getParameter("dmy");
            String tm = request.getParameter("time");
            String ds = request.getParameter("descriptn");
           */Dbconnect db = new Dbconnect();
            Connection con = db.getCon();
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("Select * from appointment;");
            
            out.println("<html>");
            out.println("<body>");
            out.println("<table border='1' width='100%' padding='12px'>");
            out.println("<tr>");
            out.println("<th>Name</th>"+"<th>Date</th>"+"<th>Time Slot</th>"+"<th>Description</th>");
            out.println("</tr><br/>");
            while(rs.next()){
                out.println("<tr>");
                out.println("<td>"+rs.getString("Name")+"</td>");
                out.println("<td>"+rs.getString("Date")+"</td>");
                out.println("<td>"+rs.getString("Time Slot")+"</td>");
                out.println("<td>"+rs.getString("Description")+"</td>");
                out.println("</tr>");
                
                }
            out.println("</table>");
            out.println("<br/><a href='index.html'><b>LOGOUT</b></a>");
            out.println("</body>");
            out.println("</html>");
            
            
        }
        catch(SQLException e){
                System.out.println("Invalid Query!");
            }
    
    }

}
