package learnenglish.repository;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import learnenglish.model.ListWord;
import learnenglish.model.Word;

public class SaveWordOffline extends SaveWord {
	Logger logger = LoggerFactory.getLogger(SaveWordOffline.class);

	@Override
	public String getTypeLearn() {
		return "offline";
	}

	@Override
	public ListWord readWord() throws IOException {
		Gson gson = new Gson();
		ListWord words = null;
		BufferedReader br = null;
		try {
			logger.info(getFileName());
			br = new BufferedReader(new InputStreamReader(new FileInputStream(new File(getFileName())), "UTF8"));

			words = gson.fromJson(br, ListWord.class);
			System.out.println(words);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
		} finally {
			if (br != null)
				br.close();
		}
		return words;
	}

	@Override
	public String saveWord(Word word) throws IOException {
		logger.info("Save word offline is working.....");
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		ListWord listOld = readWord();
		String message = "";
		try (FileOutputStream os = new FileOutputStream(getFileName());
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os, "UTF8"));) {
			String json = "";
			if (listOld != null) {
				listOld.getLst().add(0, word);
				json = gson.toJson(listOld);
			} else {
				ListWord ls = new ListWord();
				ls.getLst().add(word);
				json = gson.toJson(ls);
			}
			bw.write(json);
		} catch (FileNotFoundException e) {
			logger.error(e.getMessage());
			message = "Your file is not exist!";
		} catch (UnsupportedEncodingException e) {
			logger.error(e.getMessage());
			message = e.getMessage();
		}
		if (listOld != null) {
			return "Save success!";
		} else {
			return "Can not save! " + message;
		}
	}

}