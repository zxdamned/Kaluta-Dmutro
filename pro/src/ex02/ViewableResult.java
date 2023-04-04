package ex02;

/** ConcreteCreator
 * (шаблон проектування
 * Factory Method)<br>
 * Об'являє метод,
 * "фабрикуючий" об'єкти
 * @author Danylo_Donets
 * @version 1.0
 * @see Viewable
 * @see ViewableResult#getView()
 */

public class ViewableResult implements Viewable 
{
	/** Створює відображаємий об'єкт {@linkplain ViewResult} */
	@Override
	public View getView() 
	{
		return new ViewResult();
	}
}