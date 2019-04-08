package demo;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class MenuDemo extends JFrame implements ActionListener {

	private JPanel redPanel, whitePanel, bluePanel;
	private boolean red, white, blue;

	public MenuDemo() {
		super("Comp240");
		setSize(800, 600);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new GridLayout(1, 3));

		redPanel = new JPanel();
		redPanel.setBackground(Color.GRAY);
		add(redPanel);

		bluePanel = new JPanel();
		bluePanel.setBackground(Color.GRAY);
		add(bluePanel);

		whitePanel = new JPanel();
		whitePanel.setBackground(Color.GRAY);
		add(whitePanel);

		JMenu colorMenu = new JMenu("Add Colors");
		JMenuItem redChoice = new JMenuItem("Red");
		JMenuItem whiteChoice = new JMenuItem("White");
		JMenuItem blueChoice = new JMenuItem("Blue");
		JMenuItem aboutChoice = new JMenuItem("About");
		JMenuItem exitChoice = new JMenuItem("Exit");

		colorMenu.add(redChoice);
		colorMenu.add(blueChoice);
		colorMenu.add(whiteChoice);

		redChoice.addActionListener(this);
		whiteChoice.addActionListener(this);
		blueChoice.addActionListener(this);

		colorMenu.addSeparator();
		colorMenu.add(aboutChoice);
		aboutChoice.addActionListener(this);
		colorMenu.add(exitChoice);
		exitChoice.addActionListener(this);
		exitChoice.addActionListener(this);

		JMenuBar bar = new JMenuBar();
		bar.add(colorMenu);
		setJMenuBar(bar);

	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void actionPerformed(ActionEvent e) {

		String buttonString = e.getActionCommand();
		String message = "Eggs are not suposed to be green!";
		String title = "Somesuch warning!";

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
		} else if (buttonString.equals("About")) {
			JOptionPane.showMessageDialog(this, message, title, JOptionPane.INFORMATION_MESSAGE);
		} else if (buttonString.equals("Exit")) {
			if (JOptionPane.showConfirmDialog(this, "Are you sure?", "Exit Dialog", JOptionPane.OK_CANCEL_OPTION)
				== JOptionPane.OK_OPTION){
				this.dispose();
				System.exit(0);
			};
		} else {
			System.out.println("Error!!!!");
		}

	}

	public static void main(String[] args) {
		MenuDemo gui = new MenuDemo();
		gui.setVisible(true);

	}

}
