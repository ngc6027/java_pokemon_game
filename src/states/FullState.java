package states;

import lifeform.*;

/**
 * State class for a pokemon that has not taken any damage
 * @author Michael Foreman
 *
 */
public class FullState extends HealthState{

	public FullState(Pokemon poke)
	{
		this.pokemon = poke;
	}
	
	/**
	 * Method to ensure that a pokemon does the correct
	 * damage when it has not been hit yet
	 */
	@Override
	public double getAttackFraction() {
		return FULL_DAMAGE;
	}

	/**
	 * Method to ensure a pokemon transitions to the correct 
	 * state once it is damaged
	 */
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
