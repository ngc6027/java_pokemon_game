package types;

public abstract class Type {

	static final double DOUBLE_DAMAGE 	= 2.0;
	static final double NORMAL_DAMAGE 	= 1.0;
	static final double HALF_DAMAGE 	= 0.5;
	
	public abstract double getFraction(Type opponentType);
}
