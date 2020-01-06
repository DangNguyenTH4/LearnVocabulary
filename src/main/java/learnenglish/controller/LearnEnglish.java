package learnenglish.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
