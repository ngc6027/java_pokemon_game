package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import commands.*;
import lifeform.*;
import environment.*;
import gameplay.Observer;

public class SelectionGUI extends JFrame implements ActionListener, Observer
{

Environment e;	
JPanel mainPanel;
JPanel attackPanel;
JPanel namePanel;
JPanel imagePanel;
JPanel pokemonPanel;
JButton images[];
int pokemonCount;
JPanel panelArray; 
JPanel turnDisplay;
JButton turnButton;
private int turn;
String buttonText;
private int pokemonSelectLimit;

RegisterCommand register;
SelectPokemonCommand select;

Font font = new Font("Courier", Font.BOLD,10);

public SelectionGUI() throws IOException 
{
	//set the frame
	super("Selection Screen");
	setVisible(true);
	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	setPreferredSize(new Dimension(900, 600));
	//setSize(900,600);
	
	//set observer
	register = new RegisterCommand();
	register.setObserver(this);
	register.execute();
	
	//
	select = new SelectPokemonCommand();
	
	//set pokemon selected counter
	pokemonSelectLimit = 0;
	
	//get an instance of environment
	this.e = Environment.getEnvironment();
	
	//create the main drawing panel and add it
	mainPanel = new JPanel();
	mainPanel.setLayout(new BorderLayout());
	this.add(mainPanel);
	
	
	//turn section
	turn = this.getTurn();
	System.out.println("Starting Turn: " +turn);
	
	turnDisplay = new JPanel();
	mainPanel.add(turnDisplay, BorderLayout.NORTH);
	turnButton = new JButton();
	turnDisplay.setLayout(new GridLayout(1,3));
	JLabel filler = new JLabel("");
	turnDisplay.add(filler);
	turnDisplay.add(turnButton);
	JLabel filler2 = new JLabel("");
	turnDisplay.add(filler2);
	turnDisplay.setBackground(Color.black);
	turnButtonDraw(turn);
	
	
	
	
	
	
	//set the panel array 
	panelArray = new JPanel();
	panelArray.setBackground(Color.darkGray);
	panelArray.setLayout(new GridLayout(6, 2,5,5));
	mainPanel.add(panelArray,BorderLayout.CENTER);

	//init the pokemon number
	pokemonCount = 0;
	//init the tracker to keep track of the pokemon in reference to the images
	images = new JButton[12];
	
	//init player turn
	
	
	while(e.hasNext())
	{
		//set current pokemon that we are talking about
		Pokemon p = e.next();
		
		//call to create the pokemon panels
		creatingList(p);
		
		//next pokemon number
		pokemonCount++;
	}
	
	//pack sizes to fit
	pack();
	
}


void creatingList(Pokemon pokemon) throws IOException 
{
	ImageIcon start = e.getPokemonImage(pokemon.getDescription());	

	//resize image here
	Image image = start.getImage(); // transform it 
	Image newimg = image.getScaledInstance(90, 79,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
	start = new ImageIcon(newimg);  // transform it back
	
	//set a new panel for each part for each individual pokemon 
	pokemonPanel = new JPanel();
	pokemonPanel.setLayout(new GridLayout(1,3));

	//create new panels
	namePanel=new JPanel();
	attackPanel=new JPanel();
	imagePanel=new JPanel();
	
	//image set here
	imagePanel.setLayout(new GridLayout());
	
	//set jbutton to this array spot
	images[pokemonCount] = new JButton (start);
	images[pokemonCount].addActionListener(this);
	imagePanel.add(images[pokemonCount]);
	
	//name and type set up here
	namePanel.setLayout(new GridLayout(1,1));
	
	JButton name1 = new JButton(pokemon.getDescription()+"\n"+Integer.toString(pokemon.getCurrentHealth())+"\n"+pokemon.getType().getDescription());
	name1.setFont(font);
	namePanel.add(name1);
	
	while(pokemon.hasNext())
	{
	    //add attacks to the attack panel
		attackPanel.setLayout(new GridLayout(4,1));
		JButton attack = new JButton(pokemon.next().getDescription());
		attack.setFont(font);
		attackPanel.add(attack);
	}

	//add subpanels to the main pokemon panel
	pokemonPanel.add(imagePanel);
	pokemonPanel.add(namePanel);
	pokemonPanel.add(attackPanel);
	
	//add the pokmonpanel to the main grid
	panelArray.add(pokemonPanel);
}


void turnButtonDraw(int turn)
{	
	if(turn == 0)
	{
		buttonText = "Player One's Turn";
	}
	if(turn == 1)
	{
		buttonText = "Player Two's Turn";
	}
	//sets new text
	turnButton.setText(buttonText);	
}



public void actionPerformed(ActionEvent e)
{	
	for(int x = 0; x < 12; x++)
	{
		if(e.getSource() == images[x])
		{
			//increment the amount of pokemon selected
			pokemonSelectLimit++;
			
			System.out.println("Pokemon Number " +x+ " Selected");

			//sends pokemon to player and updates turn
			select.setPokemon(x);
			select.execute();
			
			System.out.println(pokemonSelectLimit + " Pokemon Selected");
			//checks is 6 pokemon have been picked
			if (pokemonSelectLimit == 6)
			{
				System.out.println("Six Pokemon Selected!");
				new ConfirmGUI();
				this.setVisible(false);
			}
			System.out.println("Turn is now " + turn);
			
			//calls to update turn button
			turnButtonDraw(turn);
			
			//set the button so that it cant be clicked on anymore
			images[x].setEnabled(false);
			
			
		}
	  }
   }



@Override
public void updateTurn(int turn)
{
	this.turn = turn;
	
}

@Override
public int getTurn()
{
	return turn;
}

}


