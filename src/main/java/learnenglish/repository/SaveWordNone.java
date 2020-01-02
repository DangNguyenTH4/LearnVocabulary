package learnenglish.repository;
import org.springframework.http.HttpStatus;

import learnenglish.model.ListWord;
import learnenglish.model.Message;
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
	public Message saveWord(Word word) {
		Message message = new Message();
		message.setSuccess(false);
		message.setMessage("Type of learn is not offline! Please check again!");
		message.setStatus(HttpStatus.CONFLICT);
		return message;
	}
	
}
