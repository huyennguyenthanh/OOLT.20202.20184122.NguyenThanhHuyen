import java.util.Scanner;  // Import the Scanner class

import javax.swing.JOptionPane;

public class SolveEquations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);  // Create a Scanner object
	    
		int n;
		System.out.println("Enter 1 to solve first-degree equation with one variable.");
		System.out.println("Enter 2 to solve first-degree equation with two variables.");
		System.out.println("Enter 3 to solve second-degree equation with one variable.");
		System.out.print("Enter 4 to exit.");
		
		double a,b,c,b1,b2,a11,a12,a21,a22;
		
		do {
		System.out.print("Enter the choice: ");
		n = Integer.parseInt(sc.nextLine());
		
		switch(n) {
		  case 1:
		    System.out.println("Form : ax + b = 0 ");
		    
            System.out.println("Enter a: ");
            a = Double.parseDouble(sc.nextLine());
            System.out.println("Enter b : ");
            b = Double.parseDouble(sc.nextLine());
            if (a != 0)
            	System.out.println("The equation " + a + "x + " + b + " = 0 has a unique solution x = "+-b/a);
            else if ( b!= 0) //a = 0 and b != 0
            	System.out.println("No solution for " + a + "x + " + b + " = 0.");
            else //a = 0 and b = 0
            	System.out.println("Infinite solutions for " + a + "x + " + b + " = 0.");
		    break;
		  case 2:
			  System.out.println("Form : a11x1 + a12x2 = b1 \n a21x1 + a22x2 = b2 \n");
			  String lines;
			  String[] numbers;
		      
		      System.out.println("Enter a11 a12 b1 and a21 a22 b2: ");
		      System.out.flush();
			  lines = sc.nextLine();
			  System.out.println(lines);
		      numbers = lines.trim().split("\\s+");
		      a11 = Double.parseDouble(numbers[0]);
		      a12 = Double.parseDouble(numbers[1]);
		      b1 = Double.parseDouble(numbers[2]);
		      a21 = Double.parseDouble(numbers[3]);
		      a22 = Double.parseDouble(numbers[4]);
		      b2 = Double.parseDouble(numbers[5]);
		      
		      Double D = a11*a22 - a21*a12;
		      Double D1 = b1*a22 - b2* a12;
		      Double D2 = a11*b2 - a21*b1;
		      
		      if(D!=0)
                  System.out.println("The system has a unique solution (x1,x2) = (" + D1/D + "," + D2/D + "),");
              else{
                  if(D1==0 && D2==0)
                      System.out.println("The system has infinitely many solutions. ");
                  else
                      System.out.println("The system has no solution");
              }
	           
		    break;
		  case 3:
			  System.out.println("Form : ax + b = 0 ");
			    
	            System.out.println("Enter a: ");
	            a = Double.parseDouble(sc.nextLine());
	            System.out.println("Enter b : ");
	            b = Double.parseDouble(sc.nextLine());
	            System.out.println("Enter c : ");
	            c = Double.parseDouble(sc.nextLine());
	            
	            double denta = Math.pow(b,2) - 4*a*c;
                if (denta==0)
                    System.out.println("The equation has double root : "+-b/2*a);
                else if (denta>0)
                    System.out.println("The equation has two distinct roots : " 
                +((-b + Math.sqrt(denta))/2*a) +" and "+((-b-Math.sqrt(denta))/2*a));
                else
                    System.out.println("The equation has no solution.");
			  break;
		  case 4:
			  System.out.println("Exit.");
			  break;
		  default:
			  System.out.println("Please enter again.");}
		}while(n!=4);
		
	}

}
