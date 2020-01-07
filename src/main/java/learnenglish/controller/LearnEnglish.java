package learnenglish.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import learnenglish.exception.ConfigFailedException;
import learnenglish.exception.SaveWordException;
import learnenglish.exception.WordNotFoundException;

@Controller
public class LearnEnglish {
	@GetMapping("/save-word")
	public String saveWord(Model m) {
		m.addAttribute("name", "dangasdfadf");
		return "index";
	}
	@GetMapping("/30days")
	public String get30days() {
		return "30daytuluyen"; 
	}
	@GetMapping("/word-not-found")
	public String wordNotFound() {
		throw new WordNotFoundException("Word not found Exception Handller");
	}
	@GetMapping("save-word-Ex")
	public String saveWordEx() {
		throw new SaveWordException("Save word exception handller");
	}
	@GetMapping("config-failed")
	public String configFailed() {
		throw new ConfigFailedException("Config exception Handleler");
	}
	
}
