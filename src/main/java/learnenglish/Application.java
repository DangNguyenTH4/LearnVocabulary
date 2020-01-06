package learnenglish;

import learnenglish.driver.Gui;
import learnenglish.driver.Learn;

public class Application {
	public static void main(String[] args) {
		System.out.println("Application init----");
		Learn learn = new Learn();
		Thread t = new Thread(learn);
		t.start();
		new Gui();
	}
}
