package learnenglish.model;

import java.util.ArrayList;
import java.util.List;

public class ListWord {
	private List<Word> lst;
	public List<Word> getLst(){
		return this.lst;
	}
	public void setLst(List<Word> lst) {
		this.lst=lst;
	}
	public ListWord() {
		lst= new ArrayList<>();
	}
}
