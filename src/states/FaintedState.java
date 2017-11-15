package states;

import lifeform.*;

public class FaintedState extends HealthState{

	public FaintedState(Pokemon poke)
	{
		this.pokemon = poke;
	}
	
	@Override
	public double getAttackFraction() {
		return NO_DAMAGE;
	}
	
	@Override
	public void checkState(int currentHealth, int maxHealth) {
		if((currentHealth < maxHealth) && (currentHealth > 0))
		{
			pokemon.setCurrentState(pokemon.getDamagedState());
		} 
		else if (currentHealth == maxHealth)
		{
			pokemon.setCurrentState(pokemon.getFullState());
		}
		
	}

	@Override
	public String getDescription() {
		return "Fainted";
	}
}
