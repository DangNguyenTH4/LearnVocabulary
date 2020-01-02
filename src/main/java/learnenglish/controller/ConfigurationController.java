package learnenglish.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import learnenglish.driver.ReadProperties;

@Controller
public class ConfigurationController {
	
	@GetMapping("config")
	public String config() {
		
		return "configuration";
	}
}
