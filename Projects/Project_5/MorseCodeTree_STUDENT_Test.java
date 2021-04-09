import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class MorseCodeTree_STUDENT_Test {
	MorseCodeTree tree;

	@Before
	public void setUp() throws Exception {
		tree = new MorseCodeTree();
	}

	@After
	public void tearDown() throws Exception {
		tree = null;
	}

	@Test
	public void testRootNode() {
		assertEquals("", tree.getRoot().data);
	}

	@Test
	public void testLevel1() {
		assertEquals("e", tree.getRoot().left.data);
		assertEquals("t", tree.getRoot().right.data);
	}

	@Test
	public void testLevel2() {
		assertEquals("i", tree.getRoot().left.left.data);
		assertEquals("a", tree.getRoot().left.right.data);
		
		assertEquals("n", tree.getRoot().right.left.data);
		assertEquals("m", tree.getRoot().right.right.data);
	}

	@Test
	public void testLevel3() {
		assertEquals("s", tree.getRoot().left.left.left.data);
		assertEquals("u", tree.getRoot().left.left.right.data);
		
		assertEquals("r", tree.getRoot().left.right.left.data);
		assertEquals("w", tree.getRoot().left.right.right.data);
		
		assertEquals("d", tree.getRoot().right.left.left.data);
		assertEquals("k", tree.getRoot().right.left.right.data);
		
		assertEquals("g", tree.getRoot().right.right.left.data);
		assertEquals("o", tree.getRoot().right.right.right.data);
	}

	@Test
	public void testLevel4() {
		assertEquals("h", tree.getRoot().left.left.left.left.data);
		assertEquals("v", tree.getRoot().left.left.left.right.data);
		
		assertEquals("f", tree.getRoot().left.left.right.left.data);
		
		assertEquals("l", tree.getRoot().left.right.left.left.data);
		
		assertEquals("p", tree.getRoot().left.right.right.left.data);
		assertEquals("j", tree.getRoot().left.right.right.right.data);
		
		assertEquals("b", tree.getRoot().right.left.left.left.data);
		assertEquals("x", tree.getRoot().right.left.left.right.data);
		
		assertEquals("c", tree.getRoot().right.left.right.left.data);
		assertEquals("y", tree.getRoot().right.left.right.right.data);
		
		assertEquals("z", tree.getRoot().right.right.left.left.data);
		assertEquals("q", tree.getRoot().right.right.left.right.data);
	}
}
