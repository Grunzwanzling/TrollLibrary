package threads;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class FreezeScreen {
	JFrame frame;
	JPanel label;

	public FreezeScreen() {
		frame = new JFrame();
		label = new JPanel();
		frame.setLayout(null);
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);

		label.setOpaque(true);
		label.setVisible(true);
		frame.add(label);

	}

	public void setColor(Color c) {
		label.setBackground(c);
		frame.setVisible(true);
		frame.repaint();
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		label.setBounds(0, 0, frame.getWidth(), frame.getHeight());
	}

	public static void main(String[] args) throws InterruptedException {
		FreezeScreen s = new FreezeScreen();
		Thread.sleep(1000);
		 s.setColor(Color.RED);
	}
}