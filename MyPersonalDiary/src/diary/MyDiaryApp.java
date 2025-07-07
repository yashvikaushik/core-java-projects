package diary;
import diary.dal.DiaryFileHandler;
import diary.model.Note;
import diary.service.MyDiaryService;
import java.util.*;
import java.sql.Date;


public class MyDiaryApp {
    Scanner sc=new Scanner(System.in);
    int choice;
    MyDiaryService myDiaryService=new MyDiaryService();


    public int showMenu(){
        System.out.println("1. Add Note");
        System.out.println("2. delete Notes");
        System.out.println("3. View Notes");
        System.out.println("4. update Note");
        System.out.println("5. Exit");
        System.out.print("Choose an option: ");

        choice=sc.nextInt();
        sc.nextLine();
        return choice;


    }

    public void run(){
        

        do{
            choice=showMenu();

        switch(choice){
            case 1:
            //to take the current date a prebuilt library
             String date = Date.valueOf(java.time.LocalDate.now()).toString();
            System.out.println("Enter your title");
            String title=sc.nextLine();
            //sc.next();
            System.out.println("enter the content");
            String content=sc.nextLine();
            //sc.nextLine();


            Note note=new Note(date,title,content);
            if(myDiaryService.addNote(note))
            System.out.println("note added succesfully");
           else
           System.out.println("note could not be added");
           
           break;

            case 2:
            System.out.println("enter the date of note that has to be deleted");
            String d=sc.nextLine();
            //sc.nextLine();
            if(myDiaryService.deleteNote(d)){
                System.out.println("note deleted successfully");

            }
            else{
                System.out.println("note not deleted");
            }

            break;

            case 3:
            myDiaryService.viewNotes();
            break;


            case 4:
            String da = Date.valueOf(java.time.LocalDate.now()).toString();
            System.out.println("Enter your updated title");
            String t=sc.nextLine();
            //sc.next();
            System.out.println("enter the updated content");
            String c=sc.nextLine();
            //sc.nextLine();
            Note n=new Note(da,t,c);
            if(myDiaryService.appendNote(n))
            break;

            case 5:
            System.out.println("you have been exited successfully");
            break;


            default:
            System.out.println("wrong choice");



        }
    }
    while(choice!=5);


    }
    public static void main(String[] args) {
        MyDiaryApp myDiaryApp=new MyDiaryApp();
        myDiaryApp.run();
    }

    
}
