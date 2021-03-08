import java.util.Scanner;
public class InputFromKeyboard {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner keyboard = new Scanner(System.in);
		
		System.out.println("What's your name? ");
		String name = keyboard.nextLine();
		System.out.println("How old are you? ");
		int age = Integer.parseInt(keyboard.nextLine());
		System.out.println("How tall are you? ");
		double height = Double.parseDouble(keyboard.nextLine());
		
		System.out.println("Mrs/Ms. " + name + ", " + age + " years old."
				+ "Your height is " + height);
	}

}
