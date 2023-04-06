package ex04;

import ex02.View;
import ex03.ViewableTable;

/** Формує і відображає
 * меню; реалізує шаблон
 * Singleton
 * @author 34
 * @version 1.0
 */

public class Application {
	
	/** Посилання на екземпляр класу Application; шаблон Singleton
	 * @see Application
	 */
	private static Application instance = new Application();
	
	/** Закритий конструктор; шаблон Singleton
	 * @see Application
	 */
	private Application() {}
	
	/** Повертає посилання на екземпляр класу Application;
	 * шаблон Singleton
	 * @see Application
	 */
	public static Application getInstance() {
		return instance;
	}
	
	/** Об'єкт, реалізуючий інтерфейс {@linkplain View};
	 * обслуговує колекцію об'єктів {@linkplain ex01.Item2d};
	 * ініціалізується з допомогою Factory Method
	 */
	private View view = new ViewableTable().getView();
	
	/** Об'єкт класу {@linkplain Menu};
	 * макрокоманда (шаблон Command)
	 */
	private Menu menu = new Menu();
	
	/** Обробка команд користувача
	 * @see Application
	 */
	public void run() {
		menu.add(new ViewConsoleCommand(view));
		menu.add(new GenerateConsoleCommand(view));
		menu.add(new ChangeConsoleCommand(view));
		menu.add(new SaveConsoleCommand(view));
		menu.add(new RestoreConsoleCommand(view));
		menu.execute();
	}
}