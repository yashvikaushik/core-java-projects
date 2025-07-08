import java.util.*;
import java.io.*;
public class StudentFileHandler {
    //new folder created
    public File folder=new File("/Users/yashvikaushik/Documents/StudentManager");

    Student student[];
   
    public boolean saveStudent(Student student){
        try{
            File file=new File(folder,"student"+student.getID()+".txt");
            FileOutputStream fout=new FileOutputStream(file);
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(student);
            out.close();
            fout.close();
            return true;

        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;

    }

    public void loadStudents(){

        File files[]=folder.listFiles();
        if(files==null){
            System.out.println("no file present");
        }

        //counting the number of text files
        int count=files.length;
        // for(File file: files){
        //     if(file.exists())
        //     count++;
        // }

        //student array of the same as the number of files exists 
        student=new Student[count];
        int index=0;
        
        

            for(int i=0;i<count;i++){
                if(files[i].getName().startsWith("."))
                continue;
                
            else{
                try{


                FileInputStream fin =new FileInputStream(files[i]);
                ObjectInputStream oin=new ObjectInputStream(fin);
                Student stud=(Student)oin.readObject();
                student[index]=stud;
                index++;
                fin.close();
                oin.close();
                }
                catch(Exception e){
            System.out.println(e);
        }
            }
        }
        for(Student s:student){
            System.out.println(s);
        }
        //return student;
    }

        
       
    

    public boolean deleteStudent(int id){
        File file=new File(folder,"student"+id+".txt");
        if(file.exists()){
            file.delete();
            return true;

        }
        else{
            return false;
        }


    }

    public Student getStudent(int id){
         File file=new File(folder,"student"+id+".txt");
         Student obj=null;
         if(file.exists()){
            try{
                FileInputStream fin=new FileInputStream(file);
                ObjectInputStream oin=new ObjectInputStream(fin);
               obj=(Student)oin.readObject();
                // System.out.println(obj);
                fin.close();
                oin.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
            return obj;
         }
         else{
            System.out.println("file does not exists");
            return null;
         }

    }

    public int getStudentIndex(int id){
        File file=new File(folder,"student"+id+".txt");
        if(file.exists()){
            int index=0;
            try{
                FileInputStream fin=new FileInputStream(file);
                ObjectInputStream oin=new ObjectInputStream(fin);
                Student obj=(Student)oin.readObject();
                 index =obj.getID();
                fin.close();
                oin.close();
            }
            catch(Exception e){
                System.out.println(e);
            }
            return index;
         }
         else{
            System.out.println("file does not exists");
            return 0;
         }


    }
}
    
   




    

