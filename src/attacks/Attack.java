package attacks;

public abstract class Attack {
	
	final protected double[] STRENGTH = {5.0, 8.0, 10.0, 15.0, 20.0, 25.0};
	final protected double[] ACCURACY = {100.0, 90.0, 80.0, 75.0, 70.0, 60.0};
	
	private int tier;
	private String description;
	
	public Attack(int tier, String description)
	{
		this.tier = tier;
		this.description = description;
	}
	
	public double calculateDamage()
	{
		double damage = 0;
		
		// RNG, if hit...
		damage = this.STRENGTH[tier];
		
		return damage;
	}
	
	public String getDescription()
	{
		return this.description;
	}
}
