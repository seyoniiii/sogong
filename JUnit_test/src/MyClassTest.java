import static org.junit.Assert.*;

import org.junit.Test;


public class MyClassTest {
	@Test
	public void testLargerSame() {
		assertEquals(MyClass.larger(2, 2),2);
	}
	
	@Test
	public void testLargerNegative() {
		assertEquals(MyClass.larger(-2, 3),3);
	}
	
	@Test
	public void testLarger2() {
		assertEquals(MyClass.larger(10, 45),45);
	}
	
	@Test
	public void testLarger3() {
		assertEquals(MyClass.larger(6, -1),6);
	}
	
	// larger
	
	@Test
	public void testAbsNegative() {
		assertEquals(MyClass.abs(-1),1);
	}
	
	@Test
	public void testAbsPositive() {
		assertEquals(MyClass.abs(3),3);
	}
	
	//abstract
	//if
	@Test
	public void testMedian() {
		assertEquals(MyClass.median(2, 3, 5),3);
	}
	
	@Test
	public void testMedian1() {
		assertEquals(MyClass.median(4, 6, 8),6);
	}
	
	@Test
	public void testMedian2() {
		assertEquals(MyClass.median(4, 6, 5),5);
	}
	
	@Test
	public void testMedian3() {
		assertEquals(MyClass.median(2, 8, 1),2);
	}
	
	//else
	@Test
	public void testMedian4() {
		assertEquals(MyClass.median(10, 2, 15),10);
	}
	
	@Test
	public void testMedian5() {
		assertEquals(MyClass.median(10, 2, 7),7);
	}
	
	@Test
	public void testMedian6() {
		assertEquals(MyClass.median(10, 8, 7),8);
	}
	
	@Test
	public void testMedianAllSame() {
		assertEquals(MyClass.median(1, 1, 1),1);
	}
	
	//median
}
