package lifeform;

import attacks.*;
import types.*;

public class Charmander extends Pokemon {

	public Charmander()
	{
		super(new FireType(), 100, "Charmander");
		
		this.attacks.add(new Scratch());
		this.attacks.add(new Ember());
		this.attacks.add(new FlameBurst());
		this.attacks.add(new Flamethrower());
		
	}
	
}
