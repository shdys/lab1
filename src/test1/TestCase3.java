/**
 * 
 */
package test1;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author Draven
 *
 */
public class TestCase3 {

	@Test
	public void test() {
		firsttouch FirstTouch3 = new firsttouch();
		String DerivativeResult3 = FirstTouch3.derivative('x',"2*x*x*x");
		System.out.println(DerivativeResult3);
		assertEquals("6*x*x",DerivativeResult3);
		 
	}

}
