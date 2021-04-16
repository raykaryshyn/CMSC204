import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collections;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Student tests for the MorseCodeTree class.
 * 
 * @author Raymond Karyshyn
 */
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
		assertEquals("", tree.getRoot().getData());
	}

	@Test
	public void testLevel1() {
		assertEquals("e", tree.getRoot().left.getData());
		assertEquals("t", tree.getRoot().right.getData());
	}

	@Test
	public void testLevel2() {
		assertEquals("i", tree.getRoot().left.left.getData());
		assertEquals("a", tree.getRoot().left.right.getData());

		assertEquals("n", tree.getRoot().right.left.getData());
		assertEquals("m", tree.getRoot().right.right.getData());
	}

	@Test
	public void testLevel3() {
		assertEquals("s", tree.getRoot().left.left.left.getData());
		assertEquals("u", tree.getRoot().left.left.right.getData());

		assertEquals("r", tree.getRoot().left.right.left.getData());
		assertEquals("w", tree.getRoot().left.right.right.getData());

		assertEquals("d", tree.getRoot().right.left.left.getData());
		assertEquals("k", tree.getRoot().right.left.right.getData());

		assertEquals("g", tree.getRoot().right.right.left.getData());
		assertEquals("o", tree.getRoot().right.right.right.getData());
	}

	@Test
	public void testLevel4() {
		assertEquals("h", tree.getRoot().left.left.left.left.getData());
		assertEquals("v", tree.getRoot().left.left.left.right.getData());

		assertEquals("f", tree.getRoot().left.left.right.left.getData());

		assertEquals("l", tree.getRoot().left.right.left.left.getData());

		assertEquals("p", tree.getRoot().left.right.right.left.getData());
		assertEquals("j", tree.getRoot().left.right.right.right.getData());

		assertEquals("b", tree.getRoot().right.left.left.left.getData());
		assertEquals("x", tree.getRoot().right.left.left.right.getData());

		assertEquals("c", tree.getRoot().right.left.right.left.getData());
		assertEquals("y", tree.getRoot().right.left.right.right.getData());

		assertEquals("z", tree.getRoot().right.right.left.left.getData());
		assertEquals("q", tree.getRoot().right.right.left.right.getData());
	}

	@Test
	public void testFetch() {
		assertEquals("a", tree.fetch(".-"));
		assertEquals("b", tree.fetch("-..."));
		assertEquals("c", tree.fetch("-.-."));
		assertEquals("d", tree.fetch("-.."));
		assertEquals("e", tree.fetch("."));
		assertEquals("f", tree.fetch("..-."));
		assertEquals("g", tree.fetch("--."));
		assertEquals("h", tree.fetch("...."));
		assertEquals("i", tree.fetch(".."));
		assertEquals("j", tree.fetch(".---"));
		assertEquals("k", tree.fetch("-.-"));
		assertEquals("l", tree.fetch(".-.."));
		assertEquals("m", tree.fetch("--"));
		assertEquals("n", tree.fetch("-."));
		assertEquals("o", tree.fetch("---"));
		assertEquals("p", tree.fetch(".--."));
		assertEquals("q", tree.fetch("--.-"));
		assertEquals("r", tree.fetch(".-."));
		assertEquals("s", tree.fetch("..."));
		assertEquals("t", tree.fetch("-"));
		assertEquals("u", tree.fetch("..-"));
		assertEquals("v", tree.fetch("...-"));
		assertEquals("w", tree.fetch(".--"));
		assertEquals("x", tree.fetch("-..-"));
		assertEquals("y", tree.fetch("-.--"));
		assertEquals("z", tree.fetch("--.."));
	}

	@Test
	public void testToArrayList() {
		ArrayList<String> expected = new ArrayList<>(26);
		String[] array = { "h", "s", "v", "i", "f", "u", "e", "l", "r", "a", "p", "w", "j", "", "b", "d", "x", "n", "c",
				"k", "y", "t", "z", "g", "q", "m", "o" };
		Collections.addAll(expected, array);

		assertEquals(expected, tree.toArrayList());
	}
}
