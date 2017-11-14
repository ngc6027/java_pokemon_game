package lifeform;

import attacks.*;
import types.*;

public class Blastoise extends Pokemon {

	public Blastoise()
	{
		super(new WaterType(), 100, "Blastoise");
		
		this.attacks.add(new Bite());
		this.attacks.add(new WaterGun());
		this.attacks.add(new HydroPump());
		this.attacks.add(new FlashCannon());
		
	}
	
}
