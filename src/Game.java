import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Frame> frames = new ArrayList<Frame>();
	
	public Game() {
		
	}

	public void addFrame(Frame f) {
		frames.add(f);
		
	}

	public Frame getFrame(int index) {
		return frames.get(index - 1);
	}

}
