package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SelectionGUI extends JFrame {

	JPanel array = new JPanel();

	JPanel attackPanel;
	JPanel namePanel, namePanel2;
	JPanel imagePanel;
	JPanel imagePanel2;
	
	// imagePanel = new JPanel();
	JPanel panelArray = new JPanel();

	Font font = new Font("Courier", Font.BOLD,12);

	public SelectionGUI() {

		namePanel=new JPanel();
		namePanel2=new JPanel();
		attackPanel=new JPanel();
		imagePanel=new JPanel();
		imagePanel2=new JPanel();
		
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(350, 190));
		panelArray.setLayout(new GridLayout(3,12, 5, 5));

		for (int i = 0; i < 11; i++) {
			creatingList();
			panelArray.add(imagePanel);

			panelArray.add(namePanel);

			panelArray.add(attackPanel);

			add(panelArray);
		}

		pack();
		setVisible(true);
	}

	void creatingList() {
		ImageIcon start = new ImageIcon(getClass().getResource("ditto.png"));
		ImageIcon imageCharmander = new ImageIcon(getClass().getResource("charmander.png"));

		imagePanel.setLayout(new GridLayout());
		JButton image1 = new JButton(start);
		imagePanel.add(image1);

		namePanel.setLayout(new GridLayout(3, 1));
		JButton name1 = new JButton("Ditto");
		name1.setFont(font);
		namePanel.add(name1);

		JButton name2 = new JButton("100/100");
		name1.setFont(font);
		namePanel.add(name2);

		JButton name3 = new JButton("Fire");
		name1.setFont(font);
		namePanel.add(name3);

		attackPanel.setLayout(new GridLayout(2, 2));
		JButton attack1 = new JButton("Nothing");
		attack1.setFont(font);
		attackPanel.add(attack1);

		JButton attack2 = new JButton("Cancer");
		attack2.setFont(font);
		attackPanel.add(attack2);

		JButton attack3 = new JButton("Something");
		attack3.setFont(font);
		attackPanel.add(attack3);

		JButton attack4 = new JButton("tacoS");
		attack4.setFont(font);
		attackPanel.add(attack4);

	}

}
