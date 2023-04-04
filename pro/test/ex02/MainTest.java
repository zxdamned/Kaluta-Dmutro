package ex02;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import java.io.IOException;
import java.util.Random;

import ex01.Item2d;

/** Виконується тестування
* розроблених класів.
* @author Danylo_Donets
* @version 2.0
*/
public class MainTest 
{
	/** перевірка основної функціональності класа {@linkplain ViewResult} */
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
	
	/** Перевірка сериалізації. Коректність відновлення даних. */
	@Test
	public void testRestore() 
	{
		ViewResult view1 = new ViewResult(1000);
		ViewResult view2 = new ViewResult();
		// Знайдемо значення функції з випадковим кроком збільшування аргумента
		Random random = new Random();
		view1.init(random.ints(0, 360).findFirst().getAsInt());
		// Збережемо колекцію view1.items
		try 
		{
			view1.viewSave();
		} catch (IOException e) 
		{
			Assert.fail(e.getMessage());
		}
		// Загрузим коллекцию view2.items
		try 
		{
			view2.viewRestore();
		} catch (Exception e) 
		{
			Assert.fail(e.getMessage());
		}
		// Повинні завантажити стільки документів, скільки зберігали
		assertEquals(view1.getItems().size(), view2.getItems().size());
		// Ці всі елементи повинні бути однаковими.
		// Для цього потрібно визначити метод equals
		assertTrue("containsAll()", view1.getItems().containsAll(view2.getItems()));
	}
}