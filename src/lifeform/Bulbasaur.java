package lifeform;

import types.*;
import attacks.*;

public class Bulbasaur extends Pokemon {

	public Bulbasaur() {
		super(new GrassType(), 100, "Bulbasaur");
		
		attacks.add(new Tackle());
		attacks.add(new VineWhip());
		attacks.add(new PowerWhip());
		attacks.add(new SludgeBomb());
		
	}

}
