package LearnEnglish;

import java.io.IOException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws IOException {
		SaveWord sw = new SaveWord();
		sw.initBasicVocabulary();
		Learn ln = new Learn();
		Thread t = new Thread(ln);
		t.start();
	}
}