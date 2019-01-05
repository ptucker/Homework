
public class EmployeeTest {

	
	public static void main(String[] args) {
		Employee E1 = new Employee(123,"1/24/1998", "Dave", "Janitor", "Bob" );
		
		E1.setName("Billy");
		E1.setSupervisor("Dwayne 'the rock' Johnson");
		E1.setPosition("Rocket Scientist");
		E1.setDate("1/25/1998");
		E1.setID(987);
		
		System.out.printf("Employee name: ");
		System.out.printf(E1.getName() + "\n" + "Employee ID: ");
		System.out.print(E1.getID());
		System.out.printf("\n" + "Employee's current position: " + E1.getPosition() + "\n" + "Employee start date: " + E1.getDate() + "\n");
		System.out.printf("Employee's Supervisor: " + E1.getSupervisor());
	}
}
