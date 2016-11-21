package test1;
import static org.junit.Assert.*;
import org.junit.Test;
public class firsttouchTest5 {
	private static firsttouch puls = new firsttouch();
	@Test
	public void testExpression() {
		String Poly="6+x*2*y+3*y";
		String [] chuliarray={"!simplify","xx=2"};
		assertEquals("Wrong", puls.expression(chuliarray,Poly));
	}
}