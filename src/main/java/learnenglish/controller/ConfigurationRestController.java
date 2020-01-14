package learnenglish.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import learnenglish.model.Message;
import learnenglish.model.Subject;
import learnenglish.service.ConfigurationService;

@Controller
public class ConfigurationRestController {
	@Autowired
	private ConfigurationService configurationService;
	@GetMapping("config-learn")
	public String config(String placeToStudy, String time, String fileVocabulary, Model model) {
		System.out.println("Call config learn");
		List<Subject> listSubject = configurationService.getListSubject();
		Message message = configurationService.config(placeToStudy,time,fileVocabulary);
		model.addAttribute("listSubject", listSubject);
		model.addAttribute("message", message);
		System.out.println("Return configuration");
		return "configuration";
	}
	
}
