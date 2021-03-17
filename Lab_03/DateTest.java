import java.util.Scanner;
public class DateTest {
	static void print(MyDate date) {
        int day = date.getDay();
        int month = date.getMonth();
        int year = date.getYear();
        System.out.println("Date dd/mm/yyyy : " + day + "/" + month + "/" + year);

    }
	static String Accept(){
        Scanner scanner = new Scanner(System.in);
        String time = scanner.nextLine();
        return time;

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

        MyDate curDate = new MyDate();
        print(curDate);
        
        
        //day, month, year
        MyDate Date1 = new MyDate(35,3,2000);
        print(Date1);
        MyDate Date2 = new MyDate(30,3,2000);
        print(Date2);
        MyDate Date3 = new MyDate(29,2,2001);
        print(Date3);
        MyDate Date4 = new MyDate(30,16,-2000);
        print(Date4);
        
        System.out.println("Enter string date(mm/dd/yyyy): ");
        String InputDate = Accept();
        MyDate StringDate = new MyDate(InputDate);
        print(StringDate);
	}

}
