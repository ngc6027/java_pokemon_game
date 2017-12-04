package lifeform;

import attacks.*;
import types.*;

/**
 * Basic Pokemon class that creates the moveset
 * and defines the type and health of the pokemon 
 * @author Michael Foreman 
 */
public class Poliwag extends Pokemon {

	public Poliwag()
	{
		super(new WaterType(), 1, "Poliwag");
		
		this.attacks.add(new Bubble());
		this.attacks.add(new MudShot());
		this.attacks.add(new AquaJet());
		this.attacks.add(new BodySlam());
		
	}
	
}
