package lifeform;

import states.*;

public class Pokemon {

	private FullState 		fullState;
	private DamagedState 	damagedState;
	private FaintedState 	faintedState;
	private HealthState 	currentState;
	
	public Pokemon()
	{
		fullState = new FullState(this);
		damagedState = new DamagedState(this);
		faintedState = new FaintedState(this);
		
		this.currentState = this.fullState;
		
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
}
