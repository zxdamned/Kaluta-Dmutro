package ex04;
import ex02.View;

/** ��������� �������
 * Restore;
 * ������ Command
 * @author 34
 * @version 1.0
 */

public class RestoreConsoleCommand implements ConsoleCommand {
	/** ��'���, ���������� ��������� {@linkplain View};
	 * ��������� �������� ��'���� {@linkplain ex01.Item2d}
	 */
	private View view;
	
	/** ������� ���� {@linkplain RestoreConsoleCommand#view}
	 * @param view ��'���, ���������� ��������� {@linkplain View}
	 */
	public RestoreConsoleCommand(View view) {
		this.view = view;
	}
	
	@Override
	public char getKey() {
		return 'r';
	}
	
	@Override
	public String toString() {
		return "'r'estore";
	}
	
	@Override
	public void execute() {
		System.out.println("Restore last saved.");
		try {
			view.viewRestore();
		} catch (Exception e) {
			System.err.println("Serialization error: " + e);
		}
		view.viewShow();
	}
}