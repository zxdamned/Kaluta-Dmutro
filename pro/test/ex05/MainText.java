package ex05;

import static org.junit.Assert.*;
import java.util.concurrent.TimeUnit;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import ex02.ViewResult;

/** ����������
 * ����������� �����
 * @author 34
 * @version 5.0
 * @see CommandQueue
 * @see MaxCommand
 * @see AvgCommand
 * @see MinMaxCommand
 */

public class MainTest {
	private final static int N = 1000;
	private static ViewResult view = new ViewResult(N);
	private static MaxCommand max1 = new MaxCommand(view);
	private static MaxCommand max2 = new MaxCommand(view);
	private static AvgCommand avg1 = new AvgCommand(view);
	private static AvgCommand avg2 = new AvgCommand(view);
	private static MinMaxCommand min1 = new MinMaxCommand(view);
	private static MinMaxCommand min2 = new MinMaxCommand(view);
	private CommandQueue queue = new CommandQueue();
	
	/** ���������� ������ */
	@BeforeClass
	public static void setUpBeforeClass() {
		view.viewInit();
		assertEquals(N, view.getItems().size());
	}
	
	/** ���������� ������� */
	@AfterClass
	public static void tearDownAfterClass() {
		assertEquals(max1.getResult(), max2.getResult());
		assertEquals(avg1.getResult(), avg2.getResult(), .1e-10);
		assertEquals(min1.getResultMax(), min2.getResultMax());
		assertEquals(min1.getResultMin(), min2.getResultMin());
	}
	
	/** �������� ������� ��������������� ����� {@linkplain MaxCommand} */
	@Test
	public void testMax() {
		max1.execute();
		assertTrue( max1.getResult() > -1);
	}
	
	/** �������� ������� ��������������� ����� {@linkplain AvgCommand} */
	@Test
	public void testAvg() {
		avg1.execute();
		assertTrue( avg1.getResult() != 0.0);
	}
	
	/** �������� ������� ��������������� ����� {@linkplain MinMaxCommand} */
	@Test
	public void testMin() {
		min1.execute();
		assertTrue( min1.getResultMin() > -1);
		assertTrue( min1.getResultMax() > -1);
	}
	
	/** �������� ������� ��������������� �����
	* {@linkplain CommandQueue} � ������� {@linkplain MaxCommand}
	*/
	@Test
	public void testMaxQueue() {
		queue.put(max2);
		try {
			while (max2.running()) {
				TimeUnit.MILLISECONDS.sleep(100);
			}
			queue.shutdown();
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			fail(e.toString());
		}
	}
	
	/** �������� ������� ��������������� �����
	 * {@linkplain CommandQueue} � ������� {@linkplain AvgCommand}
	 */
	@Test
	public void testAvgQueue() {
		queue.put(avg2);
		try {
			while (avg2.running()) {
				TimeUnit.MILLISECONDS.sleep(100);
			}
			queue.shutdown();
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			fail(e.toString());
		}
	}
	
	/** �������� ������� ��������������� �����
	 * {@linkplain CommandQueue} � ������� {@linkplain MinMaxCommand}
	 */
	@Test
	public void testMinQueue() {
		queue.put(min2);
		try {
			while (min2.running()) {
				TimeUnit.MILLISECONDS.sleep(100);
			}
			queue.shutdown();
			TimeUnit.SECONDS.sleep(1);
		} catch (InterruptedException e) {
			fail(e.toString());
		}
	}
}