package LearnEnglish;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Gui extends Frame implements ActionListener {
	public Gui() {
		Button b = new Button("Stop learning!");
		
		b.setBounds(50, 50, 50, 50);
		add(b);
		b.addActionListener(this);
		setSize(100,100);
		setTitle("Learning english daily time!");
		setLayout(new FlowLayout());
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		System.exit(0);
	}
}
