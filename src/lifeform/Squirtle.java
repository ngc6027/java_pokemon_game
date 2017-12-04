package lifeform;

import attacks.*;
import types.*;

/**
 * Basic Pokemon class that creates the moveset
 * and defines the type and health of the pokemon 
 * @author Michael Foreman 
 */
public class Squirtle extends Pokemon {

	public Squirtle()
	{
		super(new WaterType(), 0, "Squirtle");
		
		this.attacks.add(new Tackle());
		this.attacks.add(new Bubble());
		this.attacks.add(new AquaJet());
		this.attacks.add(new WaterPulse());
		
	}
	
}
