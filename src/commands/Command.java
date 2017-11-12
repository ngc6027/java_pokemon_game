package commands;

import environment.*;

public abstract class Command {
	
	protected Environment env;
	
	public abstract void execute();
}
