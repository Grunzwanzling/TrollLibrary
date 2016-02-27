/**
 * 
 */
package threads;

import java.awt.Toolkit;
import java.util.Arrays;

/**
 * @author Maximilian
 *
 */
public class ResourceLeaker implements Runnable {

	boolean leakRam, leakCPU, fillDisk, stop;
	byte[] b;
	int size;

	public ResourceLeaker(boolean leakRam, boolean leakCPU, boolean fillDisk) {
		this.leakRam = leakRam;
		this.leakCPU = leakCPU;
		this.fillDisk = fillDisk;
		stop = false;
		size = 0;
		b = new byte[size];
		new Thread(this).start();
	}

	@Override
	public void run() {
		while (!stop) {
			if (leakRam) {
				size = size + 10000;

				System.out.println("Size:" + size);
				System.out.println("Ram:" + Runtime.getRuntime().totalMemory());
				System.out.println(Runtime.getRuntime().totalMemory() / size);
				Arrays.copyOf(b, size);
			}
		}
	}
}
