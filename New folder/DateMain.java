import java.util.Arrays;
import java.util.Scanner;
public class DateMain {
	
	public static void printList(MyDate [] l)
	{
		for (int i = 0; i < l.length; i ++)
			l[i].print();
	}
	
	public static String Accept(){
        Scanner scanner = new Scanner(System.in);
        String time = scanner.nextLine();
        return time;

    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

        MyDate curDate = new MyDate();
        curDate.print();
        curDate.print_format();
        
        
        //day, month, year
        MyDate Date1 = new MyDate(35,3,2000);
        Date1.print();
        MyDate Date2 = new MyDate(30,3,2000);
        Date2.print();
        MyDate Date3 = new MyDate(29,2,2001);
        Date3.print();
        MyDate Date4 = new MyDate(30,16,-2000);
        Date4.print();
        
        System.out.println("Enter string date(mm/dd/yyyy): ");
        String InputDate = Accept();
        MyDate StringDate = new MyDate(InputDate);
        StringDate.print();
        
        
        MyDate d1 = new MyDate("second", "s", "dd");
        d1.print();
        MyDate d2 = new MyDate("thirdteenth", "Sept.", "twenty one");
        d2.print();
        MyDate d3 = new MyDate("thirdty", "Jan.", "twenty thirdty-one");
        d3.print();
        MyDate d4 = new MyDate("second", "1", "twenty hundred");
        d4.print();
        
       
        
        MyDate [] arr = { new MyDate(20,3,2020), new MyDate(20,3,2019),
        		new MyDate(20,7,2019),  new MyDate(27,3,2018)};

        DateUtils du = new DateUtils();
        printList(arr); 
        du.sort_date(arr);
        printList(arr);
		
		
		     
	}

}