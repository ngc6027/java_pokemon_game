package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.*;

import environment.Environment;
import lifeform.Pokemon;

public class BattleGUI extends JFrame implements ActionListener
{
	Environment e;
	JPanel mainPanel;
	JPanel playerOne;
	JPanel playerTwo;
	JPanel attacks;
	JProgressBar playerOneStats;
	JButton playerOneImage;
	JProgressBar playerTwoStats;
	JButton playerTwoImage;
	JProgressBar playerOneHealth;
	JProgressBar playerTwoHealth;
	
	JButton images[];

	public BattleGUI() throws IOException
	{
		//setup
		super("Battle");
		this.e = Environment.getEnvironment();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(700,700);
		images = new JButton[2];
		//build gutss
		guts();
		//creatingBattle();
		
	}
	
	void guts() throws IOException
	{
		
		
		
		
		mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBackground(Color.darkGray);
		mainPanel.setLayout(new GridLayout(3,2));
		
		playerOne = new JPanel();
		Pokemon pokemon1  = e.getPlayer(1).getPokemon(0);
		playerTwo = new JPanel();
		Pokemon pokemon0  = e.getPlayer(0).getPokemon(0);
		attacks = new JPanel();
		
		
		
		
		ImageIcon start0 = e.getPokemonImage(pokemon0.getDescription());	

		//resize image here
		Image image0 = start0.getImage(); // transform it 
		Image newimg0 = image0.getScaledInstance(190, 109,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		start0 = new ImageIcon(newimg0);  // transform it back
		
		ImageIcon start1 = e.getPokemonImage(pokemon1.getDescription());	

		//resize image heres
		Image image1 = start1.getImage(); // transform it 
		Image newimg1 = image1.getScaledInstance(190, 109,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		start1 = new ImageIcon(newimg1);  // transform it back
		
		
		images[0] = new JButton (start0);
		
		//playerOne.add(images[0]);
		images[1] = new JButton (start1);
		
		//playerTwo.add(images[1]);
//		
//		
		playerOneHealth = new JProgressBar(0, pokemon0.getCurrentHealth());
		playerOneHealth.setValue(pokemon0.getCurrentHealth());
		playerOneHealth.setStringPainted(true);
//		
		playerOneStats = playerOneHealth;
		mainPanel.add(playerOne.add(playerOneStats));
		
		mainPanel.add(images[0]);
		
		playerTwoHealth = new JProgressBar(0, pokemon1.getCurrentHealth());
		playerTwoHealth.setValue(pokemon1.getCurrentHealth());
		playerTwoHealth.setStringPainted(true);
//		
		playerTwoStats = playerTwoHealth;
		mainPanel.add(playerTwo.add(playerTwoStats));
		
		mainPanel.add(images[1]);

		mainPanel.add(new JButton("taco"));
		while(pokemon0.hasNext())
		{
			//attacks.setLayout(new GridLayout(2,2));
			JButton attack = new JButton(pokemon0.next().getDescription());
			//attack.setFont(font);
			mainPanel.add(attack);
		}
		ImageIcon start = e.getPokemonImage(pokemon0.getDescription());	
		Image newimg = start.getImage();
		start = new ImageIcon(newimg); 
	
//		mainPanel.add(e.getPokemonImage(pokemon0.getDescription()));
		
		
		
//		JPanel
//		JPanel statsAndHealthPlayer1 = new JPanel();
//		JPanel imagePanel1 = new JPanel();
//		JButton images1 = new JButton();
//		JPanel statsAndHealthPlayer0 = new JPanel();
//		JPanel image0 = new JPanel();
//		JPanel attacks = new JPanel();
//		attacks.setLayout(getLayout());
//		Pokemon pokemon  = e.getPlayer(1).getActivePokemon();
//		ImageIcon start = e.getPokemonImage(pokemon.getDescription());	
//
//		//resize image here
//		Image image = start.getImage(); // transform it 
//		Image newimg = image.getScaledInstance(90, 79,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
//		start = new ImageIcon(newimg);  // transform it back
//		imagePanel1.add(images1);
//		
//		
//		
//		mainPanel.add(statsAndHealthPlayer1);
//		mainPanel.add(imagePanel1);
//		mainPanel.add(statsAndHealthPlayer0);
//		mainPanel.add(image0);
//		mainPanel.add(attacks);
		this.add(mainPanel);
		
		
		
//		//gridspot 0 0 = opposite player pokemon info
//		Pokemon pokemon  = e.getPlayer(1).getActivePokemon();
//		ImageIcon pokemon1Image = e.getPokemonImage(pokemon.getDescription());
//		Image image1 = pokemon1Image.getImage();
//		Image newimg1 = image1.getScaledInstance(90, 79,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
//		pokemon1Image = new ImageIcon(newimg1);  // transform it back
		
		
		//add(pokemon1Image);
		
		
		//gridspot 0 1 = opposite pokemon picture
		//ImageIcon start = e.getPokemonImage(pokemonImage.getDescription());
		
		
		//gridspot 1 0 = player pokemon
		//gridspot 1 1 = player pokemon info
		//e.getPlayer(0).getActivePokemon();
		
		//gridspot 2 0 = blank spot that shows text when stuff happens
		//gridspot 2 1 = Menu options
		
	}
	
	public void creatingBattle() throws IOException
	{
		playerOne = new JPanel(new GridLayout(2,1));
		Pokemon pokemon1  = e.getPlayer(1).getPokemon(0);
		playerTwo = new JPanel(new GridLayout(2,1));
		Pokemon pokemon0  = e.getPlayer(0).getPokemon(0);
		attacks = new JPanel(new GridLayout(2,2));
//		
//		
		playerOneHealth = new JProgressBar(0, pokemon0.getCurrentHealth());
		playerOneHealth.setValue(pokemon0.getCurrentHealth());
		playerOneHealth.setStringPainted(true);
//		
		playerOneStats = playerOneHealth;
		mainPanel.add(playerOneStats);
		
		playerTwoHealth = new JProgressBar(0, pokemon1.getCurrentHealth());
		playerTwoHealth.setValue(pokemon1.getCurrentHealth());
		playerTwoHealth.setStringPainted(true);
//		
		playerTwoStats = playerTwoHealth;
		mainPanel.add(playerTwoStats);
		
		ImageIcon start = e.getPokemonImage(pokemon0.getDescription());	
		Image newimg = start.getImage();
		start = new ImageIcon(newimg); 
		
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// TODO Auto-generated method stub
		
	}

}
