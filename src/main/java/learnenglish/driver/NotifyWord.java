package learnenglish.driver;

import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.TrayIcon.MessageType;

public class NotifyWord {
	public void displayNotify() {
		SystemTray tray = SystemTray.getSystemTray();
		Image image = Toolkit.getDefaultToolkit().createImage("icon.png");
		TrayIcon trayIcon = new TrayIcon(image,"Traydemo");
		trayIcon.setImageAutoSize(true);
		System.out.println("Notify");
		trayIcon.displayMessage("helloloo","day roi", MessageType.WARNING);
		System.out.println("Get up notify");
		tray.remove(trayIcon);
	}
	
//	public void displayNotify(Word word,int time) {
//		TrayIcon trayIcon = MyTrayIcon.instance();
//		System.out.println("Notify");
//		trayIcon.displayMessage(word.getEng()+" : \\"+word.getPronun()+"\\ : "+word.getVn(), word.getExample(), MessageType.ERROR);
//		System.out.println("sleep notify");
//		try {
//			Thread.sleep(time);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Get up notify");
//	}
}
