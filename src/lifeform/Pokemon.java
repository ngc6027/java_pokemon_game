package lifeform;

import states.*;
import types.*;

import java.util.ArrayList;

import attacks.*;
import gameplay.*;

/**
 * A class to keep track of all variables and methods common to all Pokemon.
 * These are the main actors in the game.
 * 
 * @author Michael Foreman
 */
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
	
	/**
	 * Initializes a Pokemon. Can only be called by a concrete subclass.
	 * 
	 * @param type the Type of the Pokemon.
	 * @param maxHP the maximum hit points of the Pokemon.
	 * @param name the name of the Pokemon.
	 */
	public Pokemon(Type type, int maxHP, String name)
	{
		fullState = new FullState(this);
		damagedState = new DamagedState(this);
		faintedState = new FaintedState(this);
		
		// starts in full health state
		this.currentState = this.fullState;
		
		this.type = type;
	
		// starts at max health
		maxHealth = maxHP;
		currentHealth = maxHealth;
		this.name = name;
		
		this.attacks = new ArrayList<Attack>();
		attackIterator = 0;
		
	}
	
	/**
	 * @return this Pokemon's FullState
	 */
	public FullState getFullState()
	{
		return this.fullState;
	}
	
	/**
	 * @return this Pokemon's DamagedState
	 */
	public DamagedState getDamagedState()
	{
		return this.damagedState;
	}
	
	/**
	 * @return this Pokemon's FaintedState
	 */
	public FaintedState getFaintedState()
	{
		return this.faintedState;
	}
	
	/**
	 * @return this Pokemon's current state
	 */
	public HealthState getCurrentState()
	{
		return this.currentState;
	}
	
	/**
	 * Sets the current state of the Pokemon. Should only be called
	 * from the states themselves.
	 * 
	 * @param state the state to switch to.
	 */
	public void setCurrentState(HealthState state)
	{
		this.currentState = state;
	}
	
	/**
	 * @return the Type of the Pokemon.
	 */
	public Type getType()
	{
		return this.type;
	}
	
	/**
	 * Instigates an attack on another Pokemon.
	 * 
	 * @param target the target Pokemon
	 * @param attackNum the number of the attack for the Pokemon to use
	 */
	public void attack(Pokemon target, int attackNum)
	{
		double damage = 0;
		
		// call the actual attack
		damage = this.attacks.get(attackNum).calculateDamage();
		
		// add type modifier
		damage = type.getFraction(target.getType()) * damage;
		
		// add modifier based on current health of this pokemon
		damage = currentState.getAttackFraction() * damage;
		
		target.takeDamage((int) Math.round(damage));
	}
	
	/**
	 * Takes damage from another Pokemon's attack.
	 * 
	 * @param damage the amount of damage to take.
	 */
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
	
	/**
	 * @return the name of the Pokemon.
	 */
	public String getDescription()
	{
		return this.name;
	}
	
	/**
	 * Iterates through the Pokemon's attacks.
	 * 
	 * @return whether there is another attack to return
	 */
	public boolean hasNext()
	{
		boolean hasNext = false;
		
		if(this.attackIterator < attacks.size())
		{
			hasNext = true;
		}
		else
		{
			this.attackIterator = 0;
		}
		
		return hasNext;
	}
	
	/**
	 * @return the next Attack
	 */
	public Attack next()
	{
		Attack a = attacks.get(attackIterator);
		attackIterator++;
		return a;
	}
	
	/**
	 * @return the current health of the Pokemon.
	 */
	public int getCurrentHealth()
	{
		return this.currentHealth;
	}
	
	/**
	 * Resets the Pokemon's health to full, its iterator variable to 0,
	 * and its State to FullState.
	 */
	public void resetGame()
	{
		this.currentHealth = this.maxHealth;
		this.attackIterator = 0;
		this.currentState = this.fullState;
	}
	
}
