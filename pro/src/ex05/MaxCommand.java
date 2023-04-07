package ex05;

import java.util.concurrent.TimeUnit;
import ex02.ViewResult;
import ex04.Command;
import java.util.stream.*;

/** Задача, використовується
 * обробником потоку;
 * шаблон Worker Thread
 * @author 34
 * @version 1.0
 * @see Command
 * @see CommandQueue
 */

public class MaxCommand implements Command /*, Runnable */ {
	
	/** Зберігає результат обробки колекції */
	private int result = -1;
	
	/** Прапорець готовності результату */
	private int progress = 0;
	
	/** Обслуговує колекцію об'єктів {@linkplain ex01.Item2d} */
	private ViewResult viewResult;
	
	/** Повертає поле {@linkplain MaxCommand#viewResult}
	 * @return значення {@linkplain MaxCommand#viewResult}
	 */
	public ViewResult getViewResult() {
		return viewResult;
	}
	
	/** Встановлює поле {@linkplain MaxCommand#viewResult}
	 * @param viewResult значення для {@linkplain MaxCommand#viewResult}
	 * @return нове значення {@linkplain MaxCommand#viewResult}
	 */
	public ViewResult setViewResult(ViewResult viewResult) {
		return this.viewResult = viewResult;
	}
	
	/** Ініціалізує поле {@linkplain MaxCommand#viewResult}
	 * @param viewResult об'єкт класу {@linkplain ViewResult}
	 */
	public MaxCommand(ViewResult viewResult) {
		this.viewResult = viewResult;
	}
	
	/** Повертає результат
	 * @return поле {@linkplain MaxCommand#result}
	 */
	public int getResult() {
		return result;
	}
	
	/** Перевіряє готовність результату
	 * @return false - якщо результат знайдений, інакше - true
	 * @see MaxCommand#result
	 */
	public boolean running() {
		return progress < 100;
	}
	
	/** Використовується обробником потоку {@linkplain CommandQueue};
	 * шаблон Worker Thread
	 */
	@Override
	public void execute() {
		progress = 0;
		System.out.println("Max executed...");
		int size = viewResult.getItems().size();
		result = 0;
		for (int idx = 1; idx < size; idx++) {
			if (IntStream.of(viewResult.getItems().get(result).getY()).sum() <
					IntStream.of(viewResult.getItems().get(idx).getY()).sum()) {
				result = idx;
			}
			progress = idx * 100 / size;
			if (idx % (size / 3) == 0) {
				System.out.println("Max " + progress + "%");
			}
			try {
				TimeUnit.MILLISECONDS.sleep(3000 / size);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}
		System.out.println("Max done. Item #" + result +
				" found: " + viewResult.getItems().get(result));
		progress = 100;
		}
		
	/**
	@Override
	public void run() {
		execute();
	}
	/**/
}