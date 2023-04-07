package ex05;

import java.util.concurrent.TimeUnit;
import ex01.Item2d;
import ex02.ViewResult;
import ex04.Command;
import java.util.stream.*;


/** ������, ��������������� 
 * ����������� ������;
 * ������ Worker Thread
 * @author 34
 * @version 1.0
 * @see Command
 * @see CommandQueue
 */
public class MinMaxCommand implements Command /*, Runnable */ {
	
	/** ������ ��������� ������� �������� */
	private int resultMin = -1;
	
	/** ������ ��������� ������� �������� */
	private int resultMax = -1;
	
	/** ��������� ��������� ���������� */
	private int progress = 0;
	
	/** ��������� �������� ��'���� {@linkplain ex01.Item2d} */
	private ViewResult viewResult;
	
	/** ������� ���� {@linkplain MinMaxCommand#viewResult}
	 * @return �������� {@linkplain MinMaxCommand#viewResult}
	 */
	public ViewResult getViewResult() {
		return viewResult;
	}
	
	/** ���������� ���� {@linkplain MinMaxCommand#viewResult}
	 * @param viewResult �������� ��� {@linkplain MinMaxCommand#viewResult}
	 * @return ���� �������� {@linkplain MinMaxCommand#viewResult}
	 */
	public ViewResult setViewResult(ViewResult viewResult) {
		return this.viewResult = viewResult;
	}
	
	/** �������� ���� {@linkplain MinMaxCommand#viewResult}
	 * @param viewResult ��'��� ����� {@linkplain ViewResult}
	 */
	public MinMaxCommand(ViewResult viewResult) {
		this.viewResult = viewResult;
	}
	
	/** ������� ���������
	 * @return ���� {@linkplain MinMaxCommand#resultMin}
	 */
	public int getResultMin() {
		return resultMin;
	}
	
	/** ������� ���������
	 * @return ���� {@linkplain MinMaxCommand#resultMax}
	 */
	public int getResultMax() {
		return resultMax;
	}
	
	/** �������� ��������� ����������
	 * @return false - ���� ��������� ���������, ������ - true
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
		System.out.println("MinMax executed...");
		int idx = 0, size = viewResult.getItems().size();
		for (Item2d item : viewResult.getItems()) {
			if (IntStream.of(item.getY()).sum() < 0) {
				if ((resultMax == -1) ||
						(IntStream.of(viewResult.getItems().get(resultMax).getY()).sum() <
								IntStream.of(item.getY()).sum())) {
					resultMax = idx;
				}
			} else {
				if ((resultMin == -1) ||
						(IntStream.of(viewResult.getItems().get(resultMin).getY()).sum() >
						IntStream.of(item.getY()).sum())) {
					resultMin = idx;
				}
			}
			idx++;
			progress = idx * 100 / size;
			if (idx % (size / 5) == 0) {
				System.out.println("MinMax " + progress + "%");
			}
			try {
				TimeUnit.MILLISECONDS.sleep(5000 / size);
			} catch (InterruptedException e) {
				System.err.println(e);
			}
		}
		System.out.print("MinMax done. ");
		if (resultMin > -1) {
			String text = "";
			int []y = viewResult.getItems().get(resultMin).getY();
			for(int i=0; i<10;i++) 
			{
				text= text+i+ " -> "+y[i]+"\n";
			}
			System.out.print("Min positive #" + resultMin + " found: " +
					
					String.format("%s",
							text));
		} else {
			System.out.print("Min positive not found.");
		}
		if (resultMax > -1) {
			System.out.println(" Max negative #" + resultMax + " found: " +
					String.format("%.2f.",
							viewResult.getItems().get(resultMax).getY()));
		} else {
			System.out.println(" Max negative item not found.");
		}
		progress = 100;
	}
	
	/**
	@Override
	public void run() {
		execute();
	}
	/**/
}