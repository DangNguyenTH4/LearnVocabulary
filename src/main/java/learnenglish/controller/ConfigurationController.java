package learnenglish.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ConfigurationController {
	
	@GetMapping("config")
	public String config() {
		
		return "configuration";
	}
}
