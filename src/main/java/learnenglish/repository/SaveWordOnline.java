package learnenglish.repository;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import learnenglish.driver.NetworkConnector;
import learnenglish.model.ListWord;
import learnenglish.model.Word;

public class SaveWordOnline extends SaveWord {
	private NetworkConnector nc = new NetworkConnector();
	private Logger logger = LoggerFactory.getLogger(SaveWordOnline.class);
	@Override
	public String getTypeLearn() {
		return "online";
	}

	@Override
	public ListWord readWord() throws IOException {
		logger.info("Read word online.....");
		ListWord words = null;
		words  = nc.getDataFromFile(getFileName());
		if(words==null) {
			words = new ListWord();
			words.getLst().add(new Word("File not found or network problem", "", "", ""));
		}
		return words;
	}

	@Override
	public String saveWord(Word word) {
		return "You are in online mode! You can not save anything!";
	}

}
