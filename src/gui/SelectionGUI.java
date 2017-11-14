package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


import lifeform.*;
import environment.*;

import types.FireType;
import types.Type;

public class SelectionGUI extends JFrame {

Environment e;	
	
JPanel array = new JPanel();

JPanel attackPanel;
JPanel namePanel, namePanel2;
JPanel imagePanel;
JPanel imagePanel2;
// imagePanel = new JPanel();
JPanel panelArray = new JPanel();
JButton image1;

Font font = new Font("Courier", Font.BOLD,10);

public SelectionGUI() throws IOException {

	this.e = Environment.getEnvironment();


	namePanel=new JPanel();
	namePanel2=new JPanel();
	attackPanel=new JPanel();
	imagePanel=new JPanel();
	imagePanel2=new JPanel();
	setLayout(new BorderLayout());
	setPreferredSize(new Dimension(350, 190));
	panelArray.setLayout(new GridLayout(3,12, 5, 5));

	while(e.hasNextPokemon())
	{
		Pokemon p = e.nextPokemon();
		
		creatingList(p);
			
		panelArray.add(imagePanel);
		//image1.addActionListener(Pokemon);
		panelArray.add(namePanel);
		
		panelArray.add(attackPanel);
		add(panelArray);
	}

	pack();
	setVisible(true);
}

void creatingList(Pokemon pokemon) throws IOException {
	ImageIcon start = e.getPokemonImage(pokemon.getDescription());
	//ImageIcon imageCharmander = new ImageIcon(getClass().getResource("charmander.png"));
	
	imagePanel.setLayout(new GridLayout());
	JButton image1 = new JButton(start);
	imagePanel.add(image1);
	
	namePanel.setLayout(new GridLayout(1,3));
	JButton name1 = new JButton(pokemon.getDescription()+"\n"+Integer.toString(pokemon.getCurrentHelath())+"\n"+pokemon.getType().getDescription());
	name1.setFont(font);
	namePanel.add(name1);
	
	while(pokemon.hasNextPokemon())
	{
		attackPanel.setLayout(new GridLayout());
		JButton attack = new JButton(pokemon.nextPokemon().getDescription());
		attack.setFont(font);
		attackPanel.add(attack);
	}

}


public void actionPerformed(ActionEvent e)
{
	if(e.getSource().equals(image1))
	{
	
	
	}
	
	if(e.getSource().equals("blastoise"))
	{
	// do something
	}
	
	if(e.getSource().equals("cater"))
	{
	// do something
	}
}

}

