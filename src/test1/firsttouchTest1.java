package test1;
import static org.junit.Assert.*;
import org.junit.Test;
public class firsttouchTest1 {
	private static firsttouch puls = new firsttouch();
	@Test
	public void testExpression() {
		String Poly="6*x+3*y";
		String [] chuliarray={"!simplify","x=2"};
		assertEquals("12+3*y", puls.expression(chuliarray,Poly));
	}
}
