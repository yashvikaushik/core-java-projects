 import java.util.*;
import java.io.*;
public class StudentManagerApp {
    public static void main(String[] args) {
        StudentManager studentManager=new StudentManager();
        Scanner sc=new Scanner(System.in);
        int choice;
        

        do{

            System.out.println("WELCOME TO STUDENT MANAGEMENT APP");
            System.out.println("1. Add Student");
            System.out.println("2. Get Student ");
            System.out.println("3. Get All Students");
            System.out.println("4. Delete Student");
            System.out.println("5. Get Student Index ");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            

            switch(choice){
                case 1:
                System.out.println("you have chosen to add a student");
                System.out.println("enter the name of the student");
                String name=sc.next();
                System.out.println("enter the studentID");
                 int ID=sc.nextInt();
                System.out.println("enter the age of the student");
                int age=sc.nextInt();

                Student student=new Student(name, ID, age);

                studentManager.addStudent(student);
                break;

                case 2:
                System.out.println("enter the student id of the student you are looking for");
                int id=sc.nextInt();
                Student obj=studentManager.getStudent(id);
                System.out.println(obj);
                break;

                case 3:
                studentManager.getAllStudent();
                break;


                case 4:
                System.out.println("enter the student id of the student who you want to delete");
                int studID=sc.nextInt();
                studentManager.deleteStudent(studID);
                break;


                case 5:
                System.out.println("enter the student id of the student whos index you want");
                int index=sc.nextInt();
                studentManager.getStudentIndex(index);
                break;




                case 6:
                System.out.println("you have chosen to exit");
                break;

                default:
                System.out.println("wrong choice");




            }


        }
    
        while(choice!=6);
    }
    }








    