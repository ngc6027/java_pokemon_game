package lifeform;

import attacks.*;
import types.*;

public class Charizard extends Pokemon {

	public Charizard()
	{
		super(new FireType(), 100, "Charizard");
		
		this.attacks.add(new Ember());
		this.attacks.add(new DragonClaw());
		this.attacks.add(new WingAttack());
		this.attacks.add(new Flamethrower());
		
	}
	
}
