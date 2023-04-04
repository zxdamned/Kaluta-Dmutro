package ex02;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/** ���������� � ����������� ����������<br>
 * ������ ��������� ���������� ������ main()
 * @author Danylo_Donets
 * @version 2.0
 * @see Main#main
 */
public class Main 
{
	
	/** ��'���, ���������� ��������� {@linkplain View};
	 * ��������� �������� ��'���� {@linkplain ex01.Item2d}
	 */
	private View view;
	
	/** �������� ���� {@linkplain Main#view view}. 
	 *@param view - �������� ���� ��������. 
	 */
	public Main(View view) 
	{
		this.view = view;
	}
	
	/** ³������� ����. */
	protected void menu() 
	{
		String s = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		do 
		{
			do 
			{
				System.out.println("Enter command...");
				System.out.print("'q'uit, 'v'iew, 'g'enerate, 's'ave, 'r'estore: ");
				try 
				{
					s = in.readLine();
				} catch(IOException e) {
					System.out.println("Error: " + e);
					System.exit(0);
				}
			} while (s.length() != 1);
			switch (s.charAt(0)) 
			{
			case 'q':
				System.out.println("Exit.");
				break;
			case 'v':
				System.out.println("View current.");
				view.viewShow();
				break;
			case 'g':
				System.out.println("Random generation.");
				view.viewInit();
				view.viewShow();
				break;
			case 's':
				System.out.println("Save current.");
				try 
				{
					view.viewSave();
				} catch (IOException e) 
				{
					System.out.println("Serialization error: " + e);
				}
	
				view.viewShow();
				break;
			case 'r':
				System.out.println("Restore last saved.");
				try 
				{
					view.viewRestore();
				} catch (Exception e) 
				{
					System.out.println("Serialization error: " + e);
				}
	
				view.viewShow();
				break;
			default:
				System.out.println("Wrong command.");
			}
		} while(s.charAt(0) != 'q');
	}
	
	/** ���������� �� ��� ������� ��������;
	 * ������� ����� {@linkplain Main#menu() menu()}
	 * @param args - ��������� ������� ��������.
	 */
	public static void main(String[] args) {
		Main main = new Main(new ViewableResult().getView());
		main.menu();
	}
}