import java.util.List;
import java.util.ArrayList;

public class Game {
	private List<Frame> frames = new ArrayList<Frame>();
	private static final int MAX_FRAMES = 10;

	public void roll(int throw1, int throw2) {
		if (isComplete()) {
			throw new InvalidGameException("Attemp to add an extra frame to a complete game");
		}
		
		frames.add(new Frame(throw1, throw2));
	}

	public Frame getFrame(int frameIndex) {
		return frames.get(frameIndex - 1);
	}

	public boolean isComplete() {
		return frames.size() == MAX_FRAMES;
	}

}
