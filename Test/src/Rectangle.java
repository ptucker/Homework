public class Rectangle extends Shape implements ShapeInterface{
    private int length, height;

    public Rectangle(){
        this.findArea();
        this.findPerimeter();
    }
    public Rectangle(String n, int id, int l, int h, String col){
        this.setName(n);
        this.setID(id);
        this.setColor(col);
        length =l;
        height =h;
        this.findArea();
        this.findPerimeter();
    }
    public void setLength(int l){length= l;}
    public void setHeight(int h){height =h;}
    public int getLength(){return length;}
    public int getHeight(){return height;}

    public void findArea() {
        this.setArea((length * height));
    }
    public void findPerimeter(){
        this.setPerimeter((length*2)+(height*2));
    }
    public String getDetailedString(){
        String s = String.format("Name: %s " + " ID: %d " + " Area: %d " + " Perimeter: %d " + " Color: %s ",this.getName(),this.getID(),this.getArea(), this.getPerimeter(), this.getColor());
        return s;
    }
}
