import java.util.Random;
/**
 * Declares the derived class Police @see Person
 */
public class Police extends Person implements Employee {

 private Roll _roll;
 public enum Roll {Patrol, Sargent, Captain, Chief};

    /**
     * no arg constructor uses random number generation to assign enum variable Roll
     * based on probability of Roll type
     */
 public Police() {
	  Random rnd = new Random();
	  int num = rnd.nextInt(20);
	  if (num <= 10)
	      _roll = Roll.Patrol;
	  if (num >= 11 && num <= 15)
	      _roll = Roll.Sargent;
	  if (num > 15 && num <= 19)
	      _roll = Roll.Captain;
	  if (num == 20)
	      _roll = Roll.Chief;
 }
public Police(String n, int a, Roll r)
{
	this.setName(n);
	this.setAge(a);
	_roll = r;
}

    /**
     * functions givePay and getIDnum must be implemented due to the implementation
     * of the Employee interface within this class.
     */

 public void givePay(double p) {setCash(p); }
 public int getIDnum() {return this.getID();}
 public Roll getRoll(){return _roll;}

}
