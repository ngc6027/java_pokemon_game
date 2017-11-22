package attacks;

public abstract class Attack {
	
	final protected double[] STRENGTH = {5.0, 8.0, 10.0, 15.0, 20.0, 25.0};
	final protected int[]    ACCURACY = {100, 90, 80, 75, 70, 60};
	
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
		
		int chance = (int) Math.floor((Math.random() * 100) + 1);
		
		if(chance <= this.ACCURACY[tier])
		{
			damage = this.STRENGTH[tier];
		}
		
		return damage;
	}
	
	public String getDescription()
	{
		return this.description;
	}
}
