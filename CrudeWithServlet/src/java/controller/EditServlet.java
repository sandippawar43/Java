

package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employee;
import dao.EmployeeDao;

public class EditServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditServlet</title>");            
            out.println("</head>");
            out.println("<body>");
int empid=Integer.parseInt(request.getParameter("eid"));
       EmployeeDao ed=new EmployeeDao();
       Employee e=ed.GetAllEmployeeByID(empid);
       
out.println("<form action='editsave' method='post'><table>");
out.println("<tr><td>Employee ID</td><td><input type='text' name='eid' value='"+e.getId()+"'></td></tr>");
out.println("<tr><td>Employee Name</td><td><input type='text' name='name' value='"+e.getName()+"'></td></tr>");
out.println("<tr><td>Address</td><td><input type='text' name='address' value='"+e.getAddress()+"'></td></tr>");
out.println("<tr><td>Mobile</td><td><input type='text' name='mobile' value='"+e.getMobile()+"'></td></tr>");
out.println("<tr><td>Salary</td><td><input type='text' name='salary' value='"+e.getSalary()+"'></td></tr>");
out.println("<tr><td><input type='submit' value='Submit'></td></tr>");

out.println("</table></form>");
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
