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
	
	
	
	
	
	
	
	
//	private Game getCompleteGame() {
//		Game g = new Game();
//		
//		g.roll(1, 5);
//		g.roll(3, 6);
//		g.roll(7, 2);
//		g.roll(3, 6);
//		g.roll(4, 4);
//		g.roll(5, 3);
//		g.roll(3, 3);
//		g.roll(4, 5);
//		g.roll(8, 1);
//		g.roll(2, 6);
//		
//		return g;
//	}
	
	

}
