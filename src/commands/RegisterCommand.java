package commands;

import environment.*;
import gameplay.*;

public class RegisterCommand extends Command {

	private Observer o;
	
	public RegisterCommand()
	{
		super(-1);
		this.o = null;
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
