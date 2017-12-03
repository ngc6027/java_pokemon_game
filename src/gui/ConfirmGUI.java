package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;
import environment.*;

import lifeform.*;

public class ConfirmGUI extends JFrame implements ActionListener
{
	JPanel mainPanel;
	JPanel playerOne;
	JPanel playerTwo;
	JPanel review;
	JButton ok;
	Environment e;
	
	public ConfirmGUI()
	{
		//set this frame up and call to build the main guts
		super("Please Confirm");
		this.e = Environment.getEnvironment();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		buildGuts();
	}
	
	void buildGuts()
	{
		mainPanel = new JPanel(new BorderLayout());
		this.add(mainPanel);
		mainPanel.setBackground(Color.darkGray);
		
		review = new JPanel(new GridLayout(1,2));
		mainPanel.add(review,BorderLayout.CENTER);
		
		ok = new JButton("This looks okay.");
		ok.addActionListener(this);
		mainPanel.add(ok,BorderLayout.SOUTH);
		
		playerOne = new JPanel(new GridLayout(2,1));
		playerTwo = new JPanel(new GridLayout(2,1));
		playerOne.setBackground(Color.darkGray);
		playerTwo.setBackground(Color.darkGray);
		review.add(playerOne);
		review.add(playerTwo);
		
		playerOnePanel();
		playerTwoPanel();
		
	}
	
	//can build these in half the time later by calling player number but for now its whatever.
	//also gonna modify a bunch of this later anyway.
	
	void playerOnePanel()
	{	
		JButton name1 = new JButton("PLAYER ONE"); 
		playerOne.add(name1);
		
		////testing the switch away from buttons
		//JPanel nameone = new JPanel();
		//JLabel name1 = new JLabel("PLAYER ONE");
		//nameone.add(name1);
		//playerOne.add(nameone);
		
		JPanel pokemon = new JPanel(new GridLayout(3,1,2,2));
		pokemon.setBackground(Color.blue);
		playerOne.add(pokemon);
		
		JButton p1 = new JButton();
		
		Player p = e.getPlayer(0);
		Pokemon poke = p.getPokemon(0);
		poke.getDescription();
		
		p1.setText(e.getPlayer(0).getPokemon(0).getDescription());
		//p1.setText("Charzard");
		pokemon.add(p1);
		JButton p2 = new JButton();
		p2.setText(e.getPlayer(0).getPokemon(1).getDescription());
		//p2.setText("Wartortle");
		pokemon.add(p2);
		JButton p3 = new JButton();
		p3.setText(e.getPlayer(0).getPokemon(2).getDescription());
		//p3.setText("Vulpix");
		pokemon.add(p3);	
	}
	

	void playerTwoPanel()
	{
		JButton name1 = new JButton("PLAYER TWO"); 
		playerTwo.add(name1);
		JPanel pokemon = new JPanel(new GridLayout(3,1,2,2));
		pokemon.setBackground(Color.red);
		playerTwo.add(pokemon);
		
		JButton p1 = new JButton();
		p1.setText(e.getPlayer(1).getPokemon(0).getDescription());
		//p1.setText("Blastoise");
		pokemon.add(p1);
		JButton p2 = new JButton();
		p2.setText(e.getPlayer(1).getPokemon(1).getDescription());
		//p2.setText("Charmeleon");
		pokemon.add(p2);
		JButton p3 = new JButton();
		p3.setText(e.getPlayer(1).getPokemon(2).getDescription());
		//p3.setText("Venusaur");
		pokemon.add(p3);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
			if(e.getSource() == ok)
			{
				setVisible(false);
				//open up the final screen for the battle 
				try
				{	
					
					new WindowBuilderBattleGui(0);
					new WindowBuilderBattleGui(1);
				} catch (IOException e1)
				{
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
	}
	
}
