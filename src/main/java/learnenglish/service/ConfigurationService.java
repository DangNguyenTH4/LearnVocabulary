package learnenglish.service;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import learnenglish.driver.ReadProperties;
import learnenglish.model.Message;

@Service
public class ConfigurationService {

	public Message config(String placeToStudy, String time, String file) {
		Message m = new Message();
		try {
		if(!StringUtils.isEmpty(placeToStudy)) {
			ReadProperties.setProperty("placeToStudy", placeToStudy);
		}
		if(!StringUtils.isEmpty(time)) {
			ReadProperties.setProperty("time", time);
		}
		if(!StringUtils.isEmpty(file)) {
			if(file.endsWith(".json")) {
				ReadProperties.setProperty("fileVocabulary", file);
			}
			else if(file.contains(".json")){
				m.setMessage("Your file is not a file!");
				m.setStatus(HttpStatus.BAD_REQUEST);
				m.setSuccess(false);
				return m;
			}else {
				ReadProperties.setProperty("fileVocabulary", file+".json");
			}
		}
		}catch (IOException e) {
			m.setMessage(e.getMessage());
			m.setStatus(HttpStatus.BAD_REQUEST);
			m.setSuccess(false);
		}
		m.setStatus(HttpStatus.OK);
		m.setSuccess(true);
		m.setMessage("Config success!");
		return m;
	}
	
}
