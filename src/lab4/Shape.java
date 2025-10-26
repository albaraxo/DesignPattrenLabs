package lab4;

// Product
public interface Shape {
    void draw();
}

// Concrete Products
class Circle implements Shape {
    @Override
    public void draw() {
        // Implement draw method for a circle
        System.out.println("Drawing a Circle");
    }
}

class Rectangle implements Shape {
    @Override
    public void draw() {
        // Implement draw method for a rectangle
        System.out.println("Drawing a Rectangle");
    }
}

class Triangle implements Shape {
    @Override
    public void draw() {
        // Implement draw method for a triangle
        System.out.println("Drawing a Triangle");
    }
}

// Factory
interface ShapeFactory {
    Shape createShape();
}

// Concrete Factories
class CircleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Circle();
    }
}

class RectangleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Rectangle();
    }
}

class TriangleFactory implements ShapeFactory {
    @Override
    public Shape createShape() {
        return new Triangle();
    }
}

class Hexagon implements Shape{

    @Override
    public void draw() {
        System.out.println("Drawing Hexagon");
    }
}

class HexagonFactory implements ShapeFactory{

    @Override
    public Shape createShape() {
        return new Hexagon();
    }
}

