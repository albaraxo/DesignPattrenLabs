package lab1;
//albara Abuamsoor
class MathOperations {
    // Overloaded addition
    int add(int a, int b) {
        return a + b;
    }

    double add(double a, double b) {
        return a + b;
    }

    // Overloaded subtraction
    int subtract(int a, int b) {
        return a - b;
    }

    double subtract(double a, double b) {
        return a - b;
    }

    // Overloaded multiplication
    int multiply(int a, int b) {
        return a * b;
    }

    double multiply(double a, double b) {
        return a * b;
    }
}

// Subclass
class AdvancedMathOperations extends MathOperations {
    // Override multiplication to do something special
    @Override
    int multiply(int a, int b) {
        System.out.println("Advanced multiplication (with add 30)");
        return (a * b) + 30;
    }

    @Override
    double multiply(double a, double b) {
        System.out.println("Advanced multiplication (with add 30)");
        return (a * b) + 30.0;
    }
}

// Main class to test
public class Main4 {
    public static void main(String[] args) {
        MathOperations basic = new MathOperations();
        AdvancedMathOperations advanced = new AdvancedMathOperations();

        // Using base class
        System.out.println("Basic add: " + basic.add(5, 3));
        System.out.println("Basic subtract: " + basic.subtract(10, 4));
        System.out.println("Basic multiply: " + basic.multiply(6, 2));

        // Using subclass
        System.out.println("Advanced multiply (int): " + advanced.multiply(6, 2));
        System.out.println("Advanced multiply (double): " + advanced.multiply(4.5, 2.0));
    }
}
