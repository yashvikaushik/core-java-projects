import java.util.*;
import dictionary.model.Word;
import dictionary.dal.DictionaryFileHandler;
import dictionary.service.DictionaryService;
public class DictionaryApp {
    Scanner sc=new Scanner(System.in);
    Word word;
    DictionaryService dictionaryService=new DictionaryService();
    

    public int showMenu(){
        System.out.println("welcome to the World of Words");
        System.out.println("1. Add Word  \n2. Search Word  \n 3. Update Word  \n 4. Delete Word  \n5. View All Words  \n6. Exit  ");
        System.out.println("enter your choice");
        int choice=sc.nextInt();
        return choice;

    }

    public void run(){
        int choice;
        do{
        choice=showMenu();

        
        switch(choice){

            case 1: System.out.println("you have chosen to add a word");
            System.out.println("enter the word");
            
            String w=sc.next();
            System.out.println("enter the meaning");
            sc.next();
            String meaning=sc.nextLine();
            System.out.println("enter the sentence");
            String sentence=sc.nextLine();
            word=new Word(w,meaning,sentence);
            dictionaryService.addWord(word);
            System.out.println("word added successfully");
            break;

            case 2:System.out.println("enter the word you are looking for");
            String searchword=sc.next();
            Word wordFound= dictionaryService.search(searchword);
            if(wordFound!=null)
            {
                System.out.println("WORD: "+word.getWord());
                System.out.println("MEANING: "+word.getMeaning());
                System.out.println("SENTENCE: "+word.getSentence());
            }
            else{
                System.out.println("word not present in the dictionary");
            }
            break;
            

        

        default:
        System.out.println("wrong choice");
       }
    }
       while(choice!=6);
    

}

public static void main(String args[]){
    DictionaryApp dictionaryApp=new DictionaryApp();
    dictionaryApp.run();
}
}
