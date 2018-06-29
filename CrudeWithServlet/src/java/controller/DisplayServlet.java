

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import model.Employee;
import dao.EmployeeDao;
public class DisplayServlet extends HttpServlet {

   
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet DisplayServlet</title>");            
            out.println("</head>");
            out.println("<body>");
           EmployeeDao ed=new EmployeeDao();
           List<Employee>lst=ed.GetAllEmployees();
           out.println("<table border='1'><thead><tr><th>Employee ID</th><th>Name</th><th>Address</th><th>Mobile</th><th>Salary</th><th>Action</th><th>Action</th></tr></thead><tbody>");

           for(Employee e:lst)
           {
           out.println("<tr><td>"+e.getId()+"</td><td>"+e.getName()+"</td><td>"+e.getAddress()+"</td><td>"+e.getMobile()+"</td><td>"+e.getSalary()+"</td><td><a href='Edit?eid="+e.getId()+"'>Edit</a> &nbsp;&nbsp; <a href='Delete?eid="+e.getId()+"'>Delete</a></td></tr>");
           }
           out.println("</tbody></table>");
            out.println("</body>");
            out.println("</html>");
        } catch(Exception ex){
out.println(ex.getMessage());
        }
    }

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
