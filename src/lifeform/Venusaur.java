package lifeform;

import attacks.*;
import types.*;

/**
 * Basic Pokemon class that creates the moveset
 * and defines the type and health of the pokemon 
 * @author Michael Foreman 
 */
public class Venusaur extends Pokemon {

	public Venusaur() {
		super(new GrassType(), 2, "Venusaur");

		attacks.add(new RazorLeaf());
		attacks.add(new VineWhip());
		attacks.add(new SludgeBomb());
		attacks.add(new SolarBeam());
		
	}

}
