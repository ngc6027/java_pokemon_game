package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import environment.Environment;
import lifeform.Pokemon;

public class BattleGUI extends JFrame implements ActionListener
{
	Environment e;
	JPanel mainPanel;

	public BattleGUI()
	{
		//setup
		super("Battle");
		this.e = Environment.getEnvironment();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
		//build guts
		guts();
	}
	
	void guts()
	{
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(Color.darkGray);
		mainPanel.setLayout(new GridLayout(3,2));
		this.add(mainPanel);
		
		//gridspot 0 0 = opposite player pokemon info
		//Pokemon pokemon  = e.getPlayer(1).getActivePokemon();
		
		//gridspot 0 1 = opposite pokemon picture
		//ImageIcon start = e.getPokemonImage(pokemonImage.getDescription());
		
		
		//gridspot 1 0 = player pokemon
		//gridspot 1 1 = player pokemon info
		//e.getPlayer(0).getActivePokemon();
		
		//gridspot 2 0 = blank spot that shows text when stuff happens
		//gridspot 2 1 = Menu options
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
