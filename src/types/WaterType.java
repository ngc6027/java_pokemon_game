package types;

public class WaterType extends Type{
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
}
