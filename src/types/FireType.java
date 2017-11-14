package types;

public class FireType extends Type{

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

	@Override
	public String getDescription() {
		return "Fire";
	}

}
