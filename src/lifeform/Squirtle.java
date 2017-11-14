package lifeform;

import attacks.*;
import types.*;

public class Squirtle extends Pokemon {

	public Squirtle()
	{
		super(new WaterType(), 100, "Squirtle");
		
		this.attacks.add(new Tackle());
		this.attacks.add(new Bubble());
		this.attacks.add(new AquaJet());
		this.attacks.add(new WaterPulse());
		
	}
	
}
