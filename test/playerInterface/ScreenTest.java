package playerInterface;

import org.junit.Test;

import java.awt.*;
import java.awt.event.KeyEvent;

public class ScreenTest {
	private Screen screenUnderTest;

	@Test
	public void testKeyPressed() {
		// Setup
		final KeyEvent e = new KeyEvent(null, 0, 0L, 0, 0, 'a');

		// Run the test
		Screen screenUnderTest = new Screen();
		screenUnderTest.keyPressed(e);

		// Verify the results
	}

	@Test
	public void testKeyReleased() {
		// Setup
		final KeyEvent e = new KeyEvent(null, 0, 0L, 0, 0, 'a');

		// Run the test
		Screen screenUnderTest = new Screen();
		screenUnderTest.keyReleased(e);

		// Verify the results
	}

	@Test
	public void testKeyTyped() {
		// Setup
		final KeyEvent e = new KeyEvent(null, 0, 0L, 0, 0, 'a');

		// Run the test
		Screen screenUnderTest = new Screen();
		screenUnderTest.keyTyped(e);

		// Verify the results
	}

	@Test
	public void testPaint() {
		// Setup
		final Graphics g = null;

		// Run the test
		Screen screenUnderTest = new Screen();
		screenUnderTest.paint(g);

		// Verify the results
	}

	@Test
	public void testPlusScore() {
		// Setup

		// Run the test
		Screen screenUnderTest = new Screen();
		screenUnderTest.plusScore(0);

		// Verify the results
	}

	@Test
	public void testRun() {
		// Setup

		// Run the test
		screenUnderTest.run();

		// Verify the results
	}

	@Test
	public void testStartGame() {
		// Setup

		// Run the test
		screenUnderTest.startGame();

		// Verify the results
	}

	@Test
	public void testUpdate() {
		// Setup

		// Run the test
		screenUnderTest.update();

		// Verify the results
	}
}
