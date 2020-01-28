
public class Frame {
	private int throw1;
	private int throw2;

	public Frame(int throw1, int throw2) {
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
