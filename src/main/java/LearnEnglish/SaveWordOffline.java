package LearnEnglish;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SaveWordOffline extends SaveWord {
	static String fileName = "defaultVocabulary.json";
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
		Gson gson = new Gson();
		ListWord words = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(fileName)), "UTF8"));

			words = gson.fromJson(br, ListWord.class);
			System.out.println(words);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null)
				br.close();
		}
		return words;
	}

	public void initBasicVocabulary() throws IOException {
		ListWord temp = readWord();
		if (temp == null || temp.getLst() == null) {
			List<Word> l = new ArrayList<Word>();
			l.add(new Word("Vocabolary file does not true! Please check again in properties file", "",
					"File từ vựng không đúng. Hãy check lại tại file properties", ""));
			l.add(new Word("Bye", "Tạm biệt", "", "bai"));

			ListWord lst = new ListWord();
			lst.setLst(l);
			saveWord(l);
		}
	}

	public boolean checkIsNewFileName() {
		System.out.println("check is new File");

		String file = ReadProperties.getProperty("fileVocabulary");
		System.out.println(file);
		return !fileName.equals(file);
	}

	public void setNewFileName() {
		System.out.println("Set new file");
		String file = ReadProperties.getProperty("fileVocabulary");
		System.out.println(file);
		if (!StringUtils.isEmpty(file)) {
			fileName = file;
		}
	}
}
