package hust.soict.hedspi.aims.utils;


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
        if (this.getMonth() != 0) // 0 means error
        {
        	setYear(year);
        	if (this.getYear() != 0)
        		setDay(day);
        } 
    }
    public MyDate(String date){
    	// format : mm dd yyyy
        // date : January 1st 2000 or Jan. 1st 2000...
        int [] Date = get_date_from_str(date);
        if(Date != null){
            this.month = Date[0];
            this.day = Date[1];
            this.year = Date[2];
        }
    }
    public MyDate(String day, String month, String year)
    {
    	day = day.toLowerCase();
    	//month = month.toLowerCase();
    	year = year.toLowerCase();
    	
    	int d = 0, m = 0, y = 0;
    	
    	String [] day_str = {"first", "second", "third", "foutth", "fifth",
    			"sixth", "seventh", "eighth", "ninth", "tenth", "eleventh", "twelfth",
    			"thirdteenth", "fourteenth", "fiveteenth", "sixteenth", "seventeenth",
    			"eighteenth", "nineteenth", "twentieth", "twenty-first",
    			"twenty-second", "twenty-third", "twenty-foutth", "twenty-fifth",
    			"twenty-sixth", "twenty-seventh", "twenty-eighth", "twenty-nineth",
    			"thirdty", "thirdty_first"};
    	for (int i = 0; i < day_str.length; i++)
    	{
    		if (day_str[i].equals(day))
    		{
    			d = i+1;
    			break;
    		}	
    	}
    	if (d == 0)
    	{
    		System.out.println("Invalid Day" + d);
    		return;
    	}
    	m = checkStringMonth(month);
    	if (m == 0 )
    	{
    		System.out.println("Invalid month" + m);
    		return;
    	}
    	
    	String [] year_str = {"one", "two", "three", "four", "five", "six",
    			"seven", "eight", "nine", "ten", "eleven", "twelve", "thirdteen",
    			"twenty", "thirdty", "forty", "fifty", "sixty", "eighty", "ninety"};
    	String [] years = year.split(" ");
    	if (years[0].equals("twenty"))
    	{
    		if (years.length > 1)
    		{
    		String [] years_2 = years[1].split("-");
    		
    		for (int i = 0; i < year_str.length; i++)
    		{
    			if (year_str[i].equals(years[1]))
    			{
    				y = 2000 + i + 1;
    				break;
    			}
    			if (years_2.length == 2)
    				if (year_str[i].equals(years_2[1]))
    				{
    					for(int j = 13; j < year_str.length; j++)
    						if (year_str[j].equals(years_2[0]))
    						{
    								y = 2000 + (j-11)*10 + i + 1;	
    								break;
    						}
    				}
    		}
    		}
    	}
    	if (year.equals("two thousand") || year.equals("twenty hundred"))
    	{
    		y = 2000;
    	}
    	if (y == 0)
    	{
    		System.out.println("Invalid year" + y);
    		return;
    	}
        this.setMonth(m);
        this.setYear(y);
        this.setDay(d);
    }
    

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
        if(day >= 1 && day <= getNumDays(month,year))
            this.day = day;
        else {
            System.out.println("Invalid Day " + day);
        }
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
        if(month >=1 && month <=12)
            this.month = month;
        else {
            System.out.println("Invalid Month" + month);
        }
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
        if(year >=0 )
            this.year = year;
        else {
            System.out.println("Error: Invalid Year." + year);
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
        
        int y = 0;
        if(isNumeric(year)) {
            y = Integer.parseInt(year);
            if(y<0)
            {
                System.out.println(" Invalid Year" + y);
                return null;
            }
        }
        else
        {
        	System.out.println(" Invalid Year" + y);
        	return null;
        }
        
        int m = checkStringMonth(month);
        if (m == 0) 
        {
            System.out.println(" Invalid Month" + m);
            return null;
        }
        
        
        int d = checkStringDay(day, m, y);
        if (d == 0)
        {
        	System.out.println(" Invalid Day" + d);
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
        	System.out.print(" Invalid Date " + d);
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
    private String print_day(int d)
    {
    	if (d == 0)
    		return null;
    	if (d == 1)
    		return "1st";
    	if (d == 2)
    		return "2nd";
    	if (d == 3)
    		return "3rd";
    	else
    		return ""+d+"th";    	
    }
    private String print_month(int m,  int status)
    {
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
    	if (m == 0)
    		return null;
    	if (status == 0)
    		return months[m-1][0];
    	if (status == 3 || status == 4)
    		return months[m - 1][2];
    	return null;
    }

    
    public String print() {
        int d = this.getDay();
        int m = this.getMonth();
        int y = this.getYear();
        
        int status = 0;
        String day = print_day(d);
        String month = print_month(m, status);
        System.out.println("Date : " + month + " " + day + " " + year);
        return "" + month + " " + day + " " + year;
    }
    
    public void print_format()
    {
    	 int d = this.getDay();
         int m = this.getMonth();
         int y = this.getYear();
         
         System.out.println("Choose format");
         System.out.println(" Format 1 : yyyy-MM-dd 1930-02-03");
         System.out.println(" Format 2 : d/M/yyyy 3/2/1930");
         System.out.println(" Format 3 : dd-MMM-yyyy 03-Feb-1930");
         System.out.println(" Format 4 :  MMM d yyyy Feb 3 1930");
         System.out.println(" Format 5 : mm-dd-yyyy 02-03-1930");
         
         
         Scanner sc = new Scanner(System.in);
         int status = Integer.parseInt(sc.nextLine());
         switch(status){
         case 1: 
        	 System.out.println("Date : " + year + "-" + month + "-" + day);
        	 break;
         case 2:
        	 System.out.println("Date : " + day + "/" + month + "/" + year);
        	 break;
         case 3:
        	 System.out.println("Date : " + day + "-" + print_month(m, status) + "-" + year);
        	 break;
         case 4:
        	 System.out.println("Date : " + print_month(m, status) + " " + day +" "+ year);
        	 break;
         case 5 :
        	 System.out.println("Date : " + day + "-" + month +  "-" + year);
        	 break;
        	 default:
        		 System.out.println("Not support other format.");
        		 break;
        		 
        	 
         }        
    	
    }
    
    public void print_exam(String output) {
        System.out.println(output);
    }
}

