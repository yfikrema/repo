import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MorseCodeTreeTest {

	public MorseCodeTree tree = new MorseCodeTree();
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		
		assertEquals("h", tree.fetch("...."));
		
		assertEquals("a", tree.fetch(".-"));
		
		assertEquals("e", tree.fetch("."));
		
		assertEquals("c", tree.fetch("-.-."));
		assertEquals("z", tree.fetch("--.."));
		
		assertEquals("x", tree.fetch("-..-"));
	}

}
