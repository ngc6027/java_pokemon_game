package lifeform;

import java.util.ArrayList;

import attacks.*;
import types.Type;

public class Venusaur extends Pokemon {

	public Venusaur(Type type, int maxHP, String name) {
		super(type, maxHP, name);

		attacks.add(new RazorLeaf());
		attacks.add(new VineWhip());
		attacks.add(new SludgeBomb());
		attacks.add(new SolarBeam());
		
	}

}
