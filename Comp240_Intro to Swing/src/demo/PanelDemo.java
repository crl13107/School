package demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelDemo {
	public static void main(String[] args) {

		JFrame window = new JFrame();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLayout(new GridLayout(1, 3));
		window.setSize(800, 800);

		JPanel bluePanel = new JPanel();
		JPanel redPanel = new JPanel();
		JPanel whitePanel = new JPanel();
		JButton button = new JButton("???");

		bluePanel.setBackground(Color.BLUE);
		redPanel.setBackground(Color.RED);
		whitePanel.setBackground(Color.WHITE);
		whitePanel.add(button);

		window.add(bluePanel, BorderLayout.EAST);
		window.add(redPanel, BorderLayout.WEST);
		window.add(whitePanel, BorderLayout.CENTER);
		window.setVisible(true);
	}

}
