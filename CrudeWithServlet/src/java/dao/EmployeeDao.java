
package dao;
import model.Employee;
import java.sql.*;
import java.util.*;

public class EmployeeDao {
    Connection con;
    Statement st;
    ResultSet rs;
    public EmployeeDao(){
    try{
        Class.forName("oracle.jdbc.OracleDriver");
        con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
    }
    catch(Exception ex){}
    }
    
    public String AddEmployee(Employee e)
    {
        int cnt=0;
    try{
    st=con.createStatement();
    cnt=st.executeUpdate("insert into employee values("+e.getId()+",'"+e.getName()+"','"+e.getAddress()+"','"+e.getMobile()+"',"+e.getSalary()+")");
    }
    catch(Exception ex)
    {
    return ex.getMessage();
    }
    return "Record inserted Successfully";
    }

     public String UpdateEmployee(Employee e)
    {
        int cnt=0;
    try{
    st=con.createStatement();
    cnt=st.executeUpdate("update employee set name='"+e.getName()+"',address='"+e.getAddress()+"',mobileno='"+e.getMobile()+"',salary="+e.getSalary()+" where employeid="+e.getId());
    }
    catch(Exception ex)
    {
    return ex.getMessage();
    }
    return "success";
    }
     
     
      public String DeleteEmployee(int id)
    {
        int cnt=0;
    try{
    st=con.createStatement();
    cnt=st.executeUpdate("delete from employee  where employeid="+id);
    }
    catch(Exception ex)
    {
    return ex.getMessage();
    }
    return "success";
    }
    
    public List<Employee> GetAllEmployees(){
    List<Employee>lst=new ArrayList<Employee>();
    try{
    st=con.createStatement();
    rs=st.executeQuery("select * from employee");
    while(rs.next())
    {
    Employee e=new Employee(rs.getInt("Employeid"), rs.getInt("salary"), rs.getString("name"), rs.getString("address"), rs.getString("mobileno"));
    lst.add(e);
    }
    }
    catch(Exception ex){}

    return lst;
    }
    
    
     public Employee GetAllEmployeeByID(int id){
   Employee e=null;
    try{
    st=con.createStatement();
    rs=st.executeQuery("select * from employee where employeid="+id);
    
    if(rs.next())
    {
   e=new Employee(rs.getInt("Employeid"), rs.getInt("salary"), rs.getString("name"), rs.getString("address"), rs.getString("mobileno"));
   
    }
    }
    catch(Exception ex){}

    return e;
     }
    
}
