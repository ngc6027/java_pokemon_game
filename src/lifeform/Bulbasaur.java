package lifeform;

import java.util.ArrayList;

import types.Type;
import attacks.*;

public class Bulbasaur extends Pokemon {

	public Bulbasaur(Type type, int maxHP, String name) {
		super(type, maxHP, name);
		
		attacks.add(new Tackle());
		attacks.add(new VineWhip());
		attacks.add(new PowerWhip());
		attacks.add(new SludgeBomb());
		
	}

}
