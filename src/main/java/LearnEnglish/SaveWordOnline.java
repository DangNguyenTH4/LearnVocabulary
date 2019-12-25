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

public class SaveWordOnline extends SaveWord {
	private NetworkConnector nc = new NetworkConnector();

	public void saveWord(List<Word> words) throws IOException {
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		ListWord listOld = readWord();
		try (FileOutputStream os = new FileOutputStream(getFileName());
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
		ListWord words = null;
		words  = nc.getDataFromFile(getFileName());
		if(words==null) {
			words = new ListWord();
			words.getLst().add(new Word("File not found or network problem", "", "", ""));
		}
		return words;
	}

	public void initBasicVocabulary() throws IOException {
		ListWord temp = readWord();
		if (temp == null || temp.getLst() == null) {
			List<Word> l = new ArrayList<Word>();
			l.add(new Word("Vocabolary file does not true! Please check again in properties file", "",
					"File từ vựng không đúng. Hãy check lại tại file properties", ""));

			ListWord lst = new ListWord();
			lst.setLst(l);
			saveWord(l);
		}
	}

	@Override
	public String getMethodLearn() {
		return "online";
	}
}
