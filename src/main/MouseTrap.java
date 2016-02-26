/**
 * 
 */
package main;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Font;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

/**
 * @author Maximilian
 *
 */
public class MouseTrap {

	JFrame frame;
	JPanel panel;

	/**
	 * Show a unsuspicious frame that will trap the mouse and won't let it go xD
	 * 
	 * @param x
	 *            The X position of the frame
	 * @param y
	 *            The Y position of the frame
	 * @param length
	 *            The length of the frame
	 * @param height
	 *            The height of the frame
	 * @param title
	 *            The text to display on the frame
	 * @param buttonText
	 *            The text to display on the button
	 * @param textAfterwards
	 *            The text to display on the frame after the mouse is captured
	 * @throws AWTException
	 * @throws InterruptedException
	 */
	public void showMouseTrap(int x, int y, int length, int height,
			String title, String buttonText, String textAfterwards)
			throws AWTException, InterruptedException {
		frame = new JFrame();
		frame.setBounds(x, y, length, height);
		frame.setUndecorated(true);
		frame.setVisible(true);
		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setLayout(null);

		JLabel lblMouseTrap = new JLabel(title);
		lblMouseTrap.setBounds(1, 11, 198, 37);
		lblMouseTrap.setHorizontalAlignment(SwingConstants.CENTER);
		lblMouseTrap.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblMouseTrap);

		JButton btnClose = new JButton(buttonText);
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClose.setBounds(10, 158, 180, 31);
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnClose);
		frame.setResizable(false);

		Robot rob = new Robot();

		PointerInfo pi = MouseInfo.getPointerInfo();
		Point p = pi.getLocation();

		while (!(p.getX() > frame.getX()
				&& p.getX() < frame.getX() + frame.getWidth() && (p.getY() > frame
				.getY() && p.getY() < frame.getY() + frame.getHeight()))) {
			pi = MouseInfo.getPointerInfo();
			p = pi.getLocation();
		}

		btnClose.setVisible(false);
		lblMouseTrap.setText(textAfterwards);

		while (true) {
			PointerInfo a = MouseInfo.getPointerInfo();
			Point b = a.getLocation();
			if (b.getX() < frame.getX()) {
				rob.mouseMove(frame.getX(), (int) b.getY());
			}
			if (b.getX() > frame.getX() + frame.getWidth()) {
				rob.mouseMove(frame.getX() + frame.getWidth(), (int) b.getY());
			}

			if (b.getY() < frame.getY()) {
				rob.mouseMove((int) b.getX(), frame.getY());
			}
			if (b.getY() > frame.getY() + frame.getHeight()) {
				rob.mouseMove((int) b.getX(), frame.getY() + frame.getHeight());
			}

		}

	}

	public static void stickMouseTo(int x, int y) {

		
		
		
	}

	public static void main(String[] args) throws AWTException,
			InterruptedException {
		MouseTrap trap = new MouseTrap();
		trap.showMouseTrap(300, 300, 200, 200, "MouseTrap", "Close",
				"Dumbass -.-");

	}
}
