package test1;
import static org.junit.Assert.*;
import org.junit.Test;
public class firsttouchTest4 {
	private static firsttouch puls = new firsttouch();
	@Test
	public void testExpression() {
		String Poly="6+x*2+3*y";
		String [] chuliarray={"2*x+2*y"};
		assertEquals("6+x*2+3*y", puls.expression(chuliarray,Poly));
	}
}
