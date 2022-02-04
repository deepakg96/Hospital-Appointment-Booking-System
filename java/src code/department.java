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
public class department extends HttpServlet {

    

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
            // TODO output your page here. You may use following sample code. 
            String dep = request.getParameter("dept");
            Dbconnect db = new Dbconnect();
            Connection con = db.getCon();
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("Select * from department where Dept_name='"+dep+"';");
            
            out.println("<html>");
            out.println("<body>");
            out.println("<table border='1' width='100%' padding='12px'>");
            out.println("<tr>");
            out.println("<th>Dept_no</th>"+"<th>Department</th>"+"<th>Doctor's Name</th>");
            out.println("</tr><br/>");
            while(rs.next()){
                out.println("<tr>");
                out.println("<td>"+rs.getString("Dept_no")+"</td>");
                out.println("<td>"+rs.getString("Dept_name")+"</td>");
                out.println("<td>"+rs.getString("Doctor name")+"</td>");
                out.println("</tr>");
                
                }
            out.println("</table>");
            out.println("<br/><a href='Homepage.html'><b>Return to homepage</b></a>");
            out.println("</body>");
            out.println("</html>");
            
            
        }
        catch(SQLException e){
                System.out.println("Invalid Query!");
            }
    
        }
}



