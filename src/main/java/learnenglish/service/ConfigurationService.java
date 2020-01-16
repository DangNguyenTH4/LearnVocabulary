package learnenglish.service;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import learnenglish.driver.NetworkConnector;
import learnenglish.driver.ReadProperties;
import learnenglish.model.Message;
import learnenglish.model.Subject;

@Service
public class ConfigurationService {
	private Logger logger = LoggerFactory.getLogger(ConfigurationService.class);
	@Autowired
	private NetworkConnector networkConnector;
	public Message config(String placeToStudy, String time, String file) {
		logger.info("Configing .... ");
		Message m = new Message();
		try {
		if(!StringUtils.isEmpty(placeToStudy)) {
			ReadProperties.setProperty("placeToStudy", placeToStudy);
			m.setMessage("Config success!");
		}
		if(!StringUtils.isEmpty(time)) {
			Integer.parseInt(time);
			ReadProperties.setProperty("time", time);
			m.setMessage("Config success!");
		}
		if(!StringUtils.isEmpty(file)) {
			if(file.endsWith(".json")) {
				ReadProperties.setProperty("fileVocabulary", file);
				m.setMessage("Config success!");
			}
			else if(file.contains(".json")){
				m.setMessage("Your file is not a file!");
				m.setStatus(HttpStatus.BAD_REQUEST);
				m.setSuccess(false);
				return m;
			}else {
				ReadProperties.setProperty("fileVocabulary", file+".json");
				m.setMessage("Config success!");
			}
		}
		}catch (IOException e) {
			m.setMessage(e.getMessage());
			m.setStatus(HttpStatus.BAD_REQUEST);
			m.setSuccess(false);
			return m;
		}catch(NumberFormatException e) {
			m.setMessage("time : "+time+" is not all digits!");
			m.setSuccess(false);
			m.setStatus(HttpStatus.BAD_REQUEST);
			return m;
		}
		m.setStatus(HttpStatus.OK);
		m.setSuccess(true);
		return m;
	}
	public List<Subject> getListSubject(){
		try {
			return networkConnector.getListSubject();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
