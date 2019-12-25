package LearnEnglish;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException, InterruptedException {
//		SaveWord sw = SaveWordFactory.getInstance();
//		sw.initBasicVocabulary();

		Gui g = new Gui();
		NotifyWord nc = new NotifyWord();
		nc.displayNotify(new Word("Xin chao","","",""));
		Boolean c = true;
		
//		Learn ln = new Learn();
//		Thread t = new Thread(ln);
//		t.start();
		
		
		Learn ln = new Learn(c);
		Thread t = new Thread(ln);
		t.start();


//		NetworkConnector nc = new NetworkConnector();
//		ListWord lst = nc.getDataFromFile("blank.json");
//		System.out.println(lst.getLst().size());
	}
}
