package fileIOpractice;
import java.util.*;

import java.io.*;
public class NameAndHobby {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        try{
            System.out.println("enter your name");
            String name=sc.next();
            System.out.println("enter your hobby ");
            String hobby=sc.next();
            File folder=new File("/Users/yashvikaushik/Documents/StudentManager");
            File file=new File(folder,name+".txt");
            FileWriter writer=new FileWriter(file);
            writer.write("name: "+name);
            writer.write("\nhobby: "+hobby);
            writer.close();


        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
