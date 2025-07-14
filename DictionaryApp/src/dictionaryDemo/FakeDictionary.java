package dictionaryDemo;
import java.util.Scanner;
import java.util.TreeMap;

public class FakeDictionary {
    Scanner sc=new Scanner(System.in);

    String word;
    String meaning;

    public int choice;
   static TreeMap<String ,String> dictionary=new TreeMap<String,String>();

    public static boolean addWord(String word,String meaning){

        try{
            dictionary.put(word,meaning);
            return true;
        }
        catch(Exception e){
            System.out.println(e);
        }
        return false;

    }

    public static String searchWord(String word){

        
            if(dictionary.containsKey(word)){
                System.out.println("the word exists in the dictionary");
            return dictionary.get(word);
            }
            else{
                System.out.println("no such word exists");
            return null;
        }
        

    }

    public static TreeMap<String,String> dsplayDictionary(){
        
        return dictionary;
    }
    
    public int showMenu(){
        System.out.println("welcome to the demo dictionary");
        System.out.println("here are the operations that you can perform\n 1.)add a word \n 2.) search a word");
        System.out.print("enter your choice  ");
        int choice=sc.nextInt();
        return choice;
    }

    public static void deleteDictionary(){
        dictionary.clear();
    }

    public void run(){
        

        do{
            int choice=showMenu();
            switch(choice){
                case 1:
                System.out.println("you have chosen to add a word");
                System.out.println("enter the word");
                String word=sc.next();
                System.out.println("enter the meaning of the entered word");
                String meaning=sc.next();
                if(FakeDictionary.addWord(word,meaning)){
                    System.out.println("word added successfully");

                }
                else{
                    System.out.println("word could not be added");
                }
                break;

                case 2: System.out.println("you have chosen to search a word");
                System.out.println("enter the word");
                String wrd=sc.next();
                String meanig=  FakeDictionary.searchWord(wrd);
                System.out.println();
                System.out.println("the meaning of the entered word "+meanig);
                break;

                case 3:System.out.println("you have choosen to display the whole dictionary");
                System.out.println(" ");
                System.out.println(FakeDictionary.dsplayDictionary());

                case 4:
                System.out.println("you have chosen to delete the whole dictionary");
                FakeDictionary.deleteDictionary();
                

                case 5:
                System.out.println("you have been exited successfully");
                break;


                default:
                System.out.println("wrong choice");

                
            }
        }
        while(choice!=4);
    }
    public static void main(String[] args) {
        FakeDictionary fakeDictionary=new FakeDictionary();
        fakeDictionary.run();
    }
}
