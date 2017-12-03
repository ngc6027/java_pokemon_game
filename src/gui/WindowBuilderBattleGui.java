package gui;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

import environment.Environment;
import lifeform.Player;
import lifeform.Pokemon;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

/**
 * @author derekgrove
 *
 */
public class WindowBuilderBattleGui extends JFrame implements ActionListener
{
	//setup
	Environment e;
	
	
	//panel and button setup
	JPanel mainPanel;
	JPanel interactionPane;
	JPanel opponentInfo;
	JPanel ourInfo;
	JPanel opponentPic;
	JPanel ourPic;
	JPanel dynamicPanel;
	JButton runButton;
	JButton attackButton;
	JButton pokemonButton;
	JButton bagButton;
	
	
	//current player setup
	private JLabel ourPokemonLabel;
	private Player playerOne;
	private Pokemon playerOneCurrentPokemon;
	private JButton playerOneImage;
	private JProgressBar playerTwoHealth;
	
	//opposite player setup
	private JLabel opPokemonLabel;
	private Player playerTwo;
	private Pokemon playerTwoCurrentPokemon;
	private JButton playerTwoImage;
	private JProgressBar playerOneHealth;

	//i forget what these are
	private JButton opponantPic;
	private JButton ourImage;
	
	//For choosing pokemon
	private JLabel pickPokeLabel;
	private JButton pokeChoiceOne;
	private JButton pokeChoiceTwo;
	private JButton pokeChoiceThree;
	int dynamicOption = 0;

	

	
	/**
	 * @throws IOException
	 */
	public WindowBuilderBattleGui() throws IOException
	{
		//setup
		super("Battle");
		this.e = Environment.getEnvironment();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		
		//get players
	    playerOne = e.getPlayer(0);
		playerTwo = e.getPlayer(1);

		//get their starting pokemon 		//GET ACTIVE THROWS ISSUES HERE IDK
		playerOneCurrentPokemon = playerOne.getPokemon(0);
		playerTwoCurrentPokemon = playerTwo.getPokemon(0);
		
		//build guts
		init();
	}

	
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	private void init() throws IOException
	{
		//main overall panel
		mainPanel = new JPanel();
		mainPanel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, null, null, null));
		this.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridLayout(3, 2, 0, 0));
		
		//the pane that holds all of the info for the opponant pokemon
		opponentInfo = new JPanel();
		opponentInfo.setBackground(Color.GREEN);
		mainPanel.add(opponentInfo);
		opponentInfo.setLayout(new GridLayout(3, 1, 0, 0));
		oppInfoPane();
		
		//set up the opponant panel that contains their pokemon pic
		opponentPic = new JPanel();
		opponentPic.setBackground(Color.GREEN);
		mainPanel.add(opponentPic);
		opponentPic.setLayout(new GridLayout(0, 1, 0, 0));
		opponentPicPane();
		
		//set up current player panel that contains our pokemon pic
		ourPic = new JPanel();
		ourPic.setBackground(Color.GREEN);
		mainPanel.add(ourPic);
		ourPic.setLayout(new GridLayout(1, 0, 0, 0));
		ourPicPane();
		
		//the pane that holds all of the info for our pokemon
		ourInfo = new JPanel();
		ourInfo.setBackground(Color.GREEN);
		mainPanel.add(ourInfo);
		ourInfo.setLayout(new GridLayout(3, 1, 0, 0));
		ourInfoPane();
		
		//dynamic Pane that shows what is currently needed
		dynamicPanel = new JPanel();
		dynamicPanel.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), Color.BLACK));
		mainPanel.add(dynamicPanel);
		dynamicPanel.setLayout(new GridLayout(4, 1, 0, 0));
		dynamicPane();
		
		
		//pane that holds the options at start of turn
		interactionPane = new JPanel();
		interactionPane.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), Color.BLACK));
		mainPanel.add(interactionPane);
		interactionPane.setLayout(new GridLayout(2, 2, 0, 0));
		interactionPane();
	}
	
	
	void oppInfoPane()
	{
		//grab the name
		String name = playerTwoCurrentPokemon.getDescription();
		opPokemonLabel = new JLabel(name);
		opPokemonLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		opPokemonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		opponentInfo.add(opPokemonLabel);
		//grab the health and set it
		playerTwoHealth = new JProgressBar(0, 100);
		playerTwoHealth.setValue(playerTwoCurrentPokemon.getCurrentHealth());
		opponentInfo.add(playerTwoHealth);
	}
	
	
	void ourInfoPane()
	{
		ourInfo.removeAll();
		
		//grab the name
		String name = playerOneCurrentPokemon.getDescription();
		
		ourInfo.add(new JLabel(""));
		ourPokemonLabel = new JLabel(name);
		ourPokemonLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		ourPokemonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ourInfo.add(ourPokemonLabel);
		//grab the health and set it
		playerOneHealth = new JProgressBar(0,100);
		playerOneHealth.setValue(playerOneCurrentPokemon.getCurrentHealth());
		ourInfo.add(playerOneHealth);
		
		ourInfo.revalidate();
		ourInfo.repaint();
	}
	
	
	void opponentPicPane() throws IOException
	{
		//get image for opponents current pokemon
		ImageIcon oppImage;
		oppImage = e.getPokemonImage(playerTwoCurrentPokemon.getDescription());	

		//resize image here
		Image image0 = oppImage.getImage(); // transform it 
		Image newimg0 = image0.getScaledInstance(190, 109,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		oppImage = new ImageIcon(newimg0);  // transform it back

		opponantPic = new JButton(oppImage);
		opponentPic.add(opponantPic);
	}
	
	
	void ourPicPane() throws IOException
	{
		ourPic.removeAll();
		
		ImageIcon usImage = e.getPokemonImage(playerOneCurrentPokemon.getDescription());	

		//resize image heres
		Image image1 = usImage.getImage(); // transform it 
		Image newimg1 = image1.getScaledInstance(190, 109,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		usImage = new ImageIcon(newimg1);  // transform it back

		ourImage = new JButton(usImage);
		ourPic.add(ourImage);
		
		ourPic.revalidate();
		ourPic.repaint();
	}
	
	
	
	void dynamicPane()
	{
		dynamicPanel.removeAll();
		
		//swtich statement decides what to put in the panel dependent on what button was clicked
		switch(dynamicOption)
		{
			case 0:
				break;
			case 1:
			{
				//Present the choices of pokemon to pick
				pickPokeLabel = new JLabel("   PICK A POKEMON:");
				dynamicPanel.add(pickPokeLabel);
				
				String pokemonName = playerOne.getPokemon(0).getDescription();
				pokeChoiceOne = new JButton(pokemonName);
				pokeChoiceOne.addActionListener(this);
				dynamicPanel.add(pokeChoiceOne);
				
				pokemonName = playerOne.getPokemon(1).getDescription();
				pokeChoiceTwo = new JButton(pokemonName);
				pokeChoiceTwo.addActionListener(this);
				dynamicPanel.add(pokeChoiceTwo);
		
				pokemonName = playerOne.getPokemon(2).getDescription();
				pokeChoiceThree = new JButton(pokemonName);
				pokeChoiceThree.addActionListener(this);
				dynamicPanel.add(pokeChoiceThree);
				
		    }
			default:
				break;
		}
		
		dynamicPanel.revalidate();
		dynamicPanel.repaint();
		
	}
	
	
	void interactionPane()
	{
		//attack button
		attackButton = new JButton("ATTACK");
		attackButton.addActionListener(this);
		interactionPane.add(attackButton);
		
		//bag button
		bagButton = new JButton("BAG");
		bagButton.addActionListener(this);
		interactionPane.add(bagButton);
		
		//pokemon button
		pokemonButton = new JButton("POKeMON");
		pokemonButton.addActionListener(this);
		interactionPane.add(pokemonButton);
		
		//run button
		runButton = new JButton("RUN");
		runButton.addActionListener(this);
		interactionPane.add(runButton);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		// MAIN BUTTON CHOICES
		if (e.getSource() == attackButton)
		{
			
		}
		if (e.getSource() == runButton)
		{
			//close program
			System.exit(0);
		}
		if(e.getSource() == pokemonButton)
		{
			//draw the pick pokemon options in the dynamic panel
			dynamicOption = 1;
			dynamicPane();
		}
		if(e.getSource() == bagButton)
		{
			dynamicOption = 2;
			dynamicPane();
		}
		
		
		//POKEMON CHOICES >>> REDRAWS THE INFO AND PICTURE PANE BASED ON WHAT IS CURRENT
		if(e.getSource() == pokeChoiceOne)
		{
			playerOne.changeActivePokemon(0);
			playerOneCurrentPokemon = playerOne.getActivePokemon();
			ourInfoPane();
			System.out.println(playerOne.getActivePokemon().getDescription());
			try
			{
				ourPicPane();
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
		if(e.getSource() == pokeChoiceTwo)
		{
			playerOne.changeActivePokemon(1);
			playerOneCurrentPokemon = playerOne.getActivePokemon();
			ourInfoPane();
			System.out.println(playerOne.getActivePokemon().getDescription());
			try
			{
				ourPicPane();
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}
			
		}
		if(e.getSource() == pokeChoiceThree)
		{

			playerOne.changeActivePokemon(2);
			playerOneCurrentPokemon = playerOne.getActivePokemon();
			ourInfoPane();
			System.out.println(playerOne.getActivePokemon().getDescription());
			try
			{
				ourPicPane();
			} catch (IOException e1)
			{
				e1.printStackTrace();
			}
		}
		
	}

}
