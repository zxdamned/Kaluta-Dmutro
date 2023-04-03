package ex01;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * ���������� �� ����������� ����������. ������ ��������� ���������� ������
 * main().
 * 
 * @author 34
 * @version 1.0
 * @see Main#main
 */

public class Main 
{
	/**
	 * ��'��� ����� {@linkplain Calc}.<br>
	 * ����� ������ ���. ��������.
	 */

	private Calc calc = new Calc();

	/** ³������� ����. */
	private void menu() 
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
				} catch (IOException e) 
				{
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
				calc.show();
				break;
			case 'g':
				Random random = new Random();
				System.out.println("Random generation.");
				calc.init(random.ints(0, 360).findFirst().getAsInt());
				calc.show();
				break;
			case 's':
				System.out.println("Save current.");
				try 
				{
					calc.save();
				} catch (IOException e)
				{
					System.out.println("Serialization error: " + e);
				}
				calc.show();
				break;
			case 'r':
				System.out.println("Restore last saved.");
				try 
				{
					calc.restore();
				} catch (Exception e) 
				{
					System.out.println("Serialization error: " + e);
				}
				calc.show();
				break;
			default:
				System.out.print("Wrong command. ");
			}
		} while (s.charAt(0) != 'q');
	}

	/**
	 * ���������� ��� �������.������������ �������� ������� ��� �����
	 * ���������. ���������� ��������� ���������� �� �����.
	 * 
	 * @param args - ��������� ������� ��������.
	 */

	public static void main(String[] args)
	{
		Main main = new Main();
		main.menu();
	}
}