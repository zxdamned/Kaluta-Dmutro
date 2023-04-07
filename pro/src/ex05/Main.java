package ex05;

import ex02.View;
import ex02.ViewableResult;
import ex04.ChangeConsoleCommand;
import ex04.GenerateConsoleCommand;
import ex04.Menu;
import ex04.ViewConsoleCommand;

/** ���������� � �����������
 * ����������; ������ ���������
 * ���������� ������ main()
 * @author 34
 * @version 5.0
 * @see Main#main
 */

public class Main {
	
	/** ��'���, ���������� ��������� {@linkplain View};
	 * ��������� �������� ��'���� {@linkplain ex01.Item2d};
	 * ����������� � ��������� Factory Method
	 */
	private View view = new ViewableResult().getView();
	
	/** ��'��� ����� {@linkplain Menu};
	 * ������������ (������ Command)
	 */
	private Menu menu = new Menu();
	
	/** ������� ������ ����������� */
	public void run() {
		menu.add(new ViewConsoleCommand(view));
		menu.add(new GenerateConsoleCommand(view));
		menu.add(new ChangeConsoleCommand(view));
		menu.add(new ExecuteConsoleCommand(view));
		menu.execute();
	}
	
	/** ���������� ��� ������� ��������
	 * @param args ��������� ������� ��������
	 */
	public static void main(String[] args) {
		Main main = new Main();
		main.run();
	}
}