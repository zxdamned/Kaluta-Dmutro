package ex02;

import java.io.IOException;

/** Product
 * (шаблон проектування
 * Factory Method)<br>
 * Інтерфейс "фабрикуємих"
 * об'єктів<br>
 * Об'являє методи
 * відображення об'єктів
 * @author Danylo_Donets
 * @version 1.0
 */
public interface View 
{
	/** Відображає заголовок */
	public void viewHeader();
	
	/** Відображає основну частину */
	public void viewBody();
	
	/** Відображає закінчення */
	public void viewFooter();
	
	/** Відображає об'єкт повністю */
	public void viewShow();
	
	/** Виконує ініціалізацію */
	public void viewInit();
	
	/** Зберігає дані для наступного відновлення 
	 *@throws IOException -збережені дані 
	 */
	public void viewSave() throws IOException;
	
	/** Відновлює раніше збережені дані 
	 *@throws Exception -відновленя збереженні дані  
	 */
	public void viewRestore() throws Exception;
}