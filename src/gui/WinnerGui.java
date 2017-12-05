package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;

import environment.Environment;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.SwingConstants;
import java.awt.Font;

public class WinnerGui extends JFrame
{

	/**
	 * Create the application.
	 */
	public WinnerGui(int playerNum)
	{
		super("WINNER" );
		
		
		getContentPane().setBackground(Color.YELLOW);
		JLabel lblNewLabel = new JLabel("Player "+ (playerNum+1) + " is the WINNER!");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblNewLabel, BorderLayout.CENTER);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400,200);	
	}
}
