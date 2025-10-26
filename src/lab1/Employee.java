package lab1;
//Albara Abuamsoor
// Abstract class
abstract class Employee {
    String name;
    double baseSalary;

    Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }
    abstract double calculateSalary();
}
// Subclass: Manager
class Manager extends Employee{
    private double salaryFactor = 1.5;

    Manager(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double calculateSalary() {
        return baseSalary * salaryFactor;
    }
}
// Subclass: Developer
class Developer extends Employee{
    private double salaryFactor = 1.1;

    Developer(String name, double baseSalary) {
        super(name, baseSalary);
    }

    @Override
    double calculateSalary() {
        return baseSalary * salaryFactor;
    }
}
// Main class to test
class Main3{
    public static void main(String[] args) {
        Employee manager = new Manager("Manger Albara", 5000);
        Employee developer = new Developer("Devoloper Bahraja", 4000);

        System.out.println(manager.name + " salary: " + manager.calculateSalary());
        System.out.println(developer.name + " salary: " + developer.calculateSalary());
    }
}
