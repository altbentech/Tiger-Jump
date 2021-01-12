package gameElements;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;

import utility.Resource;

public class Rock extends Obstacle{
	
	private BufferedImage image;
	private int posX, posY;
	private Rectangle rect;
	private Tiger tiger;
	private boolean isScoreGot = false;
	
	
	public Rock(Tiger mainCharacter) {
		this.tiger  = mainCharacter;
		image = Resource.getResourceImage("data/rock.png");
		posX =  150; // x-position of the obstacle on the game screen
		posY = 70; // y-position of the obstacle on the game screen
		rect = new Rectangle();
		rect.intersects(rect); // checks if two object intersect with each other
	}
	
	public void update() {
		posX -= 2;
		rect.x = posX;
		rect.y = posY;
		rect.width = image.getWidth(); // gets the width of the rectangle minus 30 since the tiger's length is too long
		rect.height = image.getHeight();
	}
	
	@Override
	public Rectangle getBound() {
		return rect;
	}
	
	@Override
	public void draw(Graphics g) {
		g.drawImage(image, posX, posY, null);
	}
	
	public void setX(int x) {
		posX = x;
	}
	
	public void setY(int y) {
		posY = y;
	}
	
	public void setImage(BufferedImage image) {
		this.image = image;
	}
	
	@Override
	public boolean isOutOfScreen() {
		return (posX + image.getWidth() < 0);
	}
	
	@Override
	public boolean isOver() {
		return (tiger.getX() > posX);
	}
	
	@Override
	public boolean isScoreGot() {
		return isScoreGot;
	}
	
	@Override
	public void setIsScoreGot(boolean isScoreGot) {
		this.isScoreGot = isScoreGot;
	}
}
