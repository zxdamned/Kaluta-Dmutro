package ex04;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/** ������������
 * (������ Command);
 * �������� ��'����
 * ����� ConsoleCommand
 * @see ConsoleCommand
 */
public class Menu implements Command {
	
	/** �������� ���������� ������;
	 * @see ConsoleCommand
	 */
	private List<ConsoleCommand> menu = new ArrayList<ConsoleCommand>();
	
	/** �������� ���� ������� � ��������
	* @param command ������ {@linkplain ConsoleCommand}
	* @return command
	*/
	public ConsoleCommand add(ConsoleCommand command) {
		menu.add(command);
		return command;
	}
	
	@Override
	public String toString() {
		String s = "Enter command...\n";
		for (ConsoleCommand c : menu) {
			s += c + ", ";
		}
		s += "'q'uit: ";
		return s;
	}
	
	@Override
	public void execute() {
		String s = null;
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		menu: while (true) {
			do {
				System.out.print(this);
				try {
					s = in.readLine();
				} catch (IOException e) {
					System.err.println("Error: " + e);
					System.exit(0);
				}
			} while (s.length() != 1);
			char key = s.charAt(0);
			if (key == 'q') {
				System.out.println("Exit.");
				break menu;
			}
	
			for (ConsoleCommand c : menu) {
				if (s.charAt(0) == c.getKey()) {
					c.execute();
					continue menu;
	
				}
			}
			System.out.println("Wrong command.");
			continue menu;
		}
	}
}	
