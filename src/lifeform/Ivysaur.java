package lifeform;

import attacks.*;
import types.*;

/**
 * Basic Pokemon class that creates the moveset
 * and defines the type and health of the pokemon 
 * @author Michael Foreman 
 */
public class Ivysaur extends Pokemon {

	public Ivysaur() {
		super(new GrassType(), 1, "Ivysaur");
		
		attacks.add(new RazorLeaf());
		attacks.add(new VineWhip());
		attacks.add(new PowerWhip());
		attacks.add(new SludgeBomb());
		
	}

}
