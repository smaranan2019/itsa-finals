package itsa.patterns.sol;

interface Shape {
    String draw(int x, int y, int z, int j);
}

class Line {
    public String draw(int x1, int y1, int x2, int y2) {
        return "Line from point A(" + x1 + ";" + y1 + "), to point B(" + x2 + ";" + y2 + ")";
    }
}

class Rectangle {
    public String draw(int x, int y, int width, int height) {
        return "Rectangle with starting left lowest point (" + x + ";" + y + "), width: " + width
                + ", height: " + height;
    }
}

class LineAdapter implements Shape {
    private Line adaptee;

    public LineAdapter() {
        this.adaptee = new Line();
    }

    @Override
    public String draw(int x1, int y1, int x2, int y2) {
        return adaptee.draw(x1, y1, x2, y2);
    }
}

class RectangleAdapter implements Shape {
    private Rectangle adaptee;

    public RectangleAdapter() {
        this.adaptee = new Rectangle();
    }

    @Override
    public String draw(int x1, int y1, int x2, int y2) {
        int x = Math.min(x1, x2);
        int y = Math.min(y1, y2);
        int width = Math.abs(x2 - x1);
        int height = Math.abs(y2 - y1);
        return adaptee.draw(x, y, width, height);
    }
}

public class AdapterExample {
    public static void main(String[] args) {
        Shape[] shapes = {new RectangleAdapter(),
                          new LineAdapter()};

        int x1 = 1, y1 = 1;
        int x2 = 3, y2 = 6;
        for (Shape shape : shapes) {
            System.out.println(shape.draw(x1, y1, x2, y2));
        }
    }
}