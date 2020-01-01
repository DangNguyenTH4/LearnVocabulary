package learnenglish.model;


import java.util.ArrayList;
import java.util.List;

public class ListWord {
	private List<Word> lst;
	public ListWord() {
		lst = new ArrayList<Word>();
	}
	public List<Word> getLst() {
		return lst;
	}

	public void setLst(List<Word> lst) {
		this.lst = lst;
	}
	
}
