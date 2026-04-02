package OOP;

public class SuperExample {
    public static void main(String args[]) {
        H h1 = new H();
        System.out.println(h1.color);
    }
}

class A {
    String color;

    A() {
        System.out.println("Animal constructor is called.");
    }
}

class H extends A {
    H() {
        // super(); // called A class Constructor
        super.color = "brown";
        System.out.println("Horse constructor is called.");
    }
}
