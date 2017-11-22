package commands;

import org.junit.Test;
import static org.junit.Assert.*;

import environment.*;
import lifeform.*;

public class TestCommand {

	@Test
	public void testRegisterCommand()
	{
		Environment e = Environment.getEnvironment();
		e.resetGame();
		
		RegisterCommand r = new RegisterCommand();
		r.setObserver(e);
		r.execute();
		
		int turn = e.getTurn();
		
		e.assignPokemon(0);
		
		if(turn == 0) 
		{
			assertEquals(1, e.getTurn());
		}
		else
		{
			assertEquals(0, e.getTurn());
		}
		
	}
	
	@Test
	public void testSelectPokemonCommand()
	{
		Environment e = Environment.getEnvironment();
		
		e.resetGame();
		
		SelectPokemonCommand s = new SelectPokemonCommand();
		
		s.setPokemon(2);
		s.execute();
		
		assertEquals("Venusaur", e.getPlayer(0).getPokemon(0).getDescription());
		
	}
	
	@Test
	public void testChangeActivePokemonCommand()
	{
		Environment e = Environment.getEnvironment();
		
		e.resetGame();
		
		e.assignPokemon(0);		// Bulbasaur to Player 1
		e.assignPokemon(11);	// Poliwag to Player 2
		e.assignPokemon(3);		// Caterpie to Player 1
		e.assignPokemon(4);     // Charmander to Player 2
		
		ChangeActivePokemonCommand c = new ChangeActivePokemonCommand();
		
		e.changeActivePokemon(0);	// set player 1 active pokemon to Bulbasaur
		e.changeActivePokemon(0);	// set player 2 active pokemon to Poliwag
		
		assertTrue(e.getPlayer(0).getActivePokemon() instanceof Bulbasaur);
		c.setPokemon(1);
		c.execute();
		assertTrue(e.getPlayer(0).getActivePokemon() instanceof Caterpie);
	}
	
	@Test
	public void testAttackCommand()
	{
		Environment e = Environment.getEnvironment();
		
		e.resetGame();
		
		e.assignPokemon(0);		// Bulbasaur to Player 1
		e.assignPokemon(11);	// Poliwag to Player 2
		
		AttackCommand c = new AttackCommand();
		
		e.changeActivePokemon(0);	// set player 1 active pokemon to Bulbasaur
		e.changeActivePokemon(0);	// set player 2 active pokemon to Poliwag
		
		c.setAttack(0);
		c.execute();
		
		assertEquals(90, e.getPlayer(1).getActivePokemon().getCurrentHealth());
	}
	
}
