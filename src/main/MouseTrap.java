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

	public MouseTrap() throws AWTException, InterruptedException {
		frame = new JFrame();
		frame.setBounds(500, 300, 200, 200);
		frame.setUndecorated(true);
		frame.setVisible(true);
		panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setBorder(BorderFactory.createLineBorder(Color.black));
		panel.setLayout(null);

		JLabel lblMouseTrap = new JLabel("Mouse Trap!");
		lblMouseTrap.setBounds(1, 11, 198, 37);
		lblMouseTrap.setHorizontalAlignment(SwingConstants.CENTER);
		lblMouseTrap.setFont(new Font("Tahoma", Font.BOLD, 30));
		panel.add(lblMouseTrap);

		JButton btnClose = new JButton("Close");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClose.setBounds(10, 158, 180, 31);
		btnClose.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(btnClose);
		frame.setResizable(false);

		Robot rob = new Robot();

		PointerInfo x = MouseInfo.getPointerInfo();
		Point y = x.getLocation();

		while (!(y.getX() > frame.getX()
				&& y.getX() < frame.getX() + frame.getWidth() && (y.getY() > frame
				.getY() && y.getY() < frame.getY() + frame.getHeight()))) {
			PointerInfo r = MouseInfo.getPointerInfo();
			y = r.getLocation();
		}

		btnClose.setVisible(false);
		lblMouseTrap.setText("Dumbass -.-");

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

	public static void main(String[] args) throws AWTException,
			InterruptedException {
		new MouseTrap();

	}
}
