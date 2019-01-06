
public class Employee {

	private int ID;
	private String hireDate;
	private String name;
	private String curPosition;
	private String Supervisor;
	
	Employee()
	{
		ID =0;
		hireDate = "";
		name = "";
		curPosition = "";
		Supervisor = "";
	}
	
	Employee(int newID, String h, String n, String c, String s)
	{
		ID = newID;
		hireDate = h;
		name = n;
		curPosition = c;
		Supervisor = s;
	}
	
public void setID(int n) {
	ID =n;
}
public void setDate(String d) {
	hireDate = d;
}
public void setName(String n) {
	name = n;
}
public void setPosition(String p) {
	curPosition = p;
}
public void setSupervisor(String s) { 
	Supervisor = s;
}
public int getID() {
	return ID;
}
public String getDate() {
	return hireDate;
}
public String getName() {
	return name;
}
public String getPosition() {
	return curPosition;
}
public String getSupervisor() {
	return Supervisor;
}

//PT -- consider overriding toString()
	
}
