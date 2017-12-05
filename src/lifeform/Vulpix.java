package lifeform;

import attacks.*;
import types.*;

/**
 * Basic Pokemon class that creates the moveset
 * and defines the type and health of the pokemon 
 * @author Michael Foreman 
 */
public class Vulpix extends Pokemon {

	public Vulpix()
	{
		super(new FireType(), 2, "Vulpix");
		
		this.attacks.add(new Ember());
		this.attacks.add(new FlameBurst());
		this.attacks.add(new HeatWave());
		this.attacks.add(new Flamethrower());
		
	}
}
