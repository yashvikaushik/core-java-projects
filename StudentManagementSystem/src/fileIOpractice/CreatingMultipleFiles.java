package fileIOpractice;
import java.io.*;
public class CreatingMultipleFiles {
    public static void main(String[] args) {
        try{
       // path of the folder is given which is already created through the terminal
        File folder =new File("/Users/yashvikaushik/Documents/StudentManager");

        //checking if folder exists otherwise creates a folder
        if(folder.exists()){
            System.out.println("folder exists already");
        }
        else{
            folder.mkdirs();
            System.out.println("folder created successfully");
        }

        String[] messages = {
                "This is note 1 — Hello, world!",
                "Note 2 says you're doing great, Yashvi!",
                "Note 3: Keep practicing File I/O 💪",
                "Note 4: Almost at the end of challenge 2!",
                "Note 5: Time to celebrate your progress 🎉"
            };

            for(int i=0;i<messages.length;i++){
                File file=new File(folder,"note"+(i+1)+".txt");
                FileWriter writer =new FileWriter(file);
                writer.write(messages[i]);
                writer.close();
            }

    }
    catch(Exception e){
        System.out.println(e);
    }
    }
    
}
