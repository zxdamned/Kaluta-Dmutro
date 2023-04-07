package ex05;

import ex04.Command;

/** Представляє
 * методи для додавання
 * і видалення задач
 * обробником потоку;
 * шаблон Worker Thread
 * @author 34
 * @version 1.0
 * @see Command
 */

public interface Queue {
	/** Додає нову задачу в чергу;
	 * шаблон Worker Thread
	 * @param cmd задача
	 */
	void put(Command cmd);
	/** Видаляє задачу із черги;
	 * шаблон Worker Thread
	 * @return Видаляєма задача
	 */
	Command take();
}