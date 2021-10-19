package playerInterface;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Window extends JFrame{
	
	private Screen Screen;
	
	public Window() {
		super("Tiger Jump"); // displays the title of the window
		setSize(600, 155); // sets the size of the window
		setResizable(false); // makes the window unresizable
		setLocation(400, 200); // set the position of the window in the player's monitor
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // to exit the code when the window is closed
		Screen = new Screen();
		add(Screen);
		addKeyListener(Screen); // to control the game using keys
	}
	
	public void startGame() {
		Screen.startGame();
	}
	
	public static void main(String args[]) {
		Window gw = new Window();
		gw.setVisible(true); // allows the window to be visible in the screen
		gw.startGame(); // start of the game
	}
	
	
}

//check
