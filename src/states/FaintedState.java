package states;

import lifeform.*;

/**
 * State class for a pokemon that has died (fainted)
 * @author Michael Foreman
 */
public class FaintedState extends HealthState{

	public FaintedState(Pokemon poke)
	{
		this.pokemon = poke;
	}
	
	/**
	 * Ensures a pokemon will do no damage if a player tries
	 * to attack when a poemon is fainted
	 */
	@Override
	public double getAttackFraction() {
		return NO_DAMAGE;
	}
	
	/**
	 * Method to transition to the correct state if a pokemon
	 * is healed
	 */
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
