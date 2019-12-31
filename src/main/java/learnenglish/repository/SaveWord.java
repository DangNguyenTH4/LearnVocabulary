package learnenglish.repository;

import java.io.IOException;

import org.springframework.util.StringUtils;

import learnenglish.driver.ReadProperties;
import learnenglish.model.ListWord;
import learnenglish.model.Word;

public abstract class SaveWord {
	private static String fileName="defaultVocabulary.json";
	public String getFileName() {
		return fileName;
	}
	

	public void setNewFileName() {
		System.out.println("Set new file");
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
		System.out.println("check is new properties(filename,placeTostudy,time)");
		String file = ReadProperties.getProperty("fileVocabulary");
		String place = ReadProperties.getProperty("placeToStudy");
		int time = Integer.parseInt(ReadProperties.getProperty("time"));

		System.out.println(place+"----"+file+"===="+time);
		boolean result= !fileName.equals(StringUtils.trimAllWhitespace(file)) || !getTypeLearn().equals(StringUtils.trimAllWhitespace(place))
				|| (time != oldTime && time>=10000);
		return result;
	}

	
	public abstract String getTypeLearn();
	public abstract ListWord readWord() throws IOException;
<<<<<<< HEAD
	public abstract Word saveWord(Word word) throws IOException;

=======
	public abstract Word saveWord(Word word);
>>>>>>> bc832572df913b05b3bc8c219207efbe8a179aa4
}
