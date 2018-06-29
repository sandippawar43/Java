
package mypackage;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.*;
import model.Student;
import dao.StudentDao;
@Path("/student")
public class StudentService {
   StudentDao sd=new StudentDao();
   @GET
   @Path("/add/{rno}/{name}/{address}/{mobile}")
   @Produces(MediaType.TEXT_PLAIN)
   public String Add(@PathParam("rno")int rno,@PathParam("name")String name,@PathParam("address")String address,@PathParam("mobile")String mobile){
  Student s=new Student(rno, name, address, mobile);
       String str=sd.AddStudent(s);
       return str;
   }
   
    @GET
   @Path("/edit/{rno}/{name}/{address}/{mobile}")
   @Produces(MediaType.TEXT_PLAIN)
   public String edit(@PathParam("rno")int rno,@PathParam("name")String name,@PathParam("address")String address,@PathParam("mobile")String mobile){
  Student s=new Student(rno, name, address, mobile);
       String str=sd.UpdateStudent(s);
       return str;
   }
      @GET
   @Path("/delete/{rno}")
   @Produces(MediaType.APPLICATION_JSON)
   public String Delete(@PathParam("rno") int rno)
   {
  String str=sd.DeleteStudent(rno);
   return str;
   }
    
   @GET
   @Path("/list")
   @Produces(MediaType.APPLICATION_JSON)
   public List<Student> GetAll()
   {
   List<Student>lst=sd.FetchAll();
   return lst;
   }
   
     @GET
   @Path("/list/{rno}")
   @Produces(MediaType.APPLICATION_JSON)
   public Student GetAll(@PathParam("rno") int rno)
   {
   Student s=sd.FetchStudentByRollNo(rno);
   return s;
   }
    
   
   
  
    
}
