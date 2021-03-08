import java.util.Scanner;
public class NumDays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int num_days = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Input month : ");
		String month = sc.nextLine();
		
		String[][] months = {{"January", "Jan.", "Jan", "1", "31"},
				{"February", "Feb.", "Feb", "2", "28"},
				{"March", "Mar.","Mar", "3", "31"},
				{"April", "Apr.", "Apr", "4", "30"},
				{"May","5", "31"},
				{"June", "Jun", "6", "30"},
				{"July", "Jul", "7", "31"},
				{"August", "Aug.", "Aug", "8", "31"},
				{"September", "Sept.", "Sep","9", "30"},
				{"October", "Oct.", "Oct", "10", "31"},
				{"November", "Nov.", "Nov", "11", "30"},
				{"December", "Dec.", "Dec", "12", "31"}};
		
		for (int i = 0; i < months.length;i++)
			for( int j = 0; j < months[i].length;j++)
				if (months[i][j].equals(month))
				{
					month = months[i][months[i].length-2];
					num_days = Integer.parseInt(months[i][months[i].length-1]);
					break;
				}
		
		
		int year;
		do {
			System.out.println("Input year (enter all the digits): ");
			year = Integer.parseInt(sc.nextLine());
			if (year < 0)
				System.out.println("Invalid year. Please input again.");
		}while(year<0);
		
		
		
		if (month == "2")
			if ((year % 400 == 0) || (year % 4 == 0 &&  year % 100 != 0 ))
				num_days = 29;
			else
				num_days = 28;
		
		System.out.print("The number of days of month " + month + " year " + year + " is : " + num_days);
			
			
	}

}
