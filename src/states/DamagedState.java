package states;

import lifeform.*;

public class DamagedState extends HealthState{

	public DamagedState(Pokemon poke)
	{
		this.pokemon = poke;
	}
	
	@Override
	public double getAttackFraction() {
		return PARTIAL_DAMAGE;
	}

	@Override
	public void checkState(int currentHealth, int maxHealth) {
		if(currentHealth == 0)
		{
			pokemon.setCurrentState(pokemon.getFaintedState());
		} 
		else if (currentHealth == maxHealth)
		{
			pokemon.setCurrentState(pokemon.getFullState());
		}
		
	}

	@Override
	public String getDescription() {
		return "Damaged";
	}
}
