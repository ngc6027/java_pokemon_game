package states;

import lifeform.*;

public abstract class HealthState {

	Pokemon pokemon;
	
	static final double FULL_DAMAGE 	= 1.0;
	static final double PARTIAL_DAMAGE 	= 0.8;
	static final double NO_DAMAGE 		= 0.0;
	
	public abstract double getAttackFraction();
	public abstract void checkState(int currentHealth, int maxHealth);
	public abstract String getDescription();
}
