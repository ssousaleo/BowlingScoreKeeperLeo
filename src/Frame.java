
public class Frame {
	private int throw1;
	private int throw2;
	
	private static final int MAX_PINS = 10;

	public Frame(int throw1, int throw2) {
		if (throw1 < 0 || throw2 < 0) {
			throw new InvalidFrameException("Do not add a negative throw!");
		}
		
		if (throw1 + throw2 > MAX_PINS) {
			throw new InvalidFrameException("Max pin rolls cannot exceed ten!");
		}
		
		this.throw1 = throw1;
		this.throw2 = throw2;
	}

	public int getThrow1() {
		return throw1;
	}

	public int getThrow2() {
		return throw2;
	}

	public int getScore() {
		return throw1 + throw2;
	}

	public boolean isStrike() {
		return throw1 == MAX_PINS;
	}

	public boolean isSpare() {
		if (throw1 == 100 || throw2 == 10) {
			return false;
		}
		return getScore() == MAX_PINS;
	}

}
