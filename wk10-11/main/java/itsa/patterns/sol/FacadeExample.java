package itsa.patterns.sol;

 interface ShapeType {
   String draw();
}

class Rect implements ShapeType {

   @Override
   public String draw() {
      return "Rectangle::draw()";

   }
}

 class Square implements ShapeType {

   @Override
   public String draw() {
      return "Square::draw()";
   }
}


 class Circle implements ShapeType {

   @Override
   public String draw() {
      return "Circle::draw()";
   }
}

 class ShapeMaker implements ShapeMakerInterface{
   private ShapeType circle;
   private ShapeType rectangle;
   private ShapeType square;

   public ShapeMaker() {
      circle = new Circle();
      rectangle = new Rect();
      square = new Square();
   }
   
   public String draw() {
	   return drawCircle()+drawRectangle()+drawSquare();
   }

   public String drawCircle(){
      return circle.draw();
   }
   public String drawRectangle(){
      return rectangle.draw();
   }
   public String drawSquare(){
      return square.draw();
   }
}

interface ShapeMakerInterface {
   public String draw();
}

public class FacadeExample {
   public static void main(String[] args) {
      ShapeMakerInterface shapeMaker = new ShapeMaker();

      String message = shapeMaker.draw();	
	  System.out.println(message);
	  assert message.equals("Circle::draw()Rectangle::draw()Square::draw()") : "Message does not matched";
   }
}