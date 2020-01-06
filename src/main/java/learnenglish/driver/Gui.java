package learnenglish.driver;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Label;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Gui extends Frame implements ActionListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Logger logger = LoggerFactory.getLogger(Gui.class);
	public Gui() {
		logger.info("Start Gui---------:");
		Button b = new Button("Stop learning!");
		b.setBounds(100, 100, 100, 100);
		b.setLocation(250,250);
//		add(b);
		Panel p = new Panel();
		p.add(b);
		add(p);
		
		
		
		add(createLable());
		
//		add(engLb);
		
		b.addActionListener(this);
		setSize(200,200);
		setTitle("Learning english daily time!");
		setLayout(new FlowLayout());
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
	
	private Panel createLable() {
		Panel p = new Panel();
		Label eng = new Label("English");
		p.add(eng);
		TextField ta = new TextField();
		ta.setSize(200, HEIGHT);
		p.add(ta);
		
		
		p.setLocation(0, 0);
		
		return p;
		
	}
}
