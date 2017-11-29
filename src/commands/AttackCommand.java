package commands;

/**
 * The Command for instigating an attack. This is called by
 * the main Battle GUI. The attack number must be set before
 * the execute() method can be called each time.
 * 
 * @author Michael Foreman
 */
public class AttackCommand extends Command {

	private int attackNum;
	
	/**
	 * Instantiates the Attack Command.
	 * 
	 * @param playerNum the number of the player the GUI is associated with.
	 */
	public AttackCommand(int playerNum)
	{
		super(playerNum);
		this.attackNum = -1;
	}
	
	/**
	 * Sends the attack command to the Environment.
	 */
	@Override
	public void execute() {
		env.attack(attackNum, playerNum);
		this.attackNum = -1;
	}
	
	/**
	 * Sets the attack number the Pokemon should execute.
	 * 
	 * @param attackNum the number of the attack.
	 */
	public void setAttack(int attackNum)
	{
		this.attackNum = attackNum;
	}


}
