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
	
	@Test
	public void notPossibleToAddAnotherFrameToCompleteGame() {
		Game game = this.getCompleteGame();
		
		try {
			game.roll(3, 5);
			fail("Should no allow to add an extra game to a complete game!");
			
		} catch(InvalidGameException e) {
			assertThat(e.getMessage(), is("Attemp to add an extra frame to a complete game!"));
		}
		
		
		assertThat(game.isComplete(), is(true));
		
	}
	
	@Test
	public void canAccessFrameFromGame() {
		Game game = this.getCompleteGame();
		
		
		assertThat(game.getFrame(2).getThrow1(), is(3));
		assertThat(game.getFrame(2).getThrow2(), is(6));
		
		assertThat(game.getFrame(10).getThrow1(), is(2));
		assertThat(game.getFrame(10).getThrow2(), is(6));
		
	}
	
	@Test
	public void shouldNotAllowNegativeFrame() {
		Game game = new Game();
		
		try {
			game.roll(-1, 4);
			fail("Throw cannot be negative!");
			
		} catch(InvalidFrameException e) {
			assertThat(e.getMessage(), is("Do not add a negative throw!"));
		}
	}
	
	@Test
	public void totalPinsKnockedCannotExceedTen() {
		Game game = new Game();
		
		try {
			game.roll(7, 4);
			fail("Total pins rolls cannot exceed ten!");
			
		} catch(InvalidFrameException e) {
			assertThat(e.getMessage(), is("Max pin rolls cannot exceed ten!"));
		}
	}
	
	@Test
	public void gameScoreEqualsToSumOfFrameScore() {
		Game game = getCompleteGame();
		
		assertThat(game.getScore(), is(81));
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
