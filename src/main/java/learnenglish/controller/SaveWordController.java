package learnenglish.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import learnenglish.model.ListWord;
import learnenglish.model.Word;
import learnenglish.service.SaveWordService;

@RestController
public class SaveWordController {
	@Autowired
	private SaveWordService saveWordService;
	private static Logger logger = LoggerFactory.getLogger(SaveWordController.class);
	@PostMapping("save-word")
	public Word saveWord(@RequestBody Word word) throws IOException {
		
		logger.info(word.getEng());
		
		saveWordService.saveWord(word);
		return word;
	}
	@GetMapping("save-word-get")
	public Word saveWordGet() throws IOException {
		Word word = new Word("dang", "dangnt", "hello dang", "hello");
		logger.info(word.getEng());
		
		saveWordService.saveWord(word);
		return word;
	}
	@GetMapping("read-word")
	public ListWord readWord() throws IOException {
		ListWord lst = saveWordService.readWord();
		return lst;
	}
}
