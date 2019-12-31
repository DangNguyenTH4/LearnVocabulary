package learnenglish.service;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learnenglish.factory.SaveWordFactory;
import learnenglish.model.ListWord;
import learnenglish.model.Word;
import learnenglish.repository.SaveWord;

@Service
public class SaveWordService {
	private SaveWord saveWord;
	private static Logger logger = LoggerFactory.getLogger(SaveWordService.class);
	@Autowired
	public void setSaveWord() {
		logger.info("Init saveword from save word factory");
		this.saveWord = SaveWordFactory.getInstance();
	}
	public void saveWord(Word word) {
		
		logger.info("Save word in service save word running ....");
	}
	public ListWord readWord() throws IOException {
		ListWord lst = saveWord.readWord();
		return lst;
	}
}
