package ex01;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import junit.framework.Assert;
import java.io.IOException;
import ex01.Calc;

/** Виконує тестування розроблених класів.
 * @author Danylo_Donets
 * @version 1.0
 */
public class MainTest 
{
	/** Перевірка основної функціональності класу {@linkplain Calc} */
	@Test
	public void testCalc() 
	{
		Calc calc = new Calc();
		calc.init(0);
		assertEquals(0, calc.getResult().getY(), .1e-10);
		calc.init(90);
		assertEquals(1, calc.getResult().getY(), .1e-10);
		calc.init(180);
		assertEquals(0, calc.getResult().getY(), .1e-10);
		calc.init(270);
		assertEquals(-1, calc.getResult().getY(), .1e-10);
		calc.init(360);
		assertEquals(0, calc.getResult().getY(), .1e-10);
	}
	
	/** Перевірка сериалізасії. Корекстність відновлення даних. */
	@Test
	public void testRestore() 
	{
		Calc calc = new Calc();
		int x
		int []y = new int [10];
		for(int ctr = 0; ctr < 1000; ctr++) 
		{
			Random random = new Random();
			x = random.ints(0, 360).findFirst().getAsInt();
			y = calc.init(x);
			try 
			{
				calc.save();
			} catch (IOException e) 
			{
				Assert.fail(e.getMessage());
			}
			calc.init(Math.random() * 360);
			try 
			{
				calc.restore();
			} catch (Exception e) 
			{
				Assert.fail(e.getMessage());
			}
			assertEquals(y, calc.getResult().getY(), .1e-10);
			assertEquals(x, calc.getResult().getX(), .1e-10);
		}
	}
}