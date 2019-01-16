import java.util.*;

// The abstract base class Shape incorporates the functions of the interface ShapeInterface
// while also utilizing abstract functions to differentiate infrormation
// between the different types of shapes.
public abstract class Shape implements ShapeInterface{
    private String name;
    private String Color;
    private int ID, Area, Perimeter;

       public Shape()
       {
           name = "";
           Color = "";
           ID = 0;
           Area =0;
           Perimeter =0;
       }
       public Shape(String n, int id, String col, int a, int p){
           name = n;
           ID = id;
           Color = col;
           Area =a;
           Perimeter =p;

       }


    public String getColor() {return Color;}
    public void setColor(String color) {Color = color;}
    public String getName() {return name;}
    public void setName(String name) {this.name = name;}
    public int getID(){return ID;}
    public void setID(int i){this.ID = i;}
    public int getArea(){return Area;}
    public void setArea(int a){Area =a;}
    public int getPerimeter(){return Perimeter;}
    public void setPerimeter(int p){Perimeter =p;}

    // Determining the area and perimeter of shapes requires different equations, using abstract functions
    // allowed this to be done easily. getDetailed string is used to display the information, and since
    // different shapes have different information I also made this abstract.
    public abstract void findArea();
    public abstract void findPerimeter();
    public abstract String getDetailedString();

    public String getKind() {
        if (this instanceof Circle)
            return "Circle";
        else if (this instanceof Square)
            return "Square";
        else if (this instanceof Triangle)
            return "Triangle";
        else
            return "Rectangle";
    }
    public String toString(){return this.getName();}

}
