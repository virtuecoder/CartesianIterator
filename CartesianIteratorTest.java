
import java.util.Arrays;

import junit.framework.TestCase;
import util.collect.CartesianIterator;

public class CartesianIteratorTest extends TestCase {
	
	public void test_() throws Exception {
		CartesianIterator it = new CartesianIterator() {
			@Override
			public Object next() {
				return Arrays.toString((Object[]) super.next());
			}
		};
		
		assertFalse(it.hasNext());
		try {
			assertEquals("[]", it.next());
			fail("Should throw NoSuchElementException");
		} catch (Exception e) { /* Ignore exception */ }
	}
		
	public void test_0() throws Exception {
		CartesianIterator it = new CartesianIterator(
				Arrays.asList(new String[] {})) {
			
			@Override
			public Object next() {
				return Arrays.toString((Object[]) super.next());
			}
		};
		
		assertFalse(it.hasNext());
		try {
			assertEquals("[]", it.next());
			fail("Should throw NoSuchElementException");
		} catch (Exception e) { /* Ignore exception */ }
	}
	
	public void test_1() throws Exception {
		CartesianIterator it = new CartesianIterator(
				Arrays.asList(new String[] {"a"})) {
			
			@Override
			public Object next() {
				return Arrays.toString((Object[]) super.next());
			}
		};
		
		assertTrue(it.hasNext());
		assertEquals("[a]", it.next());
		assertFalse(it.hasNext());
	}
	
	public void test_2() throws Exception {
		CartesianIterator it = new CartesianIterator(
				Arrays.asList(new String[] {"a", "b"})) {
			
			@Override
			public Object next() {
				return Arrays.toString((Object[]) super.next());
			}
		};
		
		assertTrue(it.hasNext());
		assertEquals("[a]", it.next());
		assertTrue(it.hasNext());
		assertEquals("[b]", it.next());
		assertFalse(it.hasNext());
	}
	
	public void test_2_0() throws Exception {
		CartesianIterator it = new CartesianIterator(
				Arrays.asList(new String[] {"a", "b"}),
				Arrays.asList(new String[] {})) {
			
			@Override
			public Object next() {
				return Arrays.toString((Object[]) super.next());
			}
		};
		
		assertFalse(it.hasNext());
		try {
			assertEquals("[]", it.next());
			fail("Should throw NoSuchElementException");
		} catch (Exception e) { /* Ignore exception */ }
	}
	
	public void test_2_2() throws Exception {
		CartesianIterator it = new CartesianIterator(
				Arrays.asList(new String[] {"a", "b"}),
				Arrays.asList(new String[] {"c", "d"})) {
			
			@Override
			public Object next() {
				return Arrays.toString((Object[]) super.next());
			}
		};
		
		assertTrue(it.hasNext());
		assertEquals("[a, c]", it.next());
		assertTrue(it.hasNext());
		assertEquals("[a, d]", it.next());
		assertTrue(it.hasNext());
		assertEquals("[b, c]", it.next());
		assertTrue(it.hasNext());
		assertEquals("[b, d]", it.next());
		assertFalse(it.hasNext());
	}
	
	public void test_2_3_4() throws Exception {
		CartesianIterator it = new CartesianIterator(
				Arrays.asList(new String[] {"a", "b"}),
				Arrays.asList(new String[] {"c", "d", "e"}),
				Arrays.asList(new String[] {"f", "g", "h", "i"})) {
			
			@Override
			public Object next() {
				return Arrays.toString((Object[]) super.next());
			}
		};
		
		assertTrue(it.hasNext());
		assertEquals("[a, c, f]", it.next());
		assertTrue(it.hasNext());
		assertEquals("[a, c, g]", it.next());
		assertEquals("[a, c, h]", it.next());
		assertEquals("[a, c, i]", it.next());
		assertEquals("[a, d, f]", it.next());
		assertEquals("[a, d, g]", it.next());
		assertEquals("[a, d, h]", it.next());
		assertEquals("[a, d, i]", it.next());
		assertEquals("[a, e, f]", it.next());
		assertEquals("[a, e, g]", it.next());
		assertEquals("[a, e, h]", it.next());
		assertEquals("[a, e, i]", it.next());
		assertEquals("[b, c, f]", it.next());
		assertEquals("[b, c, g]", it.next());
		assertEquals("[b, c, h]", it.next());
		assertEquals("[b, c, i]", it.next());
		assertEquals("[b, d, f]", it.next());
		assertEquals("[b, d, g]", it.next());
		assertEquals("[b, d, h]", it.next());
		assertEquals("[b, d, i]", it.next());
		assertEquals("[b, e, f]", it.next());
		assertEquals("[b, e, g]", it.next());
		assertEquals("[b, e, h]", it.next());
		assertTrue(it.hasNext());
		assertEquals("[b, e, i]", it.next());
		assertFalse(it.hasNext());
	}
}
