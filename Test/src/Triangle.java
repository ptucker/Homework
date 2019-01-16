public class Triangle extends Shape implements ShapeInterface {
        public int sideA, sideB, sideC;

        public Triangle(){
            this.findArea();
            this.findPerimeter();
        }
        public Triangle(String n, int id, int a, int b, int c, String col){
            this.setName(n);
            this.setID(id);
            this.setColor(col);
            sideA =a;
            sideB=b;
            sideC=c;
            this.findArea();
            this.findPerimeter();
        }
        public void setSideA(int a){sideA=a;}
        public void setSideB(int b){sideA=b;}
        public void setSideC(int c){sideA=c;}
        public int getSideA(){return sideA;}
        public int getSideB(){return sideB;}
        public int getSideC(){return sideC;}

        public void findArea(){
        this.setArea(42);
        }
        public void findPerimeter(){
        this.setPerimeter((sideA + sideB + sideC));
        }
        public String getDetailedString(){
            String s = String.format("Name: %s " + " ID: %d " + " Area: %d  " + " Perimeter: %d " + " Color: %s ",this.getName(),this.getID(),this.getArea(), this.getPerimeter(), this.getColor());
            return s;
        }
}
