package learnenglish.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import learnenglish.driver.ReadProperties;
import learnenglish.repository.SaveWord;
import learnenglish.repository.SaveWordNone;
import learnenglish.repository.SaveWordOffline;
import learnenglish.repository.SaveWordOnline;

public class SaveWordFactory {
	private static SaveWordOffline swOffline;
	private static SaveWordOnline swOnline;
	private static SaveWordNone swNone;
	private SaveWordFactory() {
		
	}
	private static Logger logger = LoggerFactory.getLogger(SaveWordFactory.class);
	public static SaveWord getInstance() {
		String placeFile = ReadProperties.getProperty("placeToStudy");
		logger.info(placeFile);
		if("online".equalsIgnoreCase(StringUtils.trimAllWhitespace(placeFile))) {
			if(swOnline==null) {
				logger.info("Online Saveword init");
				swOnline=new SaveWordOnline();
			}
			return swOnline;
		}
		else if("offline".equalsIgnoreCase(StringUtils.trimAllWhitespace(placeFile))) {
			logger.info("Offline Saveword init");
			if(swOffline==null) {
				swOffline=new SaveWordOffline();
			}
			return swOffline;
		}
		else {
			logger.info(" SavewordNone init");
			if(swNone==null) {
				swNone = new SaveWordNone();
			}
			return swNone;
		}
	}
}
