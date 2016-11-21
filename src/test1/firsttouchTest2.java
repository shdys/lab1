package test1;
import static org.junit.Assert.*;
import org.junit.Test;
public class firsttouchTest2 {
	private static firsttouch puls = new firsttouch();
	@Test
	public void testExpression() {
		String Poly="6*x+2*x*z+3*y";
		String [] chuliarray={"!simplify","x=9"};
		assertEquals("54+18*z+3*y", puls.expression(chuliarray,Poly));
	}
}
