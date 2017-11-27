package commands;

import environment.*;

/**
 * The abstract Command class for implementing commands between
 * the GUIs and the Environment.
 * 
 * @author Michael Foreman
 */
public abstract class Command {
	
	protected Environment env;
	protected int playerNum;
	
	/**
	 * Instantiates a Command by setting the Environment and the player
	 * the command is associated with.
	 * 
	 * @param playerNum the number of the player that will be executing
	 * the command.
	 */
	public Command(int playerNum)
	{
		this.env = Environment.getEnvironment();
		this.playerNum = playerNum;
	}
	
	/**
	 * The abstract method that will be defined by each subclass
	 * depending on the behavior the particular command will be
	 * executing. 
	 */
	public abstract void execute();
}
