package LearnEnglish;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Learn implements Runnable {
	private SaveWord sw;
	private NotifyWord nt;

	int time = 10000;

	private void loadProps() {
		this.time = Integer.parseInt(ReadProperties.getProperty("time"));
	}

	public Learn() {
		sw = new SaveWord();
		nt = new NotifyWord();
		loadProps();
	}

	@Override
	public void run() {
		int i = -1;
		int size = 0;
		ListWord lst = null;
		System.out.println("Time: " + time);
		while (true) {

			try {
				Thread.sleep(time);
				if (i >= size || i == -1) {
					lst = sw.readWord();
					if (lst != null && lst.getLst() != null) {
						size = lst.getLst().size();
					}
					i = 0;
				}
				if (i < size) {
					nt.displayNotify((Word) lst.getLst().get(i));
				}
				i++;

			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
