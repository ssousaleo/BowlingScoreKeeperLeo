import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Frame> frames = new ArrayList<Frame>();
	private final int MAX_ROUNDS = 10;
	
	public Game() {
		
	}

	public void addFrame(Frame f) {
		frames.add(f);
		
	}

	public Frame getFrame(int index) {
		return frames.get(index - 1);
	}

	public void roll(int i, int j) {
		Frame f = new Frame();
		f.roll(i, j);
		addFrame(f);
	}

	public boolean isComplete() {
		int rounds = frames.size();
		if (rounds == MAX_ROUNDS) {
			return true;
		}
		return false;
	}

}
