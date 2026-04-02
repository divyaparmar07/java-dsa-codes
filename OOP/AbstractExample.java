package OOP;

public class AbstractExample {
    public static void main(String args[]) {
        // Mustang myHorse = new Mustang();
        // Animal --> Horse --> Mustang

        // Horse h = new Horse();
        // h.eat();
        // h.walk();
        // System.out.println(h.color);
        // Chicken c = new Chicken();
        // c.eat();
        // c.walk();
    }
}

abstract class Animal {
    String color;

    Animal() { // Constructor
        // color = "brown";
        System.out.println("Animal Constructor called");
    }

    void eat() { // non-abstract method
        System.out.println("Animal eats.");
    }

    abstract void walk(); // abstract method - giving idea only
}

class Horse extends Animal {
    Horse() {
        System.out.println("Horse Constructor called");
    }

    void changeColor() {
        color = "dark brown";
    }

    void walk() { // implement using this class
        System.out.println("Walks on 4 legs.");
    }
}

class Mustang extends Horse {
    Mustang() {
        System.out.println("Mustang constructor called.");
    }
}

class Chicken extends Animal {
    void changeColor() {
        color = "Yellow";
    }

    void walk() {
        System.out.println("Walks on 2 legs.");
    }
}
