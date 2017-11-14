package lifeform;

import attacks.*;
import types.*;

public class Ivysaur extends Pokemon {

	public Ivysaur() {
		super(new GrassType(), 100, "Ivysaur");
		
		attacks.add(new RazorLeaf());
		attacks.add(new VineWhip());
		attacks.add(new PowerWhip());
		attacks.add(new SludgeBomb());
		
	}

}
