package types;

/**
 * Concrete Type class for Firetype Pokemon
 * @author Michael Foreman
 *
 */
public class FireType extends Type{

	/**
	 * Calculates the correct damage modifier based on what type
	 * it is attacking
	 * @return damage modifier
	 */
	@Override
	public double getFraction(Type opponentType) {
		
		double modifier = NORMAL_DAMAGE;
		
		if(opponentType.getClass() == WaterType.class)
		{
			modifier = HALF_DAMAGE;
		}
		else if (opponentType.getClass() == FireType.class)
		{
			modifier = NORMAL_DAMAGE;
		}
		else if (opponentType.getClass() == GrassType.class)
		{
			modifier = DOUBLE_DAMAGE;
		}
		
		return modifier;
	}

	/**
	 * Returns the appropriate description
	 * @return the String description
	 */
	@Override
	public String getDescription() {
		return "Fire";
	}

}
