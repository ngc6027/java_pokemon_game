package lifeform;

import attacks.*;
import types.*;

/**
 * Basic Pokemon class that creates the moveset
 * and defines the type and health of the pokemon 
 * @author Michael Foreman 
 */
public class Blastoise extends Pokemon {

	public Blastoise()
	{
		super(new WaterType(), 2, "Blastoise");
		
		this.attacks.add(new Bite());
		this.attacks.add(new WaterGun());
		this.attacks.add(new HydroPump());
		this.attacks.add(new FlashCannon());
		
	}
	
}
