package lifeform;

import attacks.*;
import types.*;

/**
 * Basic Pokemon class that creates the moveset
 * and defines the type and health of the pokemon 
 * @author Michael Foreman 
 */
public class Caterpie extends Pokemon {

	public Caterpie()
	{
		super(new GrassType(), 0, "Caterpie");
		
		this.attacks.add(new Tackle());
		this.attacks.add(new Scratch());
		this.attacks.add(new RazorLeaf());
		this.attacks.add(new BugBite());
		
	}
	
}
