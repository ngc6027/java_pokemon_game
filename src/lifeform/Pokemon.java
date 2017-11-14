package lifeform;

import states.*;
import types.*;

import java.util.ArrayList;

import attacks.*;
import gameplay.Iterator;

public abstract class Pokemon implements Iterator {

	private int 				currentHealth;
	private int 				maxHealth;
	private String	 			name;
	
	private FullState 			fullState;
	private DamagedState 		damagedState;
	private FaintedState 		faintedState;
	private HealthState 		currentState;
	
	private Type				type;
	
	protected ArrayList<Attack>	attacks;
	private int attackIterator;
	
	public Pokemon(Type type, int maxHP, String name)
	{
		fullState = new FullState(this);
		damagedState = new DamagedState(this);
		faintedState = new FaintedState(this);
		
		this.currentState = this.fullState;
		
		this.type = type;
	
		maxHealth = maxHP;
		currentHealth = maxHealth;
		this.name = name;
		
		this.attacks = new ArrayList<Attack>();
		attackIterator = 0;
		
	}
	
	public FullState getFullState()
	{
		return this.fullState;
	}
	
	public DamagedState getDamagedState()
	{
		return this.damagedState;
	}
	
	public FaintedState getFaintedState()
	{
		return this.faintedState;
	}
	
	public HealthState getCurrentState()
	{
		return this.currentState;
	}
	
	public void setCurrentState(HealthState state)
	{
		this.currentState = state;
	}
	
	public Type getType()
	{
		return this.type;
	}
	
	public String getTypeDescription()
	{
		return this.type.getDescription();
	}
	
	public String getAttackDescription(int index)
	{
		return this.attacks.get(index).getDescription();
	}
	
	public int attack(Pokemon target, int attackNum)
	{
		double damage = 0;
		
		// call the actual attack
		
		
		damage = type.getFraction(target.getType()) * damage;
		
		damage = currentState.getAttackFraction() * damage;
		
		return((int) damage);
	}
	
	public void takeDamage(int damage)
	{
		if(damage >= this.currentHealth)
		{
			this.currentHealth = 0;
		}
		else
		{
			this.currentHealth = this.currentHealth - damage;
		}
		
		currentState.checkState(this.currentHealth, this.maxHealth);
	}
	
	public int getCurrentHelath()
	{
		return this.currentHealth;
	}
	
	public String getDescription()
	{
		return this.name;
	}
	
	public boolean hasNext()
	{
		boolean hasNext = false;
		
		if(this.attackIterator < attacks.size())
		{
			hasNext = true;
		}
		
		return hasNext;
	}
	
	public Attack next()
	{
		Attack a = attacks.get(attackIterator);
		attackIterator++;
		return a;
	}
	
	public void resetAttackIterator()
	{
		this.attackIterator = 0;
	}
	
	public int getCurrentHealth()
	{
		return this.currentHealth;
	}
	
}
