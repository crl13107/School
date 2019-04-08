package demo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelDemoImproved extends JFrame implements ActionListener {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel bluePanel, redPanel, whitePanel;
	private boolean red, white, blue;

	public PanelDemoImproved() {
		super("Comp240");
		setSize(800, 600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());

		JPanel biggerPanel = new JPanel();
		biggerPanel.setLayout(new GridLayout(1, 3));

		bluePanel = new JPanel();
		whitePanel = new JPanel();
		redPanel = new JPanel();

		bluePanel.setBackground(Color.GRAY);
		whitePanel.setBackground(Color.GRAY);
		redPanel.setBackground(Color.GRAY);

		biggerPanel.add(redPanel);
		biggerPanel.add(whitePanel);
		biggerPanel.add(bluePanel);

		add(biggerPanel, BorderLayout.CENTER);

		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(Color.GRAY);

		buttonPanel.setLayout(new FlowLayout());

		JButton redButton = new JButton("Red");
		JButton whiteButton = new JButton("White");
		JButton blueButton = new JButton("Blue");

		redButton.setBackground(Color.RED);
		blueButton.setBackground(Color.BLUE);
		whiteButton.setBackground(Color.WHITE);

		buttonPanel.add(redButton);
		buttonPanel.add(whiteButton);
		buttonPanel.add(blueButton);

		redButton.addActionListener(this);
		whiteButton.addActionListener(this);
		blueButton.addActionListener(this);
		add(buttonPanel, BorderLayout.SOUTH);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String buttonString = e.getActionCommand();

		if (buttonString.equals("Red")) {
			if (red)
				redPanel.setBackground(Color.GRAY);
			else
				redPanel.setBackground(Color.RED);
			red = !red;

		} else if (buttonString.equals("White")) {
			if (white)
				whitePanel.setBackground(Color.GRAY);
			else
				whitePanel.setBackground(Color.WHITE);
			white = !white;
		} else if (buttonString.equals("Blue")) {
			if (blue)
				bluePanel.setBackground(Color.GRAY);
			else
				bluePanel.setBackground(Color.BLUE);
			blue = !blue;

		} else {
			System.out.println("Error!!!!");
		}

	}

	public static void main(String[] args) {
		PanelDemoImproved gui = new PanelDemoImproved();
		gui.setVisible(true);

	}

}
