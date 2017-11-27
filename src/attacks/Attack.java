package attacks;

/**
 * The Attack class implements attacks for the Pokemon class. Each Attack
 * has a tier (I - VI) that determines how much damage an attack will do
 * and its likelihood of hitting.
 * 
 * @author Michael Foreman
 */
public abstract class Attack {
	
	/*
	 * These arrays define attack strength and accuracy for each tier of attack. 
	 */
	final protected double[] STRENGTH = {5.0, 8.0, 10.0, 15.0, 20.0, 25.0};
	final protected int[]    ACCURACY = {100, 90, 80, 75, 70, 60};
	
	/*
	 * Each attack will instantiate a tier number for attack purposes
	 * and a description for display purposes.
	 */
	private int tier;
	private String description;
	
	/**
	 * Constructs an attack by setting its tier and description.
	 * 
	 * @param tier the tier of the attack (0 - 5)
	 * @param description the name of the attack.
	 */
	public Attack(int tier, String description)
	{
		this.tier = tier;
		this.description = description;
	}
	
	/**
	 * Calculates damage caused by an attack. This method takes into consideration
	 * the tier's chance-to-attack and attack strength.
	 * 
	 * @return the amount of damage the attack will cause.
	 */
	public double calculateDamage()
	{
		double damage = 0;
		
		int chance = (int) Math.floor((Math.random() * 100) + 1);
		
		if(chance <= this.ACCURACY[tier])
		{
			damage = this.STRENGTH[tier];
		}
		
		return damage;
	}
	
	/**
	 * @return the String description of the attack.
	 */
	public String getDescription()
	{
		return this.description;
	}
}
