import java.util.Scanner;
public class Triangle {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Input height of the triangle: ");
		int h = Integer.parseInt(sc.nextLine());
		
		for (int i = 1; i <= h; i++)
		{
			for(int j = 1; j <= h-i; j++)
				System.out.print(" ");
			for(int k =1; k<= 2*i -1; k++)
				System.out.print("*");
			System.out.print("\n");
		}
		
		
	}

}
