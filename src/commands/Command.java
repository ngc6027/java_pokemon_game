package commands;

import environment.*;

public abstract class Command {
	
	protected Environment env;
	protected int turn;
	
	public Command(int turn)
	{
		this.env = Environment.getEnvironment();
		this.turn = turn;
	}
	
	public abstract void execute();
}
