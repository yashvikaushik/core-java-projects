package dictionary.service;
import dictionary.dal.DictionaryFileHandler;
import dictionary.model.Word;;
public class DictionaryService {
    DictionaryFileHandler dictionaryFileHandler=new DictionaryFileHandler();

    public void addWord(Word word){
        dictionaryFileHandler.addWord(word);

    }

    public Word search(String word){
        return dictionaryFileHandler.searchWord(word);
    }
    
    
}
