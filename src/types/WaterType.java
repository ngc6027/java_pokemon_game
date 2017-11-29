package types;

/**
* Concrete Type class for Watertype Pokemon
* @author Michael Foreman
*/
public class WaterType extends Type{
	
	/**
	 * Calculates the correct damage modifier based on what type
	 * it is attacking
	 *@return damage modifier
	 */
	@Override
	public double getFraction(Type opponentType) {
		
		double modifier = 1.0;
		
		if(opponentType instanceof GrassType)
		{
			modifier = HALF_DAMAGE;
		}
		else if (opponentType instanceof WaterType)
		{
			modifier = NORMAL_DAMAGE;
		}
		else if (opponentType instanceof FireType)
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
		return "Water";
	}
}
