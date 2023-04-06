package ex04;

import ex02.View;

/** Консольна команда
 * View;
 * шаблон Command
 * @author 34
 * @version 1.0
 */

public class ViewConsoleCommand implements ConsoleCommand {
	/** Об'єкт, реалізуючий інтерфейс {@linkplain View};
	 * обслуговує колекцію об'єктів {@linkplain ex01.Item2d}
	 */
	private View view;

	/** Ініціалізує поле {@linkplain SaveConsoleCommand#view}
	 * @param view об'єкт, реалізуючий інтерфейс {@linkplain View}
	 */
	public ViewConsoleCommand(View view) {
		this.view = view;
	}

	@Override
	public char getKey() {
		return 'v';
	}

	@Override
	public String toString() {
		return "'v'iew";
	}

	@Override
	public void execute() {
		System.out.println("View current.");
		view.viewShow();
	}
}