package dictionary.model;

import java.io.Serializable;

public class Word implements Serializable {

    static final long serialVersionUID = 42L;

    private String meaning;
    private String sentence;
    private String wrd;


    public Word(String meaning,String sentence,String wrd){
        this.meaning=meaning;
        this.sentence=sentence;
        this.wrd=wrd;
    }

    //getters

    public String getMeaning(){
        return meaning;
    }

    public String getSentence(){
        return sentence;
    }

    public String getWord(){
        return wrd;
    }

    //setters

    public void setMeaning(String meaning){
        this.meaning=meaning;
    }

    public void setSentence(String sentence){
        this.sentence=sentence;
    }

    public void setWord(String wrd){
        this.wrd=wrd;
    }

    //the toString()

    public String toString(){
        return "word: "+wrd+" meaning: "+meaning+" sentence: "+sentence;
    }
    
    
}
