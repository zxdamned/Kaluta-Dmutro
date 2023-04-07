package ex05;

import java.util.Vector;
import ex04.Command;

/** ������� ��������
 * ������, �����������
 * ��'���� � �����������
 * Command; ������
 * Worker Thread
 * @author 34
 * @version 1.0
 * @see Command
 */

public class CommandQueue implements Queue {
	
	/** ����� ����� */
	private Vector<Command> tasks;
	
	/** ��������� ���������� */
	private boolean waiting;
	
	/** ��������� ���������� */
	private boolean shutdown;
	
	/** ���������� ��������� ���������� */
	public void shutdown() {
		shutdown = true;
	}
	
	/** ����������� {@linkplain CommandQueue#tasks}
	 * {@linkplain CommandQueue#waiting}
	 * {@linkplain CommandQueue#waiting};
	 * ������� ����� ��� ����� {@linkplain CommandQueue.Worker}
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
	
	/** ��������� �����
	 * �����; ������
	 * Worker Thread
	 * @author Danylo_Donets
	 * @version 1.0
	 * @see Runnable
	 */
	private class Worker implements Runnable {
		
		/** ������ �� �����
		 * ����� �� ���������
		 * ������; ������
		 * Worker Thread */
		public void run() {
			while (!shutdown) {
				Command r = take();
				r.execute();
	
			}
		}
	}
}