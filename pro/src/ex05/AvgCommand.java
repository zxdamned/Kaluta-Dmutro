package ex05;

import java.util.concurrent.TimeUnit;
import ex01.Item2d;
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

public class AvgCommand implements Command /*, Runnable */ {
	
	/** Зберігає результат обробки колекії */
	private double result = 0.0;
	
	/** Прапорець готовності результату */
	private int progress = 0;
	
	/** Обслугвує колекцію об'єктів {@linkplain ex01.Item2d} */
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
	
	/** ініціалізує поле {@linkplain MaxCommand#viewResult}
	 * @param viewResult об'єкт класу {@linkplain ViewResult}
	 */
	public AvgCommand(ViewResult viewResult) {
		this.viewResult = viewResult;
	}
	
	/** Повертає результат
	 * @return поле {@linkplain MaxCommand#result}
	 */
	public double getResult() {
		return result;
	}
	
	/** Проверяет готовность результата
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
		System.out.println("Average executed...");
		result = 0;
		int idx = 1, size = viewResult.getItems().size();
		for (Item2d item : viewResult.getItems()) {
			result += IntStream.of(item.getY()).sum();
			
			progress = idx * 100 / size;
			if (idx++ % (size / 2) == 0) {
				System.out.println("Average " + progress + "%");
			}
			try {
	
				TimeUnit.MILLISECONDS.sleep(2000 / size);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}
		result /= size;
		System.out.println("Average done. Result = " + String.format("%.2f",result));
		progress = 100;
	}
	
	/**
	@Override
	public void run() {
		execute();
	}
	/**/
}