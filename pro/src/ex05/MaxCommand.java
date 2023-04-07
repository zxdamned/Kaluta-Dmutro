package ex05;

import java.util.concurrent.TimeUnit;
import ex02.ViewResult;
import ex04.Command;
import java.util.stream.*;

/** ������, ���������������
 * ���������� ������;
 * ������ Worker Thread
 * @author 34
 * @version 1.0
 * @see Command
 * @see CommandQueue
 */

public class MaxCommand implements Command /*, Runnable */ {
	
	/** ������ ��������� ������� �������� */
	private int result = -1;
	
	/** ��������� ��������� ���������� */
	private int progress = 0;
	
	/** ��������� �������� ��'���� {@linkplain ex01.Item2d} */
	private ViewResult viewResult;
	
	/** ������� ���� {@linkplain MaxCommand#viewResult}
	 * @return �������� {@linkplain MaxCommand#viewResult}
	 */
	public ViewResult getViewResult() {
		return viewResult;
	}
	
	/** ���������� ���� {@linkplain MaxCommand#viewResult}
	 * @param viewResult �������� ��� {@linkplain MaxCommand#viewResult}
	 * @return ���� �������� {@linkplain MaxCommand#viewResult}
	 */
	public ViewResult setViewResult(ViewResult viewResult) {
		return this.viewResult = viewResult;
	}
	
	/** �������� ���� {@linkplain MaxCommand#viewResult}
	 * @param viewResult ��'��� ����� {@linkplain ViewResult}
	 */
	public MaxCommand(ViewResult viewResult) {
		this.viewResult = viewResult;
	}
	
	/** ������� ���������
	 * @return ���� {@linkplain MaxCommand#result}
	 */
	public int getResult() {
		return result;
	}
	
	/** �������� ��������� ����������
	 * @return false - ���� ��������� ���������, ������ - true
	 * @see MaxCommand#result
	 */
	public boolean running() {
		return progress < 100;
	}
	
	/** ��������������� ���������� ������ {@linkplain CommandQueue};
	 * ������ Worker Thread
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