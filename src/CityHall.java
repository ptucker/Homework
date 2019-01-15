import java.util.ArrayList;

/**
 * Declares the derived class CityHall @see Building
 */
public class CityHall extends Building{

    public CityHall(String n, String a)
    {
        this.setName(n);
        this.setAddress(a);
    }

    /**
     * Because functions outputKidsandTeachers and outputPolice are from the base class they both must be implemented,
     * but since they are abstract their definitions can differ from class to class, I exemplified this by making
     * very small changes within each of them.
     */
    public void outputKidsandTeachers()
    {
        for (int i =0; i <this.curOccupants.size(); i++){
            if (this.curOccupants.get(i) instanceof Teacher)
                System.out.println(String.format(this.curOccupants.get(i).getName()));
            else if (this.curOccupants.get(i) instanceof Kid)
                System.out.println(String.format(this.curOccupants.get(i).getName()));
        }
    }
    public void outputPolice(){
        for (int i=0;i<this.curOccupants.size();i++){
            if (this.curOccupants.get(i) instanceof Police)
                System.out.println(this.curOccupants.get(i).getName() + ", Roll: " + ((Police) this.curOccupants.get(i)).getRoll());
        }

    }

}
