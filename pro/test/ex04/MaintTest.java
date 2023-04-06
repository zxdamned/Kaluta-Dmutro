package ex04;

import static org.junit.Assert.*;
import org.junit.Test;

import ex01.Item2d;
import ex02.ViewResult;

/** ���������� �����
 * ChangeItemCommand
 * @author 44
 * @version 4.0
 * @see ChangeItemCommand
 */

public class MainTest {

	/** �������� ������ {@linkplain ChangeItemCommand#execute()} */
	@Test
	public void testExecute() {
		ChangeItemCommand cmd = new ChangeItemCommand();
		cmd.setItem(new Item2d());
		double x, y, offset;
		for (int ctr = 0; ctr < 1000; ctr++) {
			cmd.getItem().setXY(x = Math.random() * 100.0, y = Math.random() * 100.0);
			cmd.setOffset(offset = Math.random() * 100.0);
			cmd.execute();
			assertEquals(x, cmd.getItem().getX(), .1e-10);
			assertEquals(y * offset, cmd.getItem().getY(), .1e-10);
		}
	}
	
	/** �������� ����� {@linkplain ChangeConsoleCommand} */
	@Test
	public void testChangeConsoleCommand() {
		ChangeConsoleCommand cmd = new ChangeConsoleCommand(new ViewResult());
		cmd.getView().viewInit();
		cmd.execute();
		assertEquals("'c'hange", cmd.toString());
		assertEquals('c', cmd.getKey());
	}

}
