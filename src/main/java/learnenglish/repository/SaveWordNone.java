package learnenglish.repository;
import learnenglish.model.ListWord;
import learnenglish.model.Word;

public class SaveWordNone extends SaveWord{

	public String getTypeLearn() {
		
		return "none";
	}

	@Override
	public ListWord readWord() {
		ListWord lst = new ListWord();
		lst.getLst().add(new Word("Type of learn does not true! Please check in your properties!","","",""));
		return lst;
	}

	@Override
	public Word saveWord(Word word) {
		return null;
	}
	
}
