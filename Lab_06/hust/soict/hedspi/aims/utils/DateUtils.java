package hust.soict.hedspi.aims.utils;


public class DateUtils {
	public static void printList(MyDate [] l)
	{
		for (int i = 0; i < l.length; i ++)
			l[i].print();
	}
	public int compare_date(MyDate d1, MyDate d2)
	{
		// 1 means d1 > d2 
		// 0 means d1 = d2
		// -1 means d1 < d2
		
		if ( d1.getDay() == d2.getDay() && d1.getMonth() == d1.getMonth() && d1.getYear() == d2.getYear())
			return 0;
		if (d1.getYear() > d2.getYear())
			return 1;
		else
			if (d1.getYear() == d2.getYear())
				if (d1.getMonth() > d2.getMonth())
					return 1;
				else if (d1.getMonth() == d2.getMonth())
					if (d1.getDay() > d2.getDay())
						return 1;
					else if (d1.getDay() == d2.getDay())
						return 0;
		return -1;
	}
	

	public void sort_date(MyDate ...datelist)
	{
		int num_swap;
		do {
			num_swap = 0;
			for (int i = 0; i < datelist.length-1; i++)
			{
				if (compare_date(datelist[i],datelist[i+1]) > 0)
				{
					MyDate tmp = datelist[i] ;
					datelist[i] = datelist[i+1];
					datelist[i+1] = tmp;
					num_swap += 1;
				}
				
			}
		}while(num_swap != 0);
		System.out.println("-----------------------");
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//        MyDate d1 = new MyDate(20,3,2020);
//        MyDate d2 = new MyDate(20,3,2019);
//        MyDate d3 = new MyDate(20,7,2019);
//        MyDate d4 = new MyDate(27,3,2018);
        
        MyDate [] arr = { new MyDate(20,3,2020), new MyDate(20,3,2019),
        		new MyDate(20,7,2019),  new MyDate(27,3,2018)};

        DateUtils du = new DateUtils();
        printList(arr); 
        du.sort_date(arr);
        printList(arr);
        
	}

}

