package commands;

import org.junit.Test;
import static org.junit.Assert.*;

import environment.*;

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
	
}
