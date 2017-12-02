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

public class WindowBuilderBattleGui extends JFrame implements ActionListener
{

	
	Environment e;
	JPanel mainPanel;
	JPanel interactionPane;
	JPanel opponentInfo;
	JPanel ourInfo;
	JPanel opponentPic;
	JPanel ourPic;
	JPanel panel_5;
	JButton runButton;
	JButton attackButton;
	
	private JLabel ourPokemonLabel;
	private Player playerOne;
	private Pokemon playerOneCurrentPokemon;
	private JButton playerOneImage;
	private JProgressBar playerTwoHealth;
	
	
	private JLabel opPokemonLabel;
	private Player playerTwo;
	private Pokemon playerTwoCurrentPokemon;
	private JButton playerTwoImage;
	private JProgressBar playerOneHealth;

	
	private JButton opponantPic;
	private JButton ourImage;
	

	

	
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

		//get their starting pokemon
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
		mainPanel.setBorder(new BevelBorder(BevelBorder.RAISED, null, null, null, null));
		this.getContentPane().add(mainPanel, BorderLayout.CENTER);
		mainPanel.setLayout(new GridLayout(3, 2, 0, 0));
		
		//the pane that holds all of the info for the opponant pokemon
		opponentInfo = new JPanel();
		mainPanel.add(opponentInfo);
		opponentInfo.setLayout(new GridLayout(3, 1, 0, 0));
		oppInfoPane();
		
		//set up the opponant panel that contains their pokemon pic
		opponentPic = new JPanel();
		mainPanel.add(opponentPic);
		opponentPic.setLayout(new GridLayout(0, 1, 0, 0));
		opponentPicPane();
		
		//set up current player panel that contains our pokemon pic
		ourPic = new JPanel();
		mainPanel.add(ourPic);
		ourPic.setLayout(new GridLayout(1, 0, 0, 0));
		ourPicPane();
		
		//the pane that holds all of the info for our pokemon
		ourInfo = new JPanel();
		mainPanel.add(ourInfo);
		ourInfo.setLayout(new GridLayout(3, 1, 0, 0));
		ourInfoPane();
		
		//dynamic
		panel_5 = new JPanel();
		panel_5.setBorder(new EtchedBorder(EtchedBorder.RAISED, new Color(0, 0, 0), Color.BLACK));
		mainPanel.add(panel_5);
		
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
		opPokemonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		opponentInfo.add(opPokemonLabel);
		//grab the health and set it
		playerTwoHealth = new JProgressBar(0, 100);
		playerTwoHealth.setValue(playerTwoCurrentPokemon.getCurrentHealth());
		opponentInfo.add(playerTwoHealth);
	}
	
	void ourInfoPane()
	{
		//grab the name
		String name = playerOneCurrentPokemon.getDescription();
		ourInfo.add(new JLabel(""));
		ourPokemonLabel = new JLabel(name);
		ourPokemonLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ourInfo.add(ourPokemonLabel);
		//grab the health and set it
		playerOneHealth = new JProgressBar(0,100);
		playerOneHealth.setValue(playerOneCurrentPokemon.getCurrentHealth());
		ourInfo.add(playerOneHealth);
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
		ImageIcon usImage = e.getPokemonImage(playerOneCurrentPokemon.getDescription());	

		//resize image heres
		Image image1 = usImage.getImage(); // transform it 
		Image newimg1 = image1.getScaledInstance(190, 109,  java.awt.Image.SCALE_SMOOTH); // scale it the smooth way  
		usImage = new ImageIcon(newimg1);  // transform it back

		ourImage = new JButton(usImage);
		ourPic.add(ourImage);		
	}
	
	
	void interactionPane()
	{
		
		attackButton = new JButton("ATTACK");
		interactionPane.add(attackButton);
		
		JButton bagButton = new JButton("BAG");
		interactionPane.add(bagButton);
		
		JButton pokemonButton = new JButton("POKeMON");
		interactionPane.add(pokemonButton);
		
		runButton = new JButton("RUN");
		runButton.addActionListener(this);
		interactionPane.add(runButton);
	}

	@Override
	public void actionPerformed(ActionEvent e)
	{
		if (e.getSource() == runButton)
		{
			//close program
			System.exit(0);
		}
		
	}

}
