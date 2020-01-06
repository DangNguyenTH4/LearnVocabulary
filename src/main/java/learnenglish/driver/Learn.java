package learnenglish.driver;

import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import learnenglish.LearnEnglishBySpringBootApplication;
import learnenglish.model.ListWord;
import learnenglish.model.Word;
import learnenglish.service.SaveWordService;

public class Learn implements Runnable {
	private Logger logger = LoggerFactory.getLogger(Learn.class);
	private SaveWordService sw;
	private NotifyWord nt;
	private Boolean continueLearn=true;
	
	int time = 10000;
	
	private void loadProps() {
		logger.info("Load props time");
		this.time = Integer.parseInt(ReadProperties.getProperty("time"));
		if(this.time<10000) {
			this.time=10000;
		}
	}

	public Learn() {
		sw = LearnEnglishBySpringBootApplication.context.getBean(SaveWordService.class); 
		nt = new NotifyWord();
		loadProps();
	}
	public Learn(Boolean continueLearn) {
		this.continueLearn = continueLearn;
		nt = new NotifyWord();
		loadProps();
	}

	@Override
	public void run() {
		int i = -1;
		int size = 0;
		ListWord lst = null;
		logger.info("Time: " + time);
		while (continueLearn) {
			System.out.println(continueLearn);

			try {
				System.gc();
//				Thread.sleep(time);
				String a = (sw==null)+"";
				logger.info(a);
				if(sw.checkIsChangeProperties(time)) {
					logger.info("new file");
					sw.setSaveWord();
					sw.setNewFileName();
					loadProps();
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
					nt.displayNotify((Word) lst.getLst().get(i),time);
				}
				i++;

			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	public void setContinue(boolean con) {
		this.continueLearn = con;
	}
}
