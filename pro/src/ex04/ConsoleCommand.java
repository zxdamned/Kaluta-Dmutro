package ex04;

/** Інтерфейс
 * консольної команди;
 * шаблон Command
 * @author 34
 * @version 1.0
 */
public interface ConsoleCommand extends Command {
	/** Гаряча клавіша команди;
	 * шаблон Command
	 * @return символ гарячої клавіши
	 */
	public char getKey();
}