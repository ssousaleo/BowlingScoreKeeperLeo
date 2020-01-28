import static org.junit.Assert.*;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class BowlingScoreKeeperTest {

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
	}
	
	@Test
	public void aFrameHasTwoThrows() {
		Frame frame = new Frame(2, 4);
		
		assertThat(frame.getThrow1(), is(2));
		assertThat(frame.getThrow2(), is(4));
	}
	
	@Test
	public void aScoreIsTheSumOfItsThrow() {
		Frame frame = new Frame(2, 4);
		
		assertThat(frame.getScore(), is(6));
		
	}
	
	@Test
	public void canAddAFrameToGame() {
		Game game = new Game();
		
		game.roll(1, 5);
		
		assertThat(game.getFrame(1), is(notNullValue()));
		
	}
	
	@Test
	public void recognizeACompleteGame() {
		Game game = this.getCompleteGame();
		
		
		assertThat(game.isComplete(), is(true));
		
	}
	
	private Game getCompleteGame() {
		Game game = new Game();
		
		game.roll(1, 5);
		game.roll(3, 6);
		game.roll(7, 2);
		game.roll(3, 6);
		game.roll(4, 4);
		game.roll(5, 3);
		game.roll(3, 3);
		game.roll(4, 5);
		game.roll(8, 1);
		game.roll(2, 6);
		
		return game;
	}

}
