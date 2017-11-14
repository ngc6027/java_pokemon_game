package lifeform;

import attacks.*;
import types.*;

public class Charmeleon extends Pokemon {

	public Charmeleon()
	{
		super(new FireType(), 100, "Charmeleon");
		
		this.attacks.add(new Scratch());
		this.attacks.add(new Ember());
		this.attacks.add(new DragonClaw());
		this.attacks.add(new Flamethrower());
		
	}
	
}
