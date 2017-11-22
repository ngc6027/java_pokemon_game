package lifeform;

import attacks.*;
import types.*;

public class Poliwag extends Pokemon {

	public Poliwag()
	{
		super(new WaterType(), 100, "Poliwag");
		
		this.attacks.add(new Bubble());
		this.attacks.add(new MudShot());
		this.attacks.add(new AquaJet());
		this.attacks.add(new BodySlam());
		
	}
	
}
