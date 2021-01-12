package gameElements;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import playerInterface.Screen;
import utility.Resource;

public class ObstacleSettings {
	// declaration
	private List<Obstacle> obstacles;
	private Random random;
	
	private BufferedImage imageRock, imageBush;
	private Tiger mainCharacter;
	private Screen Screen;
	
	public ObstacleSettings(Tiger mainCharacter, Screen screen) {
		// creating new objects
		this.Screen = screen;
		this.mainCharacter = mainCharacter;
		obstacles = new ArrayList<Obstacle>();
		imageRock = Resource.getResourceImage("data/rock.png");
		imageBush = Resource.getResourceImage("data/bush.png");
		random = new Random();
		
		obstacles.add(getRandomObstacle()); // adds a random obstacle in the game window
	}
	
	public void update() {
		for(Obstacle o : obstacles) {
			o.update();
			if (o.isOver() && !o.isScoreGot()) {
				Screen.plusScore(20); // adds 20 points when the tiger successfully jumps over an obstacle
				o.setIsScoreGot(true);
			}
			if (o.getBound().intersects(mainCharacter.getBound())) {
				/** 
				 * If the tiger intersects with an obstacle,
				 * the tiger dies.
				 */ 
				mainCharacter.setAlive(false);
			}
		}
		
		Obstacle firstObstacle = obstacles.get(0); // assigns the first element in obstacle list as firstObstacle
		if(firstObstacle.isOutOfScreen()) {
			obstacles.remove(firstObstacle); // removes an obstacle when it is not visible in the screen
			obstacles.add(getRandomObstacle()); // adds a random obstacle
		}
	}
	
	public void draw(Graphics g) {
		for (Obstacle e : obstacles) {
			e.draw(g); // draws an obstacle for each element in enemies list
		}
	}
	
	public void reset() {
		obstacles.clear(); // clears all obstacle
		obstacles.add(getRandomObstacle()); // adds random obstacle in the game window
	}
	
	private Rock getRandomObstacle() {
		Rock rock;
		rock = new Rock(mainCharacter);
		rock.setX(600);
		if(random.nextBoolean()) {
			rock.setImage(imageRock);
		} else {
			rock.setImage(imageBush);
		}
		return rock;
	}
}