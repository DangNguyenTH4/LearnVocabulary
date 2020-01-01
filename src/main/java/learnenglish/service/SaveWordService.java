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
	
	public void setSaveWord() {
		logger.info("Init saveword from save word factory");
		this.saveWord = SaveWordFactory.getInstance();
	}
	
	@Autowired
	public SaveWordService() {
		this.saveWord = SaveWordFactory.getInstance();
	}
	public String saveWord(Word word) throws IOException {
		logger.info("Save word in service save word running ....");
		return saveWord.saveWord(word);
	}
	public ListWord readWord() throws IOException {
		ListWord words = saveWord.readWord();
		if(words==null){
			words= new ListWord();
			words.getLst().add(new Word("File not found or data is not ready. Please check again!", "", "", ""));
		}
		else if(words.getLst().size()==0) {
			words.getLst().add(new Word("You don't have any words. Add please!", "", "", ""));
		}
		return words;
	}
	public String getFileName() {
		return saveWord.getFileName();
	}
	public void setNewFileName() {
		saveWord.setNewFileName();
	}
	public boolean checkIsChangeProperties(int oldTime) {
		System.out.println(saveWord==null);
		return saveWord.checkIsChangeProperties(oldTime);
	}
	public String getTypeLearn() {
		return saveWord.getTypeLearn();
	}
}
