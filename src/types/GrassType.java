package types;


 /**
 * Concrete Type class for Grasstype Pokemon
 * @author Michael Foreman
 */
public class GrassType extends Type{
	
	/**
	 * Calculates the correct damage modifier based on what type
	 * it is attacking
	 * @return damage modifier
	 */
	@Override
	public double getFraction(Type opponentType) {
		
		double modifier = 1.0;
		
		if(opponentType instanceof FireType)
		{
			modifier = HALF_DAMAGE;
		}
		else if (opponentType instanceof GrassType)
		{
			modifier = NORMAL_DAMAGE;
		}
		else if (opponentType instanceof WaterType)
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
		return "Grass";
	}
}
