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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Akshay
 */
public class appt extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
     
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String date = request.getParameter("dmy");
            String time = request.getParameter("time");
            String dep = request.getParameter("dept");
            String des = request.getParameter("desc");
            //String sub = request.getParameter("Register");
            Dbconnect db = new Dbconnect();
            Connection con = db.getCon();
            Statement st = con.createStatement();
            //verify(request,response);
            //verify(request,response);
            st.executeUpdate("insert into appointment values ('"+name+"','"+date+"','"+time+"','"+dep+"','"+des+"');");
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet appt</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Booking Successful!");
            out.println("<table border='1' width = '100%'>");
            out.println("<tr>");
            out.println("<th>Name</th>"+"<th>Date</th>"+"<th>Time</th>"+"<th>Department</th>"+"<th>Description</th>");
            out.println("</tr><br/>");
            out.println("<tr>");
            out.println("<td>"+name+"</td>");
            out.println("<td>"+date+"</td>");
            out.println("<td>"+time+"</td>");
            out.println("<td>"+dep+"</td>");
            out.println("<td>"+des+"</td>");
            out.println("</tr>");
            out.println("</table>");
            out.println("<br/><a href='Homepage.html'><b>Return</b></a>");
            out.println("</body>");
            out.println("</html>");
           
        }
     
        catch(SQLException e){
            System.out.println("invalid query");

        }
        
    }
    protected void verify(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, SQLException {
        boolean check = false;
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String date = request.getParameter("dmy");
            String time = request.getParameter("time");
            String dep = request.getParameter("dept");
            String des = request.getParameter("desc");
            //String sub = request.getParameter("Register");
            Dbconnect db = new Dbconnect();
            Connection con = db.getCon();
            Statement st = con.createStatement();
            ResultSet rs;
            rs  = st.executeQuery("select * from appointment;");
            while(rs.next()){
                if(name.equals(rs.getString("Name")) && date.equals(rs.getString("Date"))){
                   
                   check = true;
                   break;
                
            }
            
        
       
            }
            if(check == true){
                out.println("<h1>Slot Already Booked!</h1>");
                   out.println("<a href='Appointment.html'>Re-enter</a>");
            }
        
        
    }
        
}

    /**
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     * @throws SQLException
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
           // verify(request, response);
    
        processRequest(request, response);
        
    }
}
