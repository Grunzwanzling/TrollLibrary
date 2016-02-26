/**
 * 
 */
package threads;

/**
 * @author Maximilian
 *
 */
class MouseCatcher extends Thread {
	String text;

	public TextThread(String text) {
		this.text = text;
	}

	public void run() {
		for (int i = 0; i < 10; i++) {
			try {
				sleep((int) (Math.random() * 1000));
			} catch (InterruptedException e) {
			}
			System.out.println(text);
		}
	}
}