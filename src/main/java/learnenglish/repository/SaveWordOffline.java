package learnenglish.repository;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import com.google.gson.Gson;

import learnenglish.model.ListWord;
import learnenglish.model.Word;

public class SaveWordOffline extends SaveWord{

	@Override
	public String getTypeLearn() {
		// TODO Auto-generated method stub
		return null;
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
		}
		finally {
			if (br != null)
				br.close();
		}
		
		if(words==null){
			words= new ListWord();
			words.getLst().add(new Word("File not found or data is not ready.Please check again!", "", "", ""));
		}
		else if(words.getLst().size()==0) {
			words.getLst().add(new Word("You don't have any words. Add please!", "", "", ""));
		}
		return words;
	}

	@Override
	public Word saveWord(Word word) {
		// TODO Auto-generated method stub
		return null;
	}

}
