package lifeform;

import java.util.ArrayList;

import attacks.*;
import types.Type;

public class Ivysaur extends Pokemon {

	public Ivysaur(Type type, int maxHP, String name) {
		super(type, maxHP, name);
		
		attacks.add(new RazorLeaf());
		attacks.add(new VineWhip());
		attacks.add(new PowerWhip());
		attacks.add(new SludgeBomb());
		
	}

}
