package UserInterface;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import GameManagement.GameManager;

public class GamePanel extends JPanel {

	GameManager gameManager;
	
	/**
	 * Create the panel.
	 */
	
	public GamePanel() {
		gameManager = new GameManager();
		this.setVisible(true);
	}
	
	@Override
	public void paintComponent(Graphics g) {
        super.paintComponent(g);
        try {
			final BufferedImage image = ImageIO.read(new File("/home/orkalp/git/2J-BubblePopper/Paper_Ninja.png"));
            g.drawImage(image, 400, 440, this);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
       // if(gameManager.gameEngine.round.player1.image != null){
      //  }
    }

}
