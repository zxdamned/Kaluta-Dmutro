package ex04;

/** ���������� � �����������
 * ����������; ������ � ���� ���������
 * ���������� ������ main()
 * @author 34
 * @version 4.0
 * @see Main#main
 */
public class Main {
	
	/** ���������� ��� ������� ��������;
	 * ������� ����� {@linkplain Application#run()}
	 * @param args ��������� ������� ��������
	 */
	public static void main(String[] args) {
		Application app = Application.getInstance();
		app.run();
	}
}