package commands;

import gameplay.*;

/**
 * The command for registering an Observer with the Timer.
 * The selection GUI should execute this command so that it is
 * updated regarding whose turn it is to select a Pokemon.
 * 
 * @author Michael Foreman
 */
public class RegisterCommand extends Command {

	private Observer o;
	
	/**
	 * Instantiates the Register Command. It is unneccessary
	 * for the turn to be set for this command, so it is defaulted
	 * to -1.
	 */
	public RegisterCommand()
	{
		super(-1);
		this.o = null;
	}
	
	/**
	 * Sends the register With Timer command to the Environment.
	 */
	@Override
	public void execute()
	{
		env.registerWithTimer(this.o);
	}
	
	/** 
	 * @param o the observer to register with the Timer.
	 */
	public void setObserver(Observer o)
	{
		this.o = o;
	}

}
