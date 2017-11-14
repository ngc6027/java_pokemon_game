package lifeform;

import attacks.*;
import types.*;

public class Vulpix extends Pokemon {

	public Vulpix()
	{
		super(new FireType(), 100, "Vulpix");
		
		this.attacks.add(new Ember());
		this.attacks.add(new FlameBurst());
		this.attacks.add(new Flamethrower());
		this.attacks.add(new HeatWave());
		
	}
}
