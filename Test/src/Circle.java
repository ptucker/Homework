public class Circle extends Shape implements ShapeInterface{
    private int radius;
    private double PI = 3.14;

    public Circle(){
        this.findArea();
        this.findPerimeter();
    }
    public Circle(String n, int id, int r, String col){
        radius =r;
        this.setName(n);
        this.setID(id);
        this.setColor(col);
        this.findArea();
        this.findPerimeter();
    }
    public void setRadius(int r){radius =r;}
    public int getRadius(){return radius;}

    public void findArea(){
        double a = (radius * PI);
        double area = Math.pow(a,2);
        this.setArea((int)area);
    }
    public void findPerimeter(){
        double cir = (2 * PI * radius);
        this.setPerimeter((int)cir);
    }
    public String getDetailedString(){
        String s = String.format("Name: %s " + " ID: %d" + " Area: %d " + " Circumference: %d " + " Color: %s ",this.getName(),this.getID(),this.getArea(), this.getPerimeter(), this.getColor());
        return s;
    }

}
