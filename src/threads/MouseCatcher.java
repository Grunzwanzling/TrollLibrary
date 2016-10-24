/**
 * 
 */
package threads;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;

/**
 * @author Maximilian
 *
 */
public class MouseCatcher extends Thread {
	int x, y;
	boolean stop;
	Robot rob;

	/**
	 * Will hold the mouse on one specific position
	 * 
	 * @param x
	 * @param y
	 * @throws AWTException
	 */
	public MouseCatcher(int x, int y) throws AWTException {
		this.x = x;
		this.y = y;
		stop = false;
		rob = new Robot();
		start();
	}

	/**
	 * Will hold the mouse on the current position
	 * 
	 * @throws AWTException
	 */
	public MouseCatcher() throws AWTException {
		Point p = MouseInfo.getPointerInfo().getLocation();
		new MouseCatcher((int) p.getX(), (int) p.getY());
	}

	/**
	 * Set the mouse free
	 */
	public void abort() {
		stop = true;
	}

	public void run() {
		while (!stop) {

			rob.mouseMove(x, y);

		}
	}
}