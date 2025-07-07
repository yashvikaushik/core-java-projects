package diary.service;
import diary.model.Note;
import diary.dal.DiaryFileHandler;

public class MyDiaryService {
    DiaryFileHandler myFileHandler=new DiaryFileHandler();


    public boolean addNote(Note note){
        return myFileHandler.saveNoteToFile(note);
    }

    public boolean deleteNote(String date){
        return myFileHandler.deleteNoteFromFile(date);

    }

    public Note[] viewNotes(){
        return myFileHandler.viewFileNotes();
    }
    public boolean appendNote(Note note){
        return myFileHandler.saveNoteToFile(note);
    }
}
