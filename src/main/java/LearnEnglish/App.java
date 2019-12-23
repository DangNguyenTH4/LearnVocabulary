package LearnEnglish;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		SaveWord sw = new SaveWord();
		ListWord temp = sw.readWord();
		if(temp==null || temp.getLst()==null) {
			List<Word> l = new ArrayList<Word>();
			l.add(new Word("Hello", "Xin Chào", "","hello"));
			l.add(new Word("Bye","Tạm biệt","","bai"));
			
			ListWord lst = new ListWord();
			lst.setLst(l);
			sw.saveWord(l);
		}
		Learn ln = new Learn();
		Thread t = new Thread(ln);
		
		t.start();
		
		
	}
}
