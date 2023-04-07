package ex05;

import java.util.Vector;
import ex04.Command;

/** Створює обробник
 * потоку, виконуючого
 * об'єкти з інтерфейсом
 * Command; шаблон
 * Worker Thread
 * @author 34
 * @version 1.0
 * @see Command
 */

public class CommandQueue implements Queue {
	
	/** Черга задач */
	private Vector<Command> tasks;
	
	/** Прапорець очікування */
	private boolean waiting;
	
	/** Прапорець завершення */
	private boolean shutdown;
	
	/** Встановлює прапорець завершення */
	public void shutdown() {
		shutdown = true;
	}
	
	/** Ініціалізація {@linkplain CommandQueue#tasks}
	 * {@linkplain CommandQueue#waiting}
	 * {@linkplain CommandQueue#waiting};
	 * створює поток для класу {@linkplain CommandQueue.Worker}
	 */
	public CommandQueue() {
		tasks = new Vector<Command>();
		waiting = false;
		new Thread(new Worker()).start();
	}
	
	@Override
	public void put(Command r) {
		tasks.add(r);
		if (waiting) {
			synchronized (this) {
				notifyAll();
			}
		}
	}
	
	@Override
	public Command take() {
		if (tasks.isEmpty()) {
			synchronized (this) {
				waiting = true;
				try {
					wait();
				} catch (InterruptedException ie) {
					waiting = false;
				}
			}
		}
		return (Command)tasks.remove(0);
	}
	
	/** Обслуговує чергу
	 * задач; шаблон
	 * Worker Thread
	 * @author Danylo_Donets
	 * @version 1.0
	 * @see Runnable
	 */
	private class Worker implements Runnable {
		
		/** Вибирає із черги
		 * готові до виконання
		 * задачі; шаблон
		 * Worker Thread */
		public void run() {
			while (!shutdown) {
				Command r = take();
				r.execute();
	
			}
		}
	}
}