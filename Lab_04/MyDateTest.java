
import javax.annotation.processing.Generated;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

import java.io.PrintStream;
import java.time.LocalDate;
import java.io.ByteArrayOutputStream;
import java.time.LocalDate;
//import org.junit.Test;

@Generated(value = "org.junit-tools-1.1.0")
public class MyDateTest {

	private MyDate date;
	
	
	@BeforeEach
    void setUp() throws Exception {
		date = new MyDate(20,1,2000);
    }
	
	

	@Test
	public void testGetDay() throws Exception {
		assertEquals(20, date.getDay(), "Error in func getDay.");
		
	}


	@Test
	public void testGetMonth() throws Exception {
		assertEquals(1, date.getMonth(), "Error in func getMonth.");
	}

	@Test
	public void testGetYear() throws Exception {
		assertEquals(2000, date.getYear(), "Error in func getYear.");
	}


	@Test
	public void testPrint() throws Exception {
		String tmp = date.print();
		String [] tmps = tmp.split(" ");
		
		
		assertEquals("January",tmps[0] , "Error in func:  print. Error in print month.");
		assertEquals("20th",tmps[1] , "Error in func:  print. Error in print day");
		assertEquals("2000",tmps[2] , "Error in func:  print. Error in print year.");
		assertEquals("January 20th 2000",tmp , "Error in func:  print.");
	}

	@Test
	public void testSetDay() throws Exception {

		date.setDay(10);
		assertEquals(10,date.getDay() , "Error in func: setDay. Can't set.");
		date.setDay(-1);
		assertEquals(10 ,date.getDay() , "Error in func: setDay. Day must > 0.");
		date.setDay(40);
		assertEquals(10 ,date.getDay() , "Error in func: setDay. Day must < 30/31/28/29.");
	}

	@Test
	public void testSetMonth() throws Exception {
		date.setMonth(12);
		assertEquals(12,date.getMonth() , "Error in func: setMonth. Can't set.");
		date.setMonth(0);
		assertEquals(12,date.getMonth() , "Error in func: setMonth. Month must > 0.");
		date.setMonth(13);
		assertEquals(12,date.getMonth() , "Error in func: setMonth. Month must < 13.");
		
	}


	@Test
	public void testSetYear() throws Exception {
		date.setYear(2020);
		assertEquals(2020,date.getYear() , "Error in func: setYear. Can't set.");
		date.setDay(-20);
		assertEquals(2020,date.getYear() , "Error in func: setMonth. Year must >= 0.");
	}
	
	@Test
	public void testInit_1() throws Exception {
		MyDate d = new MyDate();
		int day = LocalDate.now().getDayOfMonth();
		int month = LocalDate.now().getMonthValue();
		int year = LocalDate.now().getYear();
		assertEquals(year, d.getYear(), "Error in func init Current Day. Wrong day.");
		assertEquals(month, d.getMonth(), "Error in func init Current Day. Wrong day.");
		assertEquals(day, d.getDay(), "Error in func init Current Day. Wrong day.");
		
		
	}
	
	@Test
	public void testInit_2() throws Exception {
		MyDate d = new MyDate(20,1,2000);
		assertEquals(2000, d.getYear(), "Error in func init Current Day. Wrong year.");
		assertEquals(1, d.getMonth(), "Error in func init Current Day. Wrong month.");
		assertEquals(20, d.getDay(), "Error in func init Current Day. Wrong day.");
		
		
		MyDate d1 = new MyDate("second", "s", "dd");
		assertEquals(0, d1.getYear(), "Error in func init(string, string, string). The input year is wrong so the output must be = 0.");
		assertEquals(0, d1.getMonth(), "Error in func init(string, string, string). The input month is wrong so the output must be = 0.");
		assertEquals(0, d1.getDay(), "Error in func init(string, string, string). Month and year wrong so can't init day.");
		
		
		MyDate d2 = new MyDate("thirdty", "Jan.", "twenty thirdty-one");
		assertEquals(2031, d2.getYear(), "Error in func init(string, string, string). Wrong year.");
		assertEquals(1, d2.getMonth(), "Error in func init(string, string, string). Wrong month.");
		assertEquals(30, d2.getDay(), "Error in func init(string, string, string). Wrong day.");
		
		
		MyDate d3 = new MyDate("February 29th 2001");
		assertEquals(0, d3.getYear(), "Error in func init from a string. This is not leaf year.");
		assertEquals(0, d3.getMonth(), "Error in func init from a string. This is not leaf year.");
		assertEquals(0, d3.getDay(), "Error in func init from a string. This is not leaf year. Can't setDay = 29.");
			
		
	}

	@Test
	public void testPrint_format() throws Exception {
		System.setOut(new PrintStream(outputStreamCaptor));
	    date.print();
	        
	    assertEquals("Date : January 20th 2000", outputStreamCaptor.toString()
	      .trim(), "Print Error.");
		
	}
	
	private final PrintStream standardOut = System.out;
	private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

	
	@Test
	void givenSystemOutRedirection_whenInvokePrintln_thenOutputCaptorSuccess() {
		System.setOut(new PrintStream(outputStreamCaptor));
	    date.print_exam("Hello world!!");
	        
	    assertEquals("Hello world!!", outputStreamCaptor.toString()
	      .trim());
	}
}