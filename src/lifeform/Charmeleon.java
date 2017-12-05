package lifeform;

import attacks.*;
import types.*;

/**
 * Basic Pokemon class that creates the moveset
 * and defines the type and health of the pokemon 
 * @author Michael Foreman 
 */
public class Charmeleon extends Pokemon {

	public Charmeleon()
	{
		super(new FireType(), 1, "Charmeleon");
		
		this.attacks.add(new Scratch());
		this.attacks.add(new Ember());
		this.attacks.add(new DragonClaw());
		this.attacks.add(new Flamethrower());
		
	}
	
}
