package learnenglish.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import learnenglish.model.Message;
import learnenglish.service.ConfigurationService;

@Controller
public class ConfigurationRestController {
	@Autowired
	private ConfigurationService configurationService;
	@GetMapping("config-learn")
	public String config(String placeToStudy, String time, String fileVocabulary) {
		Message message = configurationService.config(placeToStudy,time,fileVocabulary);
		return "configuration";
	}
}
