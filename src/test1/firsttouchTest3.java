package test1;
import static org.junit.Assert.*;
import org.junit.Test;
public class firsttouchTest3 {
	private static firsttouch puls = new firsttouch();
	@Test
	public void testExpression() {
		String Poly="6*x+x*z+3*y";
		String [] chuliarray={"!simplify","x=12"};
		assertEquals("72+12*z+3*y", puls.expression(chuliarray,Poly));
	}
} 
