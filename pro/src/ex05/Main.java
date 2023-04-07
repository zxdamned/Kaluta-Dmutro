package ex05;

import ex02.View;
import ex02.ViewableResult;
import ex04.ChangeConsoleCommand;
import ex04.GenerateConsoleCommand;
import ex04.Menu;
import ex04.ViewConsoleCommand;

/** Обчислення і відображення
 * результатів; включає реалізацію
 * статичного метода main()
 * @author 34
 * @version 5.0
 * @see Main#main
 */

public class Main {
	
	/** Об'єкт, реалізуючий інтерфейс {@linkplain View};
	 * обслуговує колекцію об'єктів {@linkplain ex01.Item2d};
	 * ініціалізуєтся з допомогою Factory Method
	 */
	private View view = new ViewableResult().getView();
	
	/** Об'єкт класу {@linkplain Menu};
	 * макрокоманда (шаблон Command)
	 */
	private Menu menu = new Menu();
	
	/** Обробка команд користувача */
	public void run() {
		menu.add(new ViewConsoleCommand(view));
		menu.add(new GenerateConsoleCommand(view));
		menu.add(new ChangeConsoleCommand(view));
		menu.add(new ExecuteConsoleCommand(view));
		menu.execute();
	}
	
	/** Виконується при запуску програми
	 * @param args параметри запуску програми
	 */
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
}