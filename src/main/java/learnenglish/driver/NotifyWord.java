package learnenglish.driver;

import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import learnenglish.model.Word;

public class NotifyWord {
	private Logger logger = LoggerFactory.getLogger(NotifyWord.class);
	public void displayNotify() {
		SystemTray tray = SystemTray.getSystemTray();
		Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
		TrayIcon trayIcon = new TrayIcon(image,"Traydemo");
		trayIcon.setImageAutoSize(true);
		logger.info("Notify");
		trayIcon.displayMessage("helloloo","day roi", MessageType.WARNING);
		logger.info("Get up notify");
		tray.remove(trayIcon);
	}
	
	public void displayNotify(Word word,int time) {
		MyTrayIcon trayIcon = new MyTrayIcon();
		logger.info("Notify");
		if(word.getPronun()==null) {
			word.setPronun("");
		}
		else {
			word.setPronun("/"+word.getPronun()+"/ : ");
		}
		trayIcon.displayMessage(word.getEng()+": " +word.getPronun()+word.getVn(), word.getExample(), MessageType.ERROR);
		logger.info("sleep notify---"+time);
		try {
			Thread.sleep(time);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		logger.info("Get up notify");
		trayIcon.remove();
	}
}
