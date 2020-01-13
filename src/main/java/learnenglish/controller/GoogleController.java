package learnenglish.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import learnenglish.driver.NetworkConnector;

@RestController
public class GoogleController {
	@Autowired
	private NetworkConnector nc;
	@GetMapping("google")
	public String google(String word) throws IOException {
		System.out.println("Google");
		return nc.googleConnector(word);
		
	}
}
