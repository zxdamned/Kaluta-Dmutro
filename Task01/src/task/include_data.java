package task;

import java.util.Scanner;

public class include_data {
	public static String task() {
		Scanner console = new Scanner(System.in);
		System.out.print("Write your string: ");
		String s = console.nextLine();
		console.close();
		return s;
	}

}
