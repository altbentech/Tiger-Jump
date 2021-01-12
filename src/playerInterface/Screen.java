package playerInterface;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JPanel;

import gameElements.Rock;
import gameElements.Clouds;
import gameElements.ObstacleSettings;
import gameElements.Ground;
import gameElements.Tiger;
import utility.Resource;



public class Screen extends JPanel implements Runnable, KeyListener{
	public static final int GAME_FIRST_STATE = 0;
	public static final int GAME_PLAY_STATE = 1;
	public static final int GAME_OVER_STATE = 2;
	public static final float GRAVITY = 0.1f;
	public static final float GROUND_Y = 110; // by pixel
	
	private int gameState = GAME_FIRST_STATE;
	
	private Tiger mainCharacter;
	private Thread thread;
	private Ground ground;
	private Clouds clouds;
	private ObstacleSettings obstacleSettings;
	private int score;
	
	private BufferedImage imageGameOverText;
	private AudioClip scoreUpSound;
	
	public Screen() {
		thread = new Thread(this);
		mainCharacter = new Tiger();
		mainCharacter.setX(50); // x-position of the tiger on the screen
		mainCharacter.setY(60); // y-position of the tiger on the screen
		ground = new Ground(this);
		clouds = new Clouds();
		obstacleSettings = new ObstacleSettings(mainCharacter, this);
		imageGameOverText = Resource.getResourceImage("data/gameover_text.png");
		try {
			scoreUpSound = Applet.newAudioClip(new URL("file","","data/scoreup.wav"));
		} catch (MalformedURLException e) {
			e.printStackTrace(); // used to deal with errors and exceptions 
		}
	}
	
	public void startGame() {
		thread.start(); // method that starts the game
	}

	@Override
	public void run() {
		while(true) {
			try {
				update();
				repaint(); // calls the paint method again
				thread.sleep(4); // speed of the game
			} catch (InterruptedException e) {
				e.printStackTrace(); // error catcher
			}
		}
	}
	
	public void update() {
		switch(gameState) {
			case GAME_PLAY_STATE:
				mainCharacter.update(); // creates a new tiger
				ground.update(); // creates a new ground
				clouds.update(); // creates new clouds
				obstacleSettings.update(); // creates new obstacles
				if (!mainCharacter.getAlive()){
					// checks if the character is still alive or not
					// game changes to game over state if character bumped into an obstacle
					gameState = GAME_OVER_STATE;
				}
				break;
		}
		
	}
	
	public void plusScore(int score) {
		this.score += score; // adds a score whenever the character successfully jumps an obstacle
		scoreUpSound.play(); // beep to notify a score gained
	}
	
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.decode("#A5D5E3")); // sets the background color
		g.fillRect(0, 0, getWidth(), getHeight()); // fills the specified rectangle
		
		
		switch(gameState) {
		case GAME_FIRST_STATE:
			mainCharacter.draw(g); // at the start of the game only the tiger is visible
			break;
		case GAME_PLAY_STATE:
			/** 
			 * This is the game proper state other elements aside
			 * from the tiger are also present.
			*/
			clouds.draw(g); // displays clouds
			ground.draw(g); // displays ground
			mainCharacter.draw(g); // displays tiger
			obstacleSettings.draw(g); // displays the cactus
			g.setFont(new Font("Courier", Font.BOLD, 15));
			g.drawString("SCORE " + String.valueOf(score), 500, 20); // displays the score in the specified coordinate
			break;
		case GAME_OVER_STATE:
			// this is the game over state
			// a Game Over Text is displayed
			clouds.draw(g);
			ground.draw(g);
			mainCharacter.draw(g);
			obstacleSettings.draw(g);
			g.drawImage(imageGameOverText, 200, 50, null); // displays the Game Over Text
			score = 0;
			break;
		}	
		
	}
	
	private void resetGame() {
		// method if the dinosaur bumps into a cactus
		mainCharacter.setAlive(true); // resurrects the dinosaur
		mainCharacter.setX(50); // x-position of the dinosaur when game resets
		mainCharacter.setY(60); // y-position of the dinosaur when game resets
		obstacleSettings.reset(); // resets all cactus in the game
	}

	@Override
	public void keyTyped(KeyEvent e) {
	
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(gameState == GAME_PLAY_STATE) {
			mainCharacter.jump(); // allows the dinosaur to jump when in game play state only
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		switch(e.getKeyCode()) {
			case KeyEvent.VK_SPACE:
				if (gameState == GAME_FIRST_STATE) {
					gameState = GAME_PLAY_STATE; // when space key is pressed state changes from GAME_FIRST_STATE to GAME_PLAY_STATE
				} else if (gameState == GAME_PLAY_STATE) {
					mainCharacter.jump(); // when space key is pressed during the game proper state the dinosaur jumps
				} else if (gameState == GAME_OVER_STATE) {
					resetGame(); // if the space key is pressed during game over state the game resets
					gameState = GAME_PLAY_STATE; // game reverts to the game proper state
				}
				break;
		}
	}
	
}
