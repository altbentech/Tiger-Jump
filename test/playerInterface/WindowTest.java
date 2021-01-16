package playerInterface;

import org.junit.Test;

public class WindowTest {

	@Test
	public void testMain() {
		// Setup

		// Run the test
		Window.main(new String[]{"value"});

		// Verify the results
	}

	@Test
	public void testStartGame() {
		// Setup

		// Run the test
		Window windowUnderTest = new Window();
		windowUnderTest.startGame();

		// Verify the results
	}
}
