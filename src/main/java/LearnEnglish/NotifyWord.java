package LearnEnglish;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

import org.apache.commons.lang3.StringUtils;

public class NotifyWord {
	public void displayNotify(Word word) {
		SystemTray tray = SystemTray.getSystemTray();
		Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
		TrayIcon trayIcon = new TrayIcon(image,"Traydemo");
		trayIcon.setImageAutoSize(true);
		trayIcon.setToolTip(word.getEng());
		try {
			tray.add(trayIcon);
		} catch (AWTException e) {
			e.printStackTrace();
		}
		if(StringUtils.isEmpty(word.getPronun())) {
			word.setPronun("");
		}
		trayIcon.displayMessage(word.getEng()+" : \\"+word.getPronun()+"\\ : "+word.getVn(), word.getExample(), MessageType.INFO);
	}
}
