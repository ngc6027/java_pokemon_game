import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import lifeform.*;
import environment.*;
import commands.*;
import gui.*;
import gameplay.*;
import states.*;
import types.*;
import attacks.*;

/**
 * Runs all of the tests in this project.
 * 
 * @author Michael Foreman
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
		{
			TestType.class,
			TestTimer.class,
			
			TestPokemon.class,
			TestAttacks.class,
			TestCommand.class,
			TestEnvironment.class,
			TestIterator.class,
			TestObserver.class,
			TestPlayer.class,
			TestStates.class
		})
public class AllGameTests {}
