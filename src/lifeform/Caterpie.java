package lifeform;

import attacks.*;
import types.*;

public class Caterpie extends Pokemon {

	public Caterpie()
	{
		super(new GrassType(), 100, "Caterpie");
		
		this.attacks.add(new Tackle());
		this.attacks.add(new Scratch());
		this.attacks.add(new RazorLeaf());
		this.attacks.add(new BugBite());
		
	}
	
}
