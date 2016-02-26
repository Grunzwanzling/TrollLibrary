/**
 * 
 */
package threads;

import java.awt.AWTException;
import java.awt.Robot;

/**
 * @author Maximilian
 *
 */
public class MouseCatcher extends Thread {
	int x, y, speed = 1;
	boolean stop;
	Robot rob;

	public MouseCatcher(int x, int y) throws AWTException {
		this.x = x;
		this.y = y;
		stop = false;
		rob = new Robot();
		start();
	}

	public void abort() {
		stop = true;
	}

	public void run() {
		while (!stop) {

			rob.mouseMove(x, y);

		}
	}
}