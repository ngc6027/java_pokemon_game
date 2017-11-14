package lifeform;

import attacks.*;
import types.*;

public class Wartortle extends Pokemon {

	public Wartortle()
	{
		super(new WaterType(), 100, "Wartortle");
		
		this.attacks.add(new Bite());
		this.attacks.add(new WaterGun());
		this.attacks.add(new AquaJet());
		this.attacks.add(new HydroPump());
		
	}
	
}
