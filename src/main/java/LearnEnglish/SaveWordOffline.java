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

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class SaveWordOffline extends SaveWord {
	@Override
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
	@Override
	public ListWord readWord() throws IOException {
		Gson gson = new Gson();
		ListWord words = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(getFileName())), "UTF8"));

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
	@Override
	public String getMethodLearn() {
		return "offline";
	}
}
