package LearnEnglish;

import java.io.IOException;

import org.apache.commons.lang3.StringUtils;

public class Learn implements Runnable {
	private SaveWord sw;
	private NotifyWord nt;

	int time = 10000;

	private void loadProps() {
		this.time = Integer.parseInt(ReadProperties.getProperty("time"));
		if(this.time<10000) {
			this.time=10000;
		}
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
				System.gc();
				Thread.sleep(time);
				if(sw.checkIsNewFileName()) {
					System.out.println("new file");
					sw.setNewFileName();
					i=-1;size=0;
				}
				if (i >= size || i == -1) {
					//When learn a cycle of list : will load list voca again 
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
	private boolean prepareWord(Word word) {
		boolean prepareSuccess = true;
		if(StringUtils.isEmpty(word.getEng())) {
			prepareSuccess=false;
		}
		return prepareSuccess;
	}

}
