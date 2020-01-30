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
	public void template() {
		
	}
	
	
	@Test
	public void aFrameHasTwoThrows() {
		Frame f = new Frame();
		f.roll(5, 3);
		assertThat(f.getThrow1(), is(5));
		assertThat(f.getThrow2(), is(3));
	}
	
	@Test
	public void frameScoreIsSumOfThrows() {
		Frame f = new Frame();
		f.roll(2, 6);
		
		assertThat(f.getScore(), is(8));
	}
	
	@Test
	public void canAddAndGetAFrameFromGame() {
		Frame f1 = new Frame();
		f1.roll(1, 5);
		Game g = new Game();
		g.addFrame(f1);
		Frame f2 = g.getFrame(1);
		assertThat(f2.getThrow1(), is(1));
		assertThat(f2.getThrow2(), is(5));
	}
	
	@Test
	public void gameWithTenFramesIsCompleted() {
		Game g = getCompleteGame();
		assertTrue(g.isComplete());
		
	}
	
	@Test(expected = InvalidGameException.class)
	public void unableToAddAnotherFrameToCompleteGame() {
		Game g = getCompleteGame();
		g.roll(2, 5);
	}
	
	@Test
	public void canAccessFramesInGameIndividually() {
		Game g = getCompleteGame();
		Frame f = g.getFrame(5);
		assertThat(f.getThrow1(), is(4));
		assertThat(f.getThrow2(), is(4));
	}
	
	@Test(expected = InvalidFrameException.class)
	public void aFrameCantHaveANegtiveThrow() {
		Frame f = new Frame();
		f.roll(-1, 2);
	}
	
	@Test(expected = InvalidFrameException.class)
	public void aFrameCanNotExceedMaxPins() {
		Frame f = new Frame();
		f.roll(1, 10);
	}
	
	@Test
	public void aFrameCanNotExceedMaxPinsCatchException() {
		Frame f = new Frame();
		
		try {
			f.roll(1, 10);
			fail("Should not allow more than ten pins!");
		} catch(InvalidFrameException e) {
			assertThat(e.getMessage(), is("Max Sum of Pins not allowed!"));
		}
		
		
	}
	
	@Test
	public void scoreOfAGameIsSumOfItsFrameScores() {
		Game g = getCompleteGame();
		assertThat(g.getScore(), is(81));
	}
	
	@Test
	public void checkFrameIsStrike() {
		Frame f = new Frame();
		f.roll(10, 0);
		assertThat(f.isStrike(), is(true));
	}
	
	
	private Game getCompleteGame() {
		Game g = new Game();
		
		g.roll(1, 5);
		g.roll(3, 6);
		g.roll(7, 2);
		g.roll(3, 6);
		g.roll(4, 4);
		g.roll(5, 3);
		g.roll(3, 3);
		g.roll(4, 5);
		g.roll(8, 1);
		g.roll(2, 6);
		
		return g;
	}
	
	

}
