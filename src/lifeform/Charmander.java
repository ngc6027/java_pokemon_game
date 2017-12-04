package lifeform;

import attacks.*;
import types.*;

/**
 * Basic Pokemon class that creates the moveset
 * and defines the type and health of the pokemon 
 * @author Michael Foreman 
 */
public class Charmander extends Pokemon {

	public Charmander()
	{
		super(new FireType(), 0, "Charmander");
		
		this.attacks.add(new Scratch());
		this.attacks.add(new Ember());
		this.attacks.add(new FlameBurst());
		this.attacks.add(new Flamethrower());
		
	}
	
}
