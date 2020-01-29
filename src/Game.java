import java.util.List;
import java.util.ArrayList;

public class Game {
	private List<Frame> frames = new ArrayList<Frame>();
	private static final int MAX_FRAMES = 10;

	public void roll(int throw1, int throw2) {
		if (isComplete()) {
			throw new InvalidGameException("Attemp to add an extra frame to a complete game!");
		}
		
		frames.add(new Frame(throw1, throw2));
	}

	public Frame getFrame(int frameIndex) {
		return frames.get(frameIndex - 1);
	}

	public boolean isComplete() {
		return frames.size() == MAX_FRAMES;
	}

	public int getScore() {
		int sum = 0;
		
		for (int i = 1; i < frames.size(); i++) {
			sum += getFrameScore(i);
		}
		
		if (!frames.get(frames.size() - 1).isSpare() &&
			!frames.get(frames.size() - 1).isStrike()) {
			sum += frames.get(frames.size() - 1).getScore();
		}
		return sum;
	}

	public int getFrameScore(int frameIndex) {
		if (getFrame(frameIndex).isStrike()) {
			if (frameIndex == frames.size()) {
				throw new InCompleteStrikeException("Strike is incomplete!");
			}
			
			return getFrame(frameIndex).getScore() + getFrame(frameIndex + 1).getScore(); 
		}
		
		if (getFrame(frameIndex).isSpare()) {
			if (frameIndex == frames.size()) {
				throw new InCompleteSpareException("Spare is incomplete!");
			}
			
			return getFrame(frameIndex).getScore() + getFrame(frameIndex + 1).getThrow1(); 
		}
		
		return getFrame(frameIndex).getScore();
	}

}
