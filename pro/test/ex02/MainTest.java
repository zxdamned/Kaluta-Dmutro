package ex02;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import java.io.IOException;
import java.util.Random;

import ex01.Item2d;

/** ���������� ����������
* ����������� �����.
* @author 34
* @version 2.0
*/
public class MainTest 
{
	/** �������� ������� ��������������� ����� {@linkplain ViewResult} */
	@Test
	public void testCalc() 
	{
		ViewResult view = new ViewResult(5);
		view.init(90);
		Item2d item = new Item2d();
		int ctr = 0;
		item.setXY(0, 0);
		assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
		view.getItems().get(ctr).equals(item));
		ctr++;
		item.setXY(90, 1);
		assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
		view.getItems().get(ctr).equals(item));
		ctr++;
		item.setXY(180, 0);
		assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
		view.getItems().get(ctr).equals(item));
		ctr++;
		item.setXY(270, -1);
		assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
		view.getItems().get(ctr).equals(item));
		ctr++;
		item.setXY(360, 0);
		assertTrue("expected:<" + item + "> but was:<" + view.getItems().get(ctr) + ">",
		view.getItems().get(ctr).equals(item));
	}
	
	/** �������� �����������. ����������� ���������� �����. */
	@Test
	public void testRestore() 
	{
		ViewResult view1 = new ViewResult(1000);
		ViewResult view2 = new ViewResult();
		// �������� �������� ������� � ���������� ������ ����������� ���������
		Random random = new Random();
		view1.init(random.ints(0, 360).findFirst().getAsInt());
		// ��������� �������� view1.items
		try 
		{
			view1.viewSave();
		} catch (IOException e) 
		{
			Assert.fail(e.getMessage());
		}
		// �������� ��������� view2.items
		try 
		{
			view2.viewRestore();
		} catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}
		// ������� ����������� ������ ���������, ������ ��������
		assertEquals(view1.getItems().size(), view2.getItems().size());
		// ֳ �� �������� ������� ���� ����������.
		// ��� ����� ������� ��������� ����� equals
		assertTrue("containsAll()", view1.getItems().containsAll(view2.getItems()));
	}
}