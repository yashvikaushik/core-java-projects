package model;

public class Word {
   private String meaning;
   private String sentence;

   Word(String meaning,String sentence){
    this.meaning=meaning;
    this.sentence=sentence;


   }

   public String getMeaning(){
    return meaning;
   }

   public String getSentence(){
    return sentence;
   }

   public void setMeaning(String meaning){
    this.meaning=meaning;

   }
   public void setSentence(String sentence){
    this.sentence=sentence;
   }

   public String toString(){
    return "meaning: "+meaning+" sentence: "+sentence;
   }
    
}
