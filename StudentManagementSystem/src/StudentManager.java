import java.io.File;

public class StudentManager {

    StudentFileHandler studentFileHandler=new StudentFileHandler();
    

    public boolean addStudent(Student student){
        if(studentFileHandler.saveStudent(student))
        return true;
        else
        return false;
    }

    public boolean deleteStudent(int id){
       if(studentFileHandler.deleteStudent(id))
       return true;
       else
       return false;
    }

    public Student getStudent(int id){
       Student obj= studentFileHandler.getStudent(id);
       return obj;

    }

    public void getAllStudent(){
         studentFileHandler.loadStudents();
        //return student;
        //System.out.println(studentFileHandler.loadStudents());
    }

    public int getStudentIndex(int id){
       int index= studentFileHandler.getStudentIndex(id);
       return index;
    }

   

    
           
    
}
