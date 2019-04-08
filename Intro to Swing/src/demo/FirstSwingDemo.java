package demo;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class FirstSwingDemo {

	public static final int SCREENWIDTH = 300;
	public static final int SCREENHEIGHT = 200;

	public static void main(String[] args) {
		JFrame window = new JFrame("comp 240");
		window.setSize(SCREENWIDTH, SCREENHEIGHT);

		window.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

		window.setLayout(new BorderLayout());

		window.setLayout(new GridLayout(2, 3));
		
		
		JButton button = new JButton("Click to End!");

		JButton b2 = new JButton("b2");
		JButton b3 = new JButton("b3, Center button");
		JButton b4 = new JButton("b4, l " + "hello");
		JButton b5 = new JButton("b5");

		button.setSize(10, 10);
		b2.setSize(1, 13);

		button.addActionListener(new ActionListener() { // Anonymous inner type

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		window.add(b2, BorderLayout.NORTH);
		window.add(button, BorderLayout.SOUTH);
		window.add(b3, BorderLayout.CENTER);
		window.add(b4, BorderLayout.EAST);
		window.add(b5, BorderLayout.WEST);

		window.setVisible(true);
	}

}
// event is
// event driven programming is
// firing an event
// synch verses ?