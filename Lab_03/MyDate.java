import java.util.Arrays;
import java.util.List;
import java.time.LocalDate;
import java.util.Scanner;
public class MyDate {
	private int day;
	private int month;
	private int year;
	
	public MyDate(){
		this.day = LocalDate.now().getDayOfMonth();
		this.month = LocalDate.now().getMonthValue();
		this.year = LocalDate.now().getYear();
	}
    public MyDate(int day, int month, int year){
        setMonth(month);
        setYear(year);
        setDay(day);
    }
    public MyDate(String date){
    	// format : mm dd yyyy
        // date : January 1st 2000 or Jan. 1st 2000...
        int [] Date = get_date_from_str(date);
        if(Date != null){
            month = Date[0];
            day = Date[1];
            year = Date[2];
        }
    }


	public int getDay() {
		return day;
	}

	public void setDay(int day) {
        if(day >= 1 && day <= getNumDays(month,year))
            this.day = day;
        else {
            System.out.println("Error: Invalid Day.");
        }
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
        if(month >=1 && month <=12)
            this.month = month;
        else {
            System.out.println("Error: Invalid Month.");
        }
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
        if(year >=0 )
            this.year = year;
        else {
            System.out.println("Error: Invalid Year.");
        }
	}
	
	private int [] get_date_from_str(String date)
	{
		String[] dates = date.split("\\s");
        if(dates.length < 3) {
            System.out.println("Error format.");
            return null;
        }
        String month = dates[0];
        String day = dates[1];
        String year = dates[2];
        
        int m = checkStringMonth(month);
        if (m == 0) 
        {
            System.out.println(" Invalid Month");
            return null;
        }
        
        int y = 0;
        if(isNumeric(year)) {
            y = Integer.parseInt(year);
            if(y<0)
            {
                System.out.println(" Invalid Year");
                return null;
            }
        }
        else
        {
        	System.out.println(" Invalid Year");
        	return null;
        }
        int d = checkStringDay(day, m, y);
        if (d == 0)
        {
        	System.out.println(" Invalid Day");
        	return null;
        }
        	

        int[] Date = {m, d, y};
            return Date;       
	}
	private int getNumDays(int month, int year)
	{
		int numdays = 0;
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
				if (months[i][months[i].length-2].equals(Integer.toString(month)))
				{
					numdays = Integer.parseInt(months[i][months[i].length-1]);
					break;
				}
		if (month == 2)
			if ((year % 400 == 0) || (year % 4 == 0 &&  year % 100 != 0 ))
				numdays = 29;
			else
				numdays = 28;
		
		return numdays;
	}
	
    
    
    private int checkStringMonth(String month) {
    	if(isNumeric(month)&&Integer.parseInt(month)>=1&&Integer.parseInt(month)<=12)
            return Integer.parseInt(month);
    	
    	// from lab 02
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
					return Integer.parseInt(months[i][months[i].length-2]);
				}
    	
    	return 0;	
    }
    private int checkStringDay(String day, int m, int y)
    {
    	int stt = 0;
    	if(isNumeric(day))
    		stt = 1;
            
    	String tmp = day.substring(day.length()-2).toLowerCase();
        if(tmp.equals("st") || tmp.equals("nd") || tmp.equals("rd")||tmp.equals("th")){
            day = day.substring(0,day.length()-2);
        }
        if(isNumeric(day))
        	stt = 1;
        else
        	stt = 0;
        int d = Integer.parseInt(day);
        
        if(d <= 0 || d > getNumDays(m,y)) {
        	stt = 0;
        	System.out.print(" Invalid Date ");
        }
        else 
        	stt = 1;
        if (stt == 1)
        {
        	return d;
        }
        
        return 0;
    }
    
    private boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


}
