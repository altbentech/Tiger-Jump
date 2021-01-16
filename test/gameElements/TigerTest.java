package gameElements;

import org.junit.Test;

import java.awt.*;

import static org.junit.Assert.assertEquals;

public class TigerTest {

	@Test
	public void testDraw() {
		// Setup
		final Graphics g = null;

		// Run the test
		Tiger tigerUnderTest = new Tiger();
		tigerUnderTest.draw(g);

		// Verify the results
	}

	@Test
	public void testGetBound() {
		// Setup
		final Rectangle expectedResult = new Rectangle(0, 0, 0, 0);

		// Run the test
		Tiger tigerUnderTest = new Tiger();
		final Rectangle result = tigerUnderTest.getBound();

		// Verify the results
		assertEquals(expectedResult, result);
	}

	@Test
	public void testJump() {
		// Setup

		// Run the test
		Tiger tigerUnderTest = new Tiger();
		tigerUnderTest.jump();

		// Verify the results
	}

	@Test
	public void testUpdate() {
		// Setup

		// Run the test
		Tiger tigerUnderTest = new Tiger();
		tigerUnderTest.update();

		// Verify the results
	}
}
