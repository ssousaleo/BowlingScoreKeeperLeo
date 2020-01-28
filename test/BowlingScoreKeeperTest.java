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

}
