package gameElements;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import utility.Animation;
import utility.Resource;

import static playerInterface.Screen.GRAVITY;
import static playerInterface.Screen.GROUND_Y;

public class Tiger {
	private float x = 0;
	private float y = 0;
	private float speedY = 0;
	private Animation tigerRun;
	private Rectangle rect;
	private boolean isAlive = true;
	
	public Tiger() {
		tigerRun = new Animation(200);
		tigerRun.addFrame(Resource.getResourceImage("data/main-character1.png"));
		tigerRun.addFrame(Resource.getResourceImage("data/main-character2.png"));
		//tigerRun.addFrame(Resource.getResourceImage("data/main-character3.png"));

		rect = new Rectangle();
	}
	
	public void update() {
		tigerRun.update();
		if (y >= GROUND_Y - tigerRun.getFrame().getHeight()) {
			// block of code to stop the object from falling below the ground
			speedY = 0;
			y = GROUND_Y - tigerRun.getFrame().getHeight();
		}
		else {
			// if the tiger is not yet on the ground
			// tiger will continue to fall
			speedY += GRAVITY;
			y += speedY;
		}
		rect.x = (int) x; // x-coordinate of the rectangle
		rect.y = (int) y; // x-coordinate of the rectangle
		rect.width = (tigerRun.getFrame().getWidth()); // gets the width of the tiger's frame
		rect.height = tigerRun.getFrame().getHeight(); // gets the height of the tiger's frame
	}
	
	public Rectangle getBound() {
		return rect;
	}
	
	public void draw(Graphics g) {
		g.setColor(Color.black);
		g.drawImage(tigerRun.getFrame(), (int) x, (int) y, null);
	}
	
	public void jump() {
		// block of code for jumping
		if (speedY == 0) {
			speedY += -4 ; // allows the tiger to jump by deducting the gravity by 4;
			y += speedY; //after moving up, the tiger will move down again
		}
		else {
			y += speedY; // if the tiger is not on the ground it can't jump
		}
	}
	
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getSpeedY() {
		return speedY;
	}
	public void setSpeedY(float speedY) {
		this.speedY = speedY;
	}
	
	public void setAlive(boolean alive) {
		isAlive = alive;
	}
	
	public boolean getAlive() {
		return isAlive;
	}
 
}
