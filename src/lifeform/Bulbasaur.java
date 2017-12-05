package lifeform;

import types.*;
import attacks.*;

/**
 * Basic Pokemon class that creates the moveset
 * and defines the type and health of the pokemon 
 * @author Michael Foreman 
 */
public class Bulbasaur extends Pokemon {

	public Bulbasaur() {
		super(new GrassType(), 0, "Bulbasaur");
		
		attacks.add(new Tackle());
		attacks.add(new VineWhip());
		attacks.add(new PowerWhip());
		attacks.add(new SludgeBomb());
		
	}

}
