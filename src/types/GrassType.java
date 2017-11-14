package types;

public class GrassType extends Type{
	
	
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

	@Override
	public String getDescription() {
		return "Grass";
	}
}
