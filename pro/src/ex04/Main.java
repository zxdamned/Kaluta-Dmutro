package ex04;

/** Обчислення і відображення
 * результатів; включає в себе реалізацію
 * статичного методу main()
 * @author 34
 * @version 4.0
 * @see Main#main
 */
public class Main {
	
	/** Виконується при запуску програми;
	 * викликає метод {@linkplain Application#run()}
	 * @param args параметри запуску програми
	 */
	public static void main(String[] args) {
		Application app = Application.getInstance();
		app.run();
	}
}