
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Employee;
import dao.EmployeeDao;
public class EditsaveServlet extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet EditsaveServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            int eid=Integer.parseInt(request.getParameter("eid"));
            int salary=Integer.parseInt(request.getParameter("salary"));
            String name=request.getParameter("name");
            String address=request.getParameter("address");
            String mobile=request.getParameter("mobile");
           Employee e=new Employee(eid, salary, name, address, mobile);
           EmployeeDao ed=new EmployeeDao();
           String msg=ed.UpdateEmployee(e);

           if(msg.equals("success"))
           {
           response.sendRedirect("Display");
           }
           else
           {
           out.println(msg);
           }
            out.println("</body>");
            out.println("</html>");
        } finally {
            out.close();
        }
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
