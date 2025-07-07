package diary.model;

import java.io.Serializable;

public class Note implements Serializable {
    static final long serialVersionUID = 42L;
    private String date;
    private String title;
    private String content;

   public Note(String date,String title,String content){
        this.date=date;
        this.title=title;
        this.content=content;

    }

    //getters
    public String getDate(){
        return date;
    }
    public String getTitle(){
        return title;
    }
    public String getContent(){
        return content;
    }

    //setters
    public void setDate(String date){
        this.date=date;
    }

    public void setTitle(String title){
        this.title=title;
    }

    public void setContent(String content){
        this.content=content;
    }

    //the toString() method

    public String toString(){
        return "date: "+date+"\nTitle: "+title+"\nContent: "+content;
    }
    
}
