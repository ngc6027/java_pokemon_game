package commands;

import environment.Environment;

public class AttackCommand extends Command {

	private int attackNum;
	
	public AttackCommand()
	{
		this.env = Environment.getEnvironment();
		this.attackNum = -1;
	}
	
	@Override
	public void execute() {
		env.attack(attackNum);
		this.attackNum = -1;

	}
	
	public void setAttack(int attackNum)
	{
		this.attackNum = attackNum;
	}


}
