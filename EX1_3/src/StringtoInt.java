import java.util.Scanner;



public class StringtoInt {

public static void main(String[] args) {
	System.out.println("Enter a number");
	Scanner input = new Scanner(System.in);
	String string = input.nextLine();
	boolean check = true;
	int convert =0;
	
	
	for (int i = 0; i < string.length(); i++)
	{
		//PT -- This is more readable: if (string.charAt(i)>='0' && string.charAt(i) <='9') 
		if (string.charAt(i)>=48 && string.charAt(i) <=57) 
			convert = convert + string.charAt(i) - 48; //PT -- Again, string.charAt(i) - '0';
		else	{
			check = false;
			break;
		}	
		if (i < string.length()-1)
			convert = convert * 10;
	}
	if (check == true) {
		System.out.printf("You entered the number ");
		System.out.print(convert);
	}
	else 
		System.out.printf("You did not enter a valid number.\n");
	
	
	
	
}

}
