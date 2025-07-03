package fileIOpractice;
import java.io.*;
public class MyFileOutputStream {
    public static void main(String[] args) {
        try{
            File folder=new File("/Users/yashvikaushik/Documents/StudentManager");
            File file=new File(folder,"hello.dat");
            FileOutputStream fout=new FileOutputStream(file);
            fout.write(72);
             fout.write(69);
              fout.write(76);
               fout.write(76);
                fout.write(79);
                fout.close();

        }
        catch(Exception e){
            System.out.println(e);
        }
    }
    
}
