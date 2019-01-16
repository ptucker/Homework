public class Square extends Shape implements ShapeInterface{
        private int sidelength;

        public Square(){
            this.findArea();
            this.findPerimeter();
        }
        public Square(String n, int id, int l, String col)
        {
           this.setName(n);
           this.setID(id);
           this.setColor(col);
           sidelength =l;
           this.findArea();
           this.findPerimeter();
        }
        public void findArea(){
            this.setArea((sidelength * sidelength));
        }
        public void findPerimeter(){
            this.setPerimeter((sidelength * 4));
        }
        public String getDetailedString(){
            String s =  String.format("Name: %s " + " ID: %d " + " Area: %d " + " Perimeter: %d " + " Color: %s ",this.getName(),this.getID(),this.getArea(), this.getPerimeter(), this.getColor());
            return s;
        }

}
