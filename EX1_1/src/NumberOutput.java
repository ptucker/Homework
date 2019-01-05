import java.util.Scanner;


public class NumberOutput {
	
	
public static void main(String[] args) {
	
	System.out.println("Enter a number between 10 and 100: ");
	Scanner input = new Scanner(System.in);
	int choice = input.nextInt();
	
	if (choice < 10 || choice > 100) {
		System.out.println("You entered an invalid number\n");
	}
	else 
		for (int i = 0; i <= choice; i++)
		{
			System.out.print(i);
			if (i%2 == 0)
				System.out.printf(" is even\n");
			else 
				System.out.printf(" is odd\n");
		}
}

}
