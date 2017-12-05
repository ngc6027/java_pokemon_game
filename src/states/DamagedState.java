package states;

import lifeform.*;

/**
 * State Class for a pokemon that has been attacked
 * @author Michael Foreman
 *
 */
public class DamagedState extends HealthState{

	public DamagedState(Pokemon poke)
	{
		this.pokemon = poke;
	}
	
	/**
	 * Method to correctly modify the damage
	 * a pokemon can do based on their current health
	 */
	@Override
	public double getAttackFraction() {
		return PARTIAL_DAMAGE;
	}

	/**
	 * Method to make the correct state transition based on 
	 * the current health values
	 */
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
