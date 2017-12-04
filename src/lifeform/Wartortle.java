package lifeform;

import attacks.*;
import types.*;

/**
 * Basic Pokemon class that creates the moveset
 * and defines the type and health of the pokemon 
 * @author Michael Foreman 
 */
public class Wartortle extends Pokemon {

	public Wartortle()
	{
		super(new WaterType(), 1, "Wartortle");
		
		this.attacks.add(new Bite());
		this.attacks.add(new WaterGun());
		this.attacks.add(new AquaJet());
		this.attacks.add(new HydroPump());
		
	}
	
}
