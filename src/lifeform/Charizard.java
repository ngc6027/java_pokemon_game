package lifeform;

import attacks.*;
import types.*;

/**
 * Basic Pokemon class that creates the moveset
 * and defines the type and health of the pokemon 
 * @author Michael Foreman 
 */
public class Charizard extends Pokemon {

	public Charizard()
	{
		super(new FireType(), 2, "Charizard");
		
		this.attacks.add(new Ember());
		this.attacks.add(new DragonClaw());
		this.attacks.add(new WingAttack());
		this.attacks.add(new Flamethrower());
		
	}
	
}
