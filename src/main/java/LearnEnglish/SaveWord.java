package LearnEnglish;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public abstract class SaveWord {
	private static String fileName = "defaultVocabulary.json";

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

	public void saveWord(List<Word> words) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		ListWord listOld = readWord();
		try (FileOutputStream os = new FileOutputStream(fileName);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF8"));) {
			String json = "";
			if (listOld != null) {
				listOld.getLst().addAll(words);
				json = gson.toJson(listOld);
			} else {
				ListWord ls = new ListWord();
				ls.setLst(words);
				json = gson.toJson(ls);
			}
			bw.write(json);
			System.out.println(json);
		}
	}

	public ListWord readWord() throws IOException {
		ListWord words = new ListWord();
		words.getLst().add(new Word("Place to learn not correct! Please check again!", "", "", ""));
		return words;
	}

	public void initBasicVocabulary() throws IOException {
		List<Word> l = new ArrayList<Word>();
		l.add(new Word("Vocabolary file does not true! Please check again in properties file", "",
				"File từ vựng không đúng. Hãy check lại tại file properties", ""));
		ListWord lst = new ListWord();
		lst.setLst(l);
		saveWord(l);
	}

	public boolean checkIsChangeProperties(int oldTime) {
		System.out.println("check is new properties(filename,placeTostudy,time)");
		String file = ReadProperties.getProperty("fileVocabulary");
		String place = ReadProperties.getProperty("placeToStudy");
		int time = Integer.parseInt(ReadProperties.getProperty("time"));

		System.out.println(place);
		return !fileName.equals(StringUtils.trim(file)) || !getMethodLearn().equals(StringUtils.trim(place))
				|| (time != oldTime && oldTime>=10000);
	}

	public abstract String getMethodLearn();

}
