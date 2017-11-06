package UserInterface;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.sun.javafx.tk.Toolkit;

import GameManagement.GameManager;

public class GamePanel extends JPanel {

	GameManager gameManager;
	
	
	/**
	 * Create the panel.
	 * @throws Exception 
	 */
	int x;
	public GamePanel() throws Exception {
		this.gameManager = new GameManager();	
		x = gameManager.gameEngine.round.player1.pos;
		this.setVisible(true);
	}
	
	@Override
	
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
        	final BufferedImage background = ImageIO.read(new File("C:\\Users\\Mert\\git\\2J-BubblePopper\\background.png"));
        	g.drawImage(background, 250, 70, this);
			//final BufferedImage image = ImageIO.read(new File("C:\\Users\\Mert\\git\\2J-BubblePopper\\Paper_Ninja.png"));
			g.drawImage(gameManager.gameEngine.round.player1.image, x, 290, this);
            repaint();
           
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // if(gameManager.gameEngine.round.player1.image != null){
      //  }
    }

}
