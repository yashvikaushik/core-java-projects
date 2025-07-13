package dictionary.dal;
import dictionary.model.Word;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.util.HashMap;
import java.util.Scanner;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.TreeMap;

public class DictionaryFileHandler {
    Scanner sc=new Scanner(System.in);
    Word word;
   TreeMap<String ,Word > words =new TreeMap<String,Word>();
    Word read;
   

    File folder=new File("/Users/yashvikaushik/Documents/DictionaryApp");
     File file=new File(folder,"myDictionary.Txt");


    public void  addWord(Word word){

        //TreeMap
        //TreeMap<String ,Word > words =new TreeMap<String,Word>();
       
        words.put(word.getWord(),word);
        try{
           FileOutputStream fout=new FileOutputStream(file);
            ObjectOutputStream out=new ObjectOutputStream(fout);
            out.writeObject(words);
            out.close();
            fout.close();

        }
        catch(Exception e){
            System.out.println(e);
        }
        
       
    }
   

    

    public Word searchWord(String word){
        //Word read=null;
        try{
            FileInputStream fin=new FileInputStream(file);
            ObjectInputStream oin=new ObjectInputStream(fin);
            for(int i=0;i<words.size();i++){
                if(word.equals(words.get(word)) && word!=null){
                    read=(Word)oin.readObject();
                    return read;
                    
                }
                else return null;
            }
           // Word read=(Word)oin.readObject();
            System.out.println("the word is: "+word);


        }
        catch(Exception e){
            System.out.println(e);
        }


       return null;



    }
    
}
