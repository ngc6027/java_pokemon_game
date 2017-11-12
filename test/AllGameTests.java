import org.junit.runner.RunWith;
import org.junit.runners.Suite;

import lifeform.*;
import environment.*;
import commands.*;
import gui.*;
import gameplay.*;
import states.*;
import types.*;

/**
 * Runs all of the tests in this project.
 * 
 * @author Michael Foreman
 */
@RunWith(Suite.class)
@Suite.SuiteClasses(
		{
			TestType.class,
			TestTimer.class
		})
public class AllGameTests {}
