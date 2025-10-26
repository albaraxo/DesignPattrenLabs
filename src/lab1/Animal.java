package lab1;
//albara abuamsoor
// Base class
class Animal {
    protected String name;

    Animal(String name) {
        this.name = name;
    }

    void makeSound() {
        System.out.println(name + " makes a sound.");
    }
}

// Subclass: Lion
class Lion extends Animal {
    Lion(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " roars");
    }

    void hunt() {
        System.out.println(name + " is hunting...");
    }
}

// Subclass: Elephant
class Elephant extends Animal {
    Elephant(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " trumpets");
    }

    void sprayWater() {
        System.out.println(name + " sprays water with its trunk!");
    }
}

// Subclass: Monkey
class Monkey extends Animal {
    Monkey(String name) {
        super(name);
    }

    @Override
    void makeSound() {
        System.out.println(name + " chatters ");
    }

    void climb() {
        System.out.println(name + " is climbing a tree!");
    }
}

// Main class
 class Zoo {
    public static void main(String[] args) {
        // Using declared type as Animal (polymorphism)
        Animal[] zoo = {
                new Lion("Simba"),
                new Elephant("Dumbo"),
                new Monkey("George")
        };

        // Loop through animals
        for (Animal animal : zoo) {
            animal.makeSound(); // Polymorphism works here

            // Concrete type-specific behavior using instanceof + casting
            if (animal instanceof Lion) {
                ((Lion) animal).hunt();
            } else if (animal instanceof Elephant) {
                ((Elephant) animal).sprayWater();
            } else if (animal instanceof Monkey) {
                ((Monkey) animal).climb();
            }
            System.out.println("*******************\n");

        }
    }
}
