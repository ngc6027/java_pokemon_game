package states;

import lifeform.*;

public class FullState extends HealthState{

	public FullState(Pokemon poke)
	{
		this.pokemon = poke;
	}
	
	@Override
	public double getAttackFraction() {
		return FULL_DAMAGE;
	}

	@Override
	public void checkState(int currentHealth, int maxHealth) {
		if(currentHealth == 0)
		{
			pokemon.setCurrentState(pokemon.getFaintedState());
		} 
		else if (currentHealth < maxHealth)
		{
			pokemon.setCurrentState(pokemon.getDamagedState());
		}
		
	}

	@Override
	public String getDescription() {
		return "Full Health";
	}
	
}
