package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.*;
import environment.*;

public class ConfirmGUI extends JFrame
{
	JPanel mainPanel;
	JPanel playerOne;
	JPanel playerTwo;
	JPanel review;
	Environment e;
	
	public ConfirmGUI()
	{
		//set this frame up and call to build the main guts
		super("Please Confirm");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		buildGuts();
	}
	
	void buildGuts()
	{
		mainPanel = new JPanel(new BorderLayout());
		this.add(mainPanel);
		mainPanel.setBackground(Color.gray);
		
		
		review = new JPanel(new GridLayout(1,2));
		mainPanel.add(review,BorderLayout.CENTER);
		
		JButton ok = new JButton("This looks Okay.");
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
		JPanel pokemon = new JPanel(new GridLayout(3,1,2,2));
		playerOne.add(pokemon);
		
		JButton p1 = new JButton();
		//p1.setText(e.getPlayer(0).getPokemon(0).getDescription());
		p1.setText("Charzard");
		pokemon.add(p1);
		JButton p2 = new JButton();
		//p2.setText(e.getPlayer(0).getPokemon(1).getDescription());
		p2.setText("Wartortle");
		pokemon.add(p2);
		JButton p3 = new JButton();
		//p3.setText(e.getPlayer(0).getPokemon(2).getDescription());
		p3.setText("Vulpix");
		pokemon.add(p3);
		
	}
	

	void playerTwoPanel()
	{
		JButton name1 = new JButton("PLAYER TWO"); 
		playerTwo.add(name1);
		JPanel pokemon = new JPanel(new GridLayout(3,1,2,2));
		playerTwo.add(pokemon);
		
		
		JButton p1 = new JButton();
		//p1.setText(e.getPlayer(1).getPokemon(0).getDescription());
		p1.setText("Blastoise");
		pokemon.add(p1);
		JButton p2 = new JButton();
		//p2.setText(e.getPlayer(1).getPokemon(1).getDescription());
		p2.setText("Charmeleon");
		pokemon.add(p2);
		JButton p3 = new JButton();
		//p3.setText(e.getPlayer(1).getPokemon(2).getDescription());
		p3.setText("Venusaur");
		pokemon.add(p3);
	}
	
	
	
}
