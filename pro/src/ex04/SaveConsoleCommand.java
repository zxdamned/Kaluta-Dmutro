package ex04;

import java.io.IOException;
import ex02.View;

/** ��������� �������
 * Save;
 * ������ Command
 * @author 34
 * @version 1.0
 */

public class SaveConsoleCommand implements ConsoleCommand {
	/** ��'���, ���������� ��������� {@linkplain View};
	 * ��������� �������� ��'���� {@linkplain ex01.Item2d}
	 */
	private View view;

	/** �������� ���� {@linkplain SaveConsoleCommand#view}
	 * @param view ��'���, ���������� ��������� {@linkplain View}
	 */
	public SaveConsoleCommand(View view) {
		this.view = view;
	}

	@Override
	public char getKey() {
		return 's';
	}

	@Override
	public String toString() {
		return "'s'ave";
	}

	@Override
	public void execute() {
		System.out.println("Save current.");
		try {
			view.viewSave();
		} catch (IOException e) {
			System.err.println("Serialization error: " + e);
		}
		view.viewShow();
	}
}