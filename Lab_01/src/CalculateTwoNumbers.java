import javax.swing.JOptionPane;
public class CalculateTwoNumbers {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String strNum1, strNum2;
		strNum1 = JOptionPane.showInputDialog(null,
				"Please input the first number: ",
				"Input the first number",
				JOptionPane.INFORMATION_MESSAGE);
		double num1 = Double.parseDouble(strNum1);
		
		
		double num2;
		do {
		strNum2 = JOptionPane.showInputDialog(null,
				"Please input the second number: ",
				"Input the second number",
				JOptionPane.INFORMATION_MESSAGE);
		num2 = Double.parseDouble(strNum2);
		if (num2 == 0)
			JOptionPane.showMessageDialog(null,"The divisor must be nonzero.");
		}while(num2 == 0);
		
		
		
		System.out.println("Two input numbers are " + num1 +" and " + num2);
		System.out.format("Sum: %f\n", num1+num2);
        System.out.format("Difference: %f\n", Math.abs(num1-num2));
        System.out.format("Product: %f\n", num1*num2);
        System.out.format("Quotient: %f\n", num1/num2);
	}

}
