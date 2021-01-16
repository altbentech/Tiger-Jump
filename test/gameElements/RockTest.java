package gameElements;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RockTest {

	@Test
	public void testDraw() {
		// Setup
		final Graphics g = null;

		// Run the test
		Rock rockUnderTest = null;
		rockUnderTest.draw(g);

		// Verify the results
	}

	@Test
	public void testGetBound() {
		// Setup
		final Rectangle expectedResult = new Rectangle(0, 0, 0, 0);

		// Run the test
		Rock rockUnderTest = null;
		final Rectangle result = rockUnderTest.getBound();

		// Verify the results
		assertEquals(expectedResult, result);
	}

	@Test
	public void testIsOutOfScreen() {
		// Setup

		// Run the test
		Obstacle rockUnderTest = null;
		final boolean result = rockUnderTest.isOutOfScreen();

		// Verify the results
		assertTrue(result);
	}

	@Test
	public void testIsOver() {
		// Setup

		// Run the test
		Obstacle rockUnderTest = null;
		final boolean result = rockUnderTest.isOver();

		// Verify the results
		assertTrue(result);
	}

	@Test
	public void testSetX() {
		// Setup

		// Run the test
		Rock rockUnderTest = null;
		rockUnderTest.setX(0);

		// Verify the results
	}

	@Test
	public void testSetY() {
		// Setup

		// Run the test
		Rock rockUnderTest = null;
		rockUnderTest.setY(0);

		// Verify the results
	}

	@Test
	public void testUpdate() {
		// Setup

		// Run the test
		Rock rockUnderTest = null;
		rockUnderTest.update();

		// Verify the results
	}
}
