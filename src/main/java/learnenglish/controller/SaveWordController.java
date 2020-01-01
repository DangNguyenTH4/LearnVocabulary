package learnenglish.controller;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	public String saveWord(@RequestBody Word word) throws IOException {
		System.out.println(word);
		String result = saveWordService.saveWord(word);
		return result;
	}
	
	@GetMapping("read-word")
	public ListWord readWord() throws IOException {
		ListWord lst = saveWordService.readWord();
		return lst;
	}
}
