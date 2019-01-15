import com.sun.javafx.image.BytePixelSetter;
/**
 * Declares the base class Person to be inherited by Police, Teacher, and Kid classes
 * @author Iain Black
 */
import java.util.Random;
public class Person {

private String name;
private int age, pnumber, ID;
private double cash;
private static int EmployeeID = 0;
private static int PersonID = 0;
private static int plastnumber = 1111111;

	/**
	 * Creates the no arg constructor for a Person
	 * Assigns the persons name before checking whether they have implemented the Employee interface
	 * before assigning the remaining information.
	 * Random number generation is used to determine age.
	 */
	public Person() {
	name= "Person" + PersonID;
	PersonID++;
	if (this instanceof Employee)
	{
		ID = EmployeeID;
		EmployeeID++;
		cash =0.0;
		Random rand = new Random();
		int num = rand.nextInt(22);
		age = 20 +num;
	}
	else
	{
		ID = PersonID;
		Random rand2 = new Random();
		age = rand2.nextInt(14) +5;
	}
	pnumber = plastnumber;
	plastnumber++;

}


public String getName() { return name; }
public double getCash(){return cash;}
public int getID(){return ID;}
public int getAge() {return age;}
public int getPnumber() {return pnumber;}
public void setCash(double c){cash=c;}
public void setID(int i){ID=i;}
public void setName(String n) {name=n;}
public void setAge(int a) {age=a;}
public void setPnumber(int p) {pnumber=p;}

	/**
	 * displayInfo function outputs all of a Person object's variables.
	 */
	public void displayInfo()
	{
		if (this instanceof Employee)
			System.out.println(this.getName()+" is a "+ this.getAge()+ " year old " + this.getClass() + " with ID number " + this.getID() + " and phone number " + getPnumber() + ", who has $" + this.getCash() +" to their name.");
		else if (this instanceof Kid)
			System.out.println(this.getName() + " is a " + this.getAge() + " year old kid whose favorite candy is " + ((Kid) this).getCandy()+".");
	}


}
