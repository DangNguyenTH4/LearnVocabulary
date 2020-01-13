package learnenglish.repository;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import learnenglish.driver.ReadProperties;
import learnenglish.model.ListWord;
import learnenglish.model.Message;
import learnenglish.model.Word;

public abstract class SaveWord {
	private static String fileName="defaultVocabulary.json";
	private Logger logger = LoggerFactory.getLogger(SaveWord.class);
	public String getFileName() {
		return fileName;
	}
	

	public void setNewFileName() {
		logger.info("Set new file");
		String file = ReadProperties.getProperty("fileVocabulary");
		System.out.println(file);
		if (!StringUtils.isEmpty(file)) {
			fileName = file;
		}
	}

	static {
		String file = ReadProperties.getProperty("fileVocabulary");
		if (!StringUtils.isEmpty(file)) {
			fileName = file;
		}
	}

	public boolean checkIsChangeProperties(int oldTime) {
		logger.info("check is new properties(filename,placeTostudy,time)");
		String file = ReadProperties.getProperty("fileVocabulary");
		String place = ReadProperties.getProperty("placeToStudy");
		int time = Integer.parseInt(ReadProperties.getProperty("time"));

		logger.info(place+"----"+file+"===="+time);
		boolean result= !fileName.equalsIgnoreCase(StringUtils.trimAllWhitespace(file)) || !getTypeLearn().equalsIgnoreCase(StringUtils.trimAllWhitespace(place))
				|| (time != oldTime && time>=10000);
		return result;
	}

	public abstract boolean updateList(ListWord lst);
	public abstract String getTypeLearn();
	public abstract ListWord readWord() throws IOException;
	public abstract Message saveWord(Word word) throws IOException;

}
