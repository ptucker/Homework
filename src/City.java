import java.util.ArrayList;
import java.util.Random;

/**
 * Declares the City class to utilize all classes in generating the City simulation and displaying it's contents.
 * ArrayLists of Person and Building objects allow easy manipulation of all kinds of objects.
 */
public class City {
   // private Random rnd = new Random();
    private String Name;
    public ArrayList<Building> Buildings = new ArrayList<Building>();
    public ArrayList<Person> People = new ArrayList<Person>();


    /**
     * no arg constructor calls all of City's functions which generate the objects, move them around the city, and display
     * the City's contents.
     */
    public City() {
        Name = "Default";
        genResidents();
        genBuildings();
        fillBuildings();
        Display();

    }
    public City(String n)
    {
        Name = n;
        genBuildings();
    }

    /**
     * function genResidents uses a for loop to generate 100 residents to live in the city,
     * random number generation is used to decide the class type and pushes them into the
     * ArrayList People.
     */
    public void genResidents() {
        for (int i = 0; i < 100; i++) {
            Random rnd = new Random();
            int num = rnd.nextInt(3);
            if (num == 0)
                People.add(new Police());
            if (num == 1)
                People.add(new Teacher());
            if (num == 2)
                People.add(new Kid());

        }
    }

    /**
     * function genBuildings requires using the overloaded constructor to create buildings
     * with names and addresses and pushes them into the ArrayList Buildings.
     */

    public void genBuildings() {
        Buildings.add(new CityHall("City Hall", "1234 Main St."));
        Buildings.add(new School("School", "1235 Main St."));
    }

    /**
     * function fillBuildings uses a for loop to go through the ArrayList People (containing all people in the City)
     * and push them into the ArrayList curOccupants held by each building. Random number generation is used
     * to decide which building they are moved into.
     */
    public void fillBuildings() {
        for (int i = 0; i < People.size(); i++) {

            Random rnd = new Random();
            int num = rnd.nextInt(2);

            if (num == 0)
                Buildings.get(0).addPeople(People.get(i));
            else
                Buildings.get(1).addPeople(People.get(i));
            /*
            for (int j=0; j< Buildings.size();j++) {
                Buildings.get(j).addPeople(People.get(i));
                j++;
            }.
            */
        }
    }

    /**
     * function Display labels all of the information to be displayed, and then outputs the information
     * using for loops to loop through the ArrayLists of either People or Buildings and calling the appropriate
     * function to display the information.
     */
    public void Display() {
        System.out.printf("Names of Buildings: \n");

        for (int i=0; i< Buildings.size();i++) {
            System.out.println(Buildings.get(i).getName());
        }
        System.out.printf("\n" + "Information of all people within city: \n");

        for (int i=0; i< People.size();i++) {
            People.get(i).displayInfo();
        }

        for (int i =0; i < Buildings.size(); i++) {
            if (Buildings.get(i) instanceof CityHall){
                System.out.println(String.format(" \n" + "Names and rolls of Policemen in City Hall:", Buildings.get(i).getName() + ":"));
                Buildings.get(i).outputPolice();
            }
            if (Buildings.get(i) instanceof School){
                System.out.println(String.format(" \n" + "Names of Teachers and Kids in School:", Buildings.get(i).getName() + ":"));
                Buildings.get(i).outputKidsandTeachers();
            }
        }
    }
    public void payAllEmployees(double pay){
        for (int i=0;i <People.size();i++) {
            if (People.get(i) instanceof Employee) {
                ((Employee)People.get(i)).givePay(pay);
            }
        }
    }
}