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

import commands.AttackCommand;
import commands.ChangeActivePokemonCommand;

import javax.swing.border.EtchedBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JLayeredPane;

/**
 * @author derekgrove
 *
 */
public class WindowBuilderBattleGui extends JFrame implements ActionListener
{
	//setup
	Environment e;
	
	
	//panel and button setup
	private JLayeredPane mainPanel;
	private JPanel interactionPane;
	private JPanel opponentInfo;
	private JPanel ourInfo;
	private JPanel opponentPic;
	private JPanel ourPic;
	private JPanel dynamicPanel;
	private JButton runButton;
	private JButton attackButton;
	private JButton pokemonButton;
	private JButton bagButton;
	
	
	//current player setup
	private JLabel ourPokemonLabel;
	private Player playerOne;
	private Pokemon playerOneCurrentPokemon;
	private JProgressBar playerTwoHealth;
	
	//opposite player setup
	private JLabel opPokemonLabel;
	private Player playerTwo;
	private Pokemon playerTwoCurrentPokemon;
	private JProgressBar playerOneHealth;

	//images
	private JButton opponentPicture;
	private JButton ourImage;
	
	//For choosing pokemon
	private JLabel pickPokeLabel;
	private JButton pokeChoiceOne;
	private JButton pokeChoiceTwo;
	private JButton pokeChoiceThree;
	int dynamicOption = 0;
	private JLabel bigHpLabel;
	

	private JButton attackChoiceOne;
	private JButton attackChoiceTwo;
	private JButton attackChoiceThree;
	private JButton attackChoiceFour;

	AttackCommand attackCall;
	ChangeActivePokemonCommand change;


	private JLabel lblNewLabel;
	
	/**
	 * @param playerNum 
	 * @throws IOException
	 */
	public WindowBuilderBattleGui(int playerNum) throws IOException
	{
		//setup
		super("Battle: Player " + playerNum);
		this.e = Environment.getEnvironment();
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,400);
		
		e.setBattleGui(this, playerNum);
	
		//register commands to current player
		change = new ChangeActivePokemonCommand(playerNum);
		attackCall = new AttackCommand(playerNum);
		
		//set playerOne as the person who's battle window it is
	    playerOne = e.getPlayer(playerNum);
	    
	    //set the opponent as player 2
	    if(playerNum == 0)
	    {
		   playerTwo = e.getPlayer(1);
	    }
	    else
	    {
	    	playerTwo = e.getPlayer(0);
	    }
		
	    //set opponant
	    playerOne.setOpponent(playerTwo);
	    
	    
		//set their starting pokemon 		
		playerOneCurrentPokemon = playerOne.getPokemon(0);
		playerTwoCurrentPokemon = playerTwo.getPokemon(0);
		playerOne.changeActivePokemon(0);
		playerTwo.changeActivePokemon(0);
		
