package gameElements;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import playerInterface.Screen;

import static playerInterface.Screen.GROUND_Y;
import utility.Resource;


public class Ground {
	
	private List<ImageLand> listImage;
	private BufferedImage imageLand1, imageLand2, imageLand3;
	private Random random;
	
	public Ground(Screen game) {
		random = new Random();
		imageLand1 = Resource.getResourceImage("data/land1.png");
		imageLand2 = Resource.getResourceImage("data/land2.png");
		imageLand3 = Resource.getResourceImage("data/land3.png");
		listImage = new ArrayList<ImageLand>();
		int numberOfLandTitle = 600 / imageLand1.getWidth() + 2; // gets the width of the image added by two and divides it to the size of the game window
		
		for(int i = 0; i < numberOfLandTitle; i++) {
			// if i is less than the value of numberOfLndTitle
			// execute code
			ImageLand imageLand = new ImageLand();
			imageLand.posX = (int) (i * imageLand1.getWidth());
			imageLand.image = getImageLand();
			listImage.add(imageLand);
		}
	}
	
	public void update() {
		for(ImageLand imageLand : listImage) {
			imageLand.posX -= 2; // movement of the land
		}
		ImageLand firstElement = listImage.get(0);
		if(listImage.get(0).posX + imageLand1.getWidth() < 0) {
			// to make the land appear without end
			firstElement.posX = listImage.get(listImage.size() -1).posX + imageLand1.getWidth();
			listImage.add(listImage.get(0)); // adds an image of the ground
			listImage.remove(0); // removes the first element in the list
		}
	}
	
	public void draw(Graphics g) {
		for(ImageLand imageLand : listImage) {
			g.drawImage(imageLand.image, imageLand.posX, (int) GROUND_Y - 20, null); //draws the ground in the specified position in the coordinate
		}
	}
	
	private BufferedImage getImageLand () {
		int i = random.nextInt(10); // generates a random number from 0 and 9
		switch(i) {
		case 0 : return imageLand1; // returns imageLand1 if 0 is the number generated
		case 1 : return imageLand3; // returns imageLand3 if 1 is the number generated
		default : return imageLand2; // returns imageLand2 if any number other than 0 and 1 is the number generated
		}
	}
	
	private class ImageLand{
		int posX;
		BufferedImage image;
	}

}
