package lab1;
//Albara abuamsoor 2240096
 interface Drawable {
    void draw();
}
class Circle implements Drawable{

    @Override
    public void draw() {
        System.out.println("   ***   ");
        System.out.println(" *     * ");
        System.out.println("*       *");
        System.out.println(" *     * ");
        System.out.println("   ***   ");
    }
}
class Square implements Drawable{

     @Override
    public void draw(){
         System.out.println("+---+");
         System.out.println("|   |");
         System.out.println("+---+");
     }
}
class Main{
    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.draw();

        System.out.println();

        Square square = new Square();
        square.draw();

    }
}
