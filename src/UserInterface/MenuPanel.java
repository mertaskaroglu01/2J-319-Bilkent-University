package UserInterface;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import GameManagement.GameManager;

public class MenuPanel extends JPanel {

	JButton play;
	
	MenuPanel() {
		setLayout(null);
        setLocation(0, 0);
        setVisible(true);
        
        play = new JButton("Play");
        play.setSize(300, 30);
        play.setLocation(50, 360);
        play.setHorizontalAlignment(SwingConstants.CENTER);
        play.addMouseListener(Menu.MenuActionListener);
        add(play);
	}
	
	
	
	
}
