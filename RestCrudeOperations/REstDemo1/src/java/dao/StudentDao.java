
package dao;
import model.Student;
import java.sql.*;
import java.util.*;
public class StudentDao {
    Connection con;
    Statement st;
    ResultSet rs;
    public StudentDao(){
    try{
        Class.forName("oracle.jdbc.OracleDriver");
    con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","system","oracle");
    }
    catch(Exception ex){
        System.out.println(ex.getMessage());
    }
    }
    
    public String AddStudent(Student s){
    int cnt=0;
    try{
    st=con.createStatement();
    cnt=st.executeUpdate("insert into students values("+s.getRno()+",'"+s.getName()+"','"+s.getAddress()+"','"+s.getMobile()+"')");

    }
    catch(Exception ex){
    return ex.getMessage();
    }
    return cnt+"";
  
    }
       public String UpdateStudent(Student s){
    int cnt=0;
    try{
    st=con.createStatement();
    cnt=st.executeUpdate("update students set name='"+s.getName()+"',address='"+s.getAddress()+"',mobile='"+s.getMobile()+"' where rollno="+s.getRno());

    }
    catch(Exception ex){
    return ex.getMessage();
    }
    return cnt+"";
  
    }
          public String DeleteStudent(int rno){
    int cnt=0;
    try{
    st=con.createStatement();
    cnt=st.executeUpdate("delete from students  where rollno="+rno);

    
    }
    catch(Exception ex){
    return ex.getMessage();
    }
    return cnt+"";
  
    }
     public List<Student> FetchAll(){
    List<Student> lst=new ArrayList<Student>();
    try{
    st=con.createStatement();
    rs=st.executeQuery("select * from students order by rollno asc");
while(rs.next()){
Student s=new  Student(rs.getInt("rollno"),rs.getString("name"),rs.getString("address"),rs.getString("mobile"));

lst.add(s);
}
    
    }
    catch(Exception ex){
        System.out.println(ex.getMessage());


    }
    
    return lst;
    } 
           public Student  FetchStudentByRollNo(int rno){
    Student stud=null;
    try{
    st=con.createStatement();
    rs=st.executeQuery("select * from students where rollno="+rno);
if(rs.next()){
stud=new  Student(rs.getInt("rollno"),rs.getString("name"),rs.getString("address"),rs.getString("mobile"));


}
    
    }
    catch(Exception ex){
        System.out.println(ex.getMessage());


    }
    
    return stud;
    } 
}
