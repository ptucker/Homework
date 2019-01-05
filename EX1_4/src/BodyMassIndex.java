import java.util.Scanner;


public class BodyMassIndex {

public static void main(String[] args) {
	Scanner input = new Scanner(System.in);
	System.out.printf("Enter your body weight in lbs: ");
	double pounds = input.nextInt();
	System.out.printf("Enter your height in inches: ");
	double inches = input.nextInt();
	double kg = (pounds / 2.205);
	double m = (inches / 39.37);
	
	double BMI = kg / (m * m);
	
	System.out.printf("Your BMI number is ");
	System.out.print((int) BMI);
	
}
	
	
}