		//build guts
		init();
		
	}
	
	
	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
	 */
	protected void init() throws IOException
	{
		//main overall panel
		mainPanel = new JLayeredPane();
		mainPanel.setBorder(new BevelBorder(BevelBorder.RAISED, Color.DARK_GRAY, null, null, null));
		this.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridLayout(3, 2, 0, 0));
		mainPanel.setOpaque(true);
		

		//the pane that holds all of the info for the opponant pokemon
		opponentInfo = new JPanel();
		opponentInfo.setBackground(Color.GREEN);
		//opponentInfo.setOpaque(true);
		mainPanel.add(opponentInfo);
		opponentInfo.setLayout(new GridLayout(3, 1, 0, 0));
		oppInfoPane();
		
		//set up the opponant panel that contains their pokemon pic
		opponentPic = new JPanel();
		opponentPic.setBackground(Color.GREEN);
		//opponentPic.setOpaque(true);
		mainPanel.add(opponentPic);
		opponentPic.setLayout(new GridLayout(0, 1, 0, 0));
		opponentPicPane();
		
		//set up current player panel that contains our pokemon pic
		ourPic = new JPanel();
		ourPic.setBackground(Color.GREEN);
		//ourPic.setOpaque(true);
		mainPanel.add(ourPic);
		ourPic.setLayout(new GridLayout(1, 0, 0, 0));
		ourPicPane();
		
		//the pane that holds all of the info for our pokemon
		ourInfo = new JPanel();
		ourInfo.setBackground(Color.GREEN);
		//ourInfo.setOpaque(true);
		mainPanel.add(ourInfo);
		ourInfo.setLayout(new GridLayout(4, 1, 0, 0));
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
	
	
	private void oppInfoPane()
	{
		opponentInfo.removeAll();
		
		//grab the name
		String name = playerTwoCurrentPokemon.getDescription();
		opPokemonLabel = new JLabel(name);
		opPokemonLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		opPokemonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		opponentInfo.add(opPokemonLabel);
		//grab the health and set it
		playerTwoHealth = new JProgressBar(0, playerTwoCurrentPokemon.getMaxHealth());
		playerTwoHealth.setValue(playerTwoCurrentPokemon.getCurrentHealth());
		opponentInfo.add(playerTwoHealth);
		
		opponentInfo.revalidate();
		opponentInfo.repaint();
	}
	
	
	private void ourInfoPane()
	{
		ourInfo.removeAll();
		
		//grab the name
		String name = playerOneCurrentPokemon.getDescription();
		
		lblNewLabel = new JLabel("");
		ourInfo.add(lblNewLabel);
		ourPokemonLabel = new JLabel(name);
		ourPokemonLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 17));
		ourPokemonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ourInfo.add(ourPokemonLabel);
		
		//set the health bar
		playerOneHealth = new JProgressBar(0, playerOneCurrentPokemon.getMaxHealth());
		playerOneHealth.setValue(playerOneCurrentPokemon.getCurrentHealth());
		ourInfo.add(playerOneHealth);
		
		//have a number version health
		String health = playerOneCurrentPokemon.getCurrentHealth() + " / " + playerOneCurrentPokemon.getMaxHealth();
		bigHpLabel = new JLabel(health);
		bigHpLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		bigHpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ourInfo.add(bigHpLabel);
		
		ourInfo.revalidate();
		ourInfo.repaint();
	}
	
	
	private void opponentPicPane() throws IOException
	{
		opponentPic.removeAll();
		
		//get image for opponents current pokemon
		ImageIcon oppImage;
		oppImage = e.getPokemonImage(playerTwoCurrentPokemon.getDescription());	

		//resize image here
		Image image0 = oppImage.getImage(); // transform it 
		Image newimg0 = image0.getScaledInstance(190, 109,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		oppImage = new ImageIcon(newimg0);  // transform it back

		opponentPicture = new JButton(oppImage);
		opponentPic.add(opponentPicture);
		
		opponentPic.revalidate();
		opponentPic.repaint();
	}
	
	
	private void ourPicPane() throws IOException
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
	
	
	
	public void dynamicPane()
	{
		dynamicPanel.removeAll();
		
		//swtich statement decides what to put in the panel dependent on what button was clicked
		switch(dynamicOption)
		{
			case 0:
				break;
				
			//Switch pokemon case	
			case 1:
			{
				//Present the choices of pokemon to pick
				pickPokeLabel = new JLabel("   PICK A POKEMON:");
				dynamicPanel.add(pickPokeLabel);
				
				String pokemonName = playerOne.getPokemon(0).getDescription();
				pokeChoiceOne = new JButton(pokemonName);
				pokeChoiceOne.addActionListener(this);
				dynamicPanel.add(pokeChoiceOne);
				//these will darken the button if they are dead
				if(playerOne.getPokemon(0).getCurrentHealth() == 0)
				{
					pokeChoiceOne.setEnabled(false);
				}
				
				pokemonName = playerOne.getPokemon(1).getDescription();
				pokeChoiceTwo = new JButton(pokemonName);
				pokeChoiceTwo.addActionListener(this);
				dynamicPanel.add(pokeChoiceTwo);
				if(playerOne.getPokemon(1).getCurrentHealth() == 0)
				{
					pokeChoiceOne.setEnabled(false);
				}
				
		
				pokemonName = playerOne.getPokemon(2).getDescription();
				pokeChoiceThree = new JButton(pokemonName);
				pokeChoiceThree.addActionListener(this);
				dynamicPanel.add(pokeChoiceThree);
				if(playerOne.getPokemon(1).getCurrentHealth() == 0)
				{
					pokeChoiceOne.setEnabled(false);
				}
				
				
				break;
		    }
			
			//Bag case... pretty much a clear
			case 2:
				break;
			
			//Attack Case
			case 3:
			{
				int i = 5;
				
				JButton attack;
				 
				while(playerOneCurrentPokemon.hasNext())
				{
					attack = new JButton(playerOneCurrentPokemon.next().getDescription());
					
					switch(i)
					{
					case 5:
						
						attackChoiceOne = attack;
						attackChoiceOne.addActionListener(this);
						dynamicPanel.add(attackChoiceOne);
						
						break;
					case 6:
						
						attackChoiceTwo = attack;
						attackChoiceTwo.addActionListener(this);
						dynamicPanel.add(attackChoiceTwo);
						
						break;
					case 7:
						
						attackChoiceThree = attack;
						attackChoiceThree.addActionListener(this);
						dynamicPanel.add(attackChoiceThree);
						
						break;
					case 8:
						
						attackChoiceFour = attack;
						attackChoiceFour.addActionListener(this);
						dynamicPanel.add(attackChoiceFour);
						break;
					default:
						break;
					
					}
					
					i++;
				}
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

	
	/**
	 * UPDATES ALL PANES BUT DYNAMIC
	 */
	public void updateAllPanes() 
	{
		playerOneCurrentPokemon = playerOne.getActivePokemon();
		playerTwoCurrentPokemon = playerTwo.getActivePokemon();
		ourInfoPane();
		oppInfoPane();
		//System.out.println();
		try
		{
			ourPicPane();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		try
		{
			opponentPicPane();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	@Override
	public void actionPerformed(ActionEvent e)
	{
		// MAIN BUTTON CHOICES
		if (e.getSource() == attackButton)
		{
			dynamicOption = 3;
			dynamicPane();
			
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
			//call to change pokemon, will work if its our turn
			change.setPokemon(0);
			change.execute();

			System.out.println(playerOne.getActivePokemon().getDescription());
			
			updateAllPanes();
			
			//clears dynamic pane
			dynamicOption = 2;
			dynamicPane();
			
		}
		if(e.getSource() == pokeChoiceTwo)
		{
			//call to change pokemon, will work if its our turn
			change.setPokemon(1);
			change.execute();			

			System.out.println(playerOne.getActivePokemon().getDescription());
			
			updateAllPanes();
			
			//clears dynamic pane
			dynamicOption = 2;
			dynamicPane();
			
		}
		if(e.getSource() == pokeChoiceThree)
		{
			//call to change pokemon, will work if its our turn
			change.setPokemon(2);
			change.execute();
	
			System.out.println(playerOne.getActivePokemon().getDescription());
			
			updateAllPanes();
			
			//clears dynamic pane
			dynamicOption = 2;
			dynamicPane();
		}
		
		
		//ATTACK BUTTONS
		if(e.getSource() == attackChoiceOne)
		{
			attackCall.setAttack(0);
			attackCall.execute();
			
			updateAllPanes();
			
			//clears dynamic pane
			dynamicOption = 2;
			dynamicPane();
		}
		
		if(e.getSource() == attackChoiceTwo)
		{
			attackCall.setAttack(1);
			attackCall.execute();
			
			updateAllPanes();
			
			//clears dynamic pane
			dynamicOption = 2;
			dynamicPane();
		}
		
		if(e.getSource() == attackChoiceThree)
		{
			
			attackCall.setAttack(2);
			attackCall.execute();
			
			updateAllPanes();
			
			//clears dynamic pane
			dynamicOption = 2;
			dynamicPane();
		}
		
		if(e.getSource() == attackChoiceFour)
		{
			
			attackCall.setAttack(3);
			attackCall.execute();

			updateAllPanes();
			
			//clears dynamic pane
			dynamicOption = 2;
			dynamicPane();
		}
		
	}
}
