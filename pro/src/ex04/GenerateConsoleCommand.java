package ex04;

import ex02.View;

/** ��������� �������
 * Generate;
 * ������ Command
 * @author 34
 * @version 1.0
 */
public class GenerateConsoleCommand implements ConsoleCommand {
	
	/** ��'���, ���������� ��������� {@linkplain View};
	 * ��������� �������� ��'���� {@linkplain ex01.Item2d}
	 */
	private View view;

	/** �������� ���� {@linkplain GenerateConsoleCommand#view}
	 * @param view ��'���, ���������� ��������� {@linkplain View}
	 */
	public GenerateConsoleCommand(View view) {
		this.view = view;
	}

	@Override
	public char getKey() {
		return 'g';
	}

	@Override
	public String toString() {
		return "'g'enerate";
	}

	@Override
	public void execute() {
		System.out.println("Random generation.");
		view.viewInit();
		view.viewShow();
	}
}