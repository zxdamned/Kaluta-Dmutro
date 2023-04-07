package ex05;

import ex04.Command;

/** �����������
 * ������ ��� ���������
 * � ��������� �����
 * ���������� ������;
 * ������ Worker Thread
 * @author 34
 * @version 1.0
 * @see Command
 */

public interface Queue {
	/** ���� ���� ������ � �����;
	 * ������ Worker Thread
	 * @param cmd ������
	 */
	void put(Command cmd);
	/** ������� ������ �� �����;
	 * ������ Worker Thread
	 * @return ��������� ������
	 */
	Command take();
}