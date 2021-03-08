import java.util.Scanner;
public class AddTwoMatrices {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Input number of rows of matrices : ");
		int rows = Integer.parseInt(sc.nextLine());
		System.out.print("Input number of columns of matrices : ");
		int columns = Integer.parseInt(sc.nextLine());
		
		
		int[][] m1 = new int[rows][columns];
		int[][] m2 = new int[rows][columns];
		int[][] m3 = new int[rows][columns];
		for(int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				System.out.print("Input m1[" + (i+1) + (j+1) +"] : ");
				m1[i][j] = Integer.parseInt(sc.nextLine());
			}
		}
		for(int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
			{
				System.out.print("Input m2[" + (i+1) + (j+1) +"] : ");
				m2[i][j] = Integer.parseInt(sc.nextLine());
				m3[i][j] = m1[i][j] + m2[i][j];
			}
		}
		
		
		//Print result
		
		for(int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
				System.out.print(" "+ m1[i][j]);
			System.out.println("");
		}
		for(int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
				System.out.print(" "+ m2[i][j]);
			System.out.println("");
		}
		System.out.println("Result : ");
		for(int i = 0; i < rows; i++)
		{
			for (int j = 0; j < columns; j++)
				System.out.print(" "+ m3[i][j]);
			System.out.println("");
		}
		
		
	}

}
