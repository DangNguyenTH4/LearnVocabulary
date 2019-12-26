package learnenglish.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import learnenglish.model.Word;
import learnenglish.service.SaveWordService;

@RestController
public class SaveWordController {
	@Autowired
	private SaveWordService saveWordService;
	private static Logger logger = LoggerFactory.getLogger(SaveWordController.class);
	@PostMapping("save-word")
	public Word saveWord(@RequestBody Word word) {
		logger.info(word.getEng());
		saveWordService.saveWord();
		return word;
	}
}
