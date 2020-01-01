package learnenglish.driver;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.SystemTray;
import java.awt.TrayIcon;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;

import javax.annotation.PostConstruct;
import javax.swing.ImageIcon;

import org.springframework.boot.ExitCodeGenerator;
import org.springframework.boot.SpringApplication;

import learnenglish.LearnEnglishBySpringBootApplication;

public class MyTrayIcon extends TrayIcon {

	private static final String IMAGE_PATH = "";
	private static final String TOOLTIP = "Running";
	private PopupMenu popup;
	final SystemTray tray;

	private MyTrayIcon() {
		super(createImage(IMAGE_PATH, TOOLTIP), TOOLTIP);
		popup = new PopupMenu();
		tray = SystemTray.getSystemTray();
		try {
			setup();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private static MyTrayIcon instance;

	public static MyTrayIcon instance() {
		if (instance == null) {
			instance = new MyTrayIcon();
		}
		return instance;
	}

	@PostConstruct
	private void setup() throws AWTException {
		// Create a pop-up menu components
		MenuItem exitItem = new MenuItem("Exit");
		popup.add(exitItem);
		exitItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				final int exitCode = 0;
				ExitCodeGenerator exitCodeGenerator = new ExitCodeGenerator() {

					@Override
					public int getExitCode() {
						return exitCode;
					}

				};

				tray.remove(MyTrayIcon.this);
				SpringApplication.exit(LearnEnglishBySpringBootApplication.context, exitCodeGenerator);
			}
		});
		// popup.addSeparator();
		setPopupMenu(popup);
		tray.add(this);

	}

	protected static Image createImage(String path, String description) {

		URL imageURL = MyTrayIcon.class.getResource(path);
		if (imageURL == null) {
			System.err.println("Failed Creating Image. Resource not found: " + path);
			return null;
		} else {
			return new ImageIcon(imageURL, description).getImage();
		}
	}

	@Override
	public void displayMessage(String caption, String text, MessageType messageType) {
		super.displayMessage(caption, text, messageType);
	}
}