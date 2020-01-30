
public class Frame {
	private int throw1;
	private int throw2;
	
	public Frame() {
		
	}

	public void roll(int throw1, int throw2) throws InvalidFrameException {
		if (throw1 < 0 || throw2 < 0)
			throw new InvalidFrameException();
		
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

}
