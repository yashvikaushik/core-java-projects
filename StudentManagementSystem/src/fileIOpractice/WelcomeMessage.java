package fileIOpractice;
import java.io.*;
public class WelcomeMessage {

    public static void main(String[] args) {
        try{
            File folder=new File("/Users/yashvikaushik/Documents/StudentManager");
            File file=new File(folder,"welcome.txt");
            FileWriter write =new FileWriter(file);
            write.write("Hello world");
            write.close();
            System.out.println("file created inside the folder");


        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
