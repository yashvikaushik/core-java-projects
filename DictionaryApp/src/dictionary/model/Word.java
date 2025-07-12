package dictionary.model;

public class Word {

    String meaning;
    String sentence;

    Word(String meaning,String sentence){
        this.meaning=meaning;
        this.sentence=sentence;
    }

    //getters

    public String getMeaning(){
        return meaning;
    }

    public String getSentence(){
        return sentence;
    }

    //setters

    public void setMeaning(String meaning){
        this.meaning=meaning;
    }

    public void setSentence(String sentence){
        this.sentence=sentence;
    }

    //the toString()

    public String toString(){
        return "meaning: "+meaning+" sentence: "+sentence;
    }
    
    
}
