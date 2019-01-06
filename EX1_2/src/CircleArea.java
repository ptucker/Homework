import java.util.Scanner;


public class CircleArea {

public static void main(String[] args) {
	System.out.println("Enter the Radius of a circle: ");
	Scanner input = new Scanner(System.in);
	//PT -- nextDouble would be better here. -1
	double Radius = input.nextInt();
	final double PI = 3.14;
	double Area = (Radius * Radius * PI );
	
	System.out.printf("Area of circle: ");
	System.out.print(Area);
	
}
	

}
