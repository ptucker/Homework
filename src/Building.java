import java.util.ArrayList;

/**
 * Declares the abstract base class Building to be inherited by CityHall and School classes.
 * All buildings will have variables for their name and address as well as an Arraylist of Person
 * objects called curOccupants.
 * @author Iain Black
 */
public abstract class Building {
    private String name, address;
    public ArrayList <Person> curOccupants = new ArrayList<Person>();

    public Building()
    {
        name ="Unknown";
        address = "Unknown";
    }

    /**
     * An overloaded constructor is used to assign names and addresses to buildings;
     * @param n specifies the name
     * @param a specifies the address
     */
    public Building(String n, String a)
    {
        name =n;
        address=a;
    }
    public void setName(String n){name =n;}
    public void setAddress(String a){address = a;}
    public void addPeople(Person p){curOccupants.add(p);}
    public String getName(){return name;}

    /**
     * abstract functions outputKidsandTeachers and outputPolice
     * are declared to be later implemented in the CityHall and School classes
     */
    public abstract void outputKidsandTeachers();
    public abstract void outputPolice();
}

