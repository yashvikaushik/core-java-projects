package diary.dal;

//the package containg the note class has also been imported
import diary.model.Note;

//all the necessary packages have been imported
import java.io.IOException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class DiaryFileHandler {
    Note note;
    Note[] notes;

   final static  String path="/Users/yashvikaushik/Documents/MyPersonalDiaryApp";
    File folder=new File(path);

    public boolean saveNoteToFile(Note note){

        File file=new File(folder,note.getDate()+".txt");

        try{
        FileOutputStream fout=new FileOutputStream(file,true);
        ObjectOutputStream out=new ObjectOutputStream(fout);
        out.writeObject(note);
        out.close();
        fout.close();
        return true;

        
        }
        catch(IOException e){
            System.out.println(e);
        }

        return false;
    }

    public boolean deleteNoteFromFile(String date){
        try{
            File file=new File(folder,date);
            if(file.exists()){
                return file.delete();
            }


            
        }
        catch(Exception e){

        }
        return false;


    }

    public void viewFileNotes(){
        File file[] =folder.listFiles();
        if(file==null){
            System.out.println("no notes present");
            //return new Note[0];
            //System.out.println("no notes added so far");

        }
        
        int index=0;

        //array initialization was necessary bcz array works on size
        Note[] notes=new Note[file.length];
        try{
        for(int i=0;i<file.length;i++){
            //File f=new File(folder,note.getDate()+".txt");
            if(file[i].getName().indexOf("DS_Store")!=-1)
            continue;
            System.out.println("fileName:"+file[i].getName());
            FileInputStream fin=new FileInputStream(file[i]);
            ObjectInputStream oin=new ObjectInputStream(fin);
            Note obj=(Note)oin.readObject();
            notes[index]=obj;
            index++;
            fin.close();
            oin.close();
            }
        //return notes;
    }
    catch(Exception e){
        System.out.println(e);

    }  
    
    //return notes;  
    for(Note note:notes){
        System.out.println(note);
    }    

    }

    

}
