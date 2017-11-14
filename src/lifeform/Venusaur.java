package lifeform;

import attacks.*;
import types.*;

public class Venusaur extends Pokemon {

	public Venusaur() {
		super(new GrassType(), 100, "Venusaur");

		attacks.add(new RazorLeaf());
		attacks.add(new VineWhip());
		attacks.add(new SludgeBomb());
		attacks.add(new SolarBeam());
		
	}

}
