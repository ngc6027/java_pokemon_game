package commands;

import environment.*;
import gameplay.*;

public class RegisterCommand extends Command {

	private Environment env;
	private Observer o;
	
	public RegisterCommand()
	{
		this.env = Environment.getEnvironment();
	}
	
	@Override
	public void execute()
	{
		env.registerWithTimer(this.o);
	}
	
	public void setObserver(Observer o)
	{
		this.o = o;
	}

}
