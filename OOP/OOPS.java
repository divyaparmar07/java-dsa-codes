package OOP;

//classes name starts from capital letter and function name starts from small letter.
public class OOPS {
    public static void main(String args[]) {
        // Pen p1 = new Pen(); //Created Pen object called p1
        // p1.setColor("Blue");
        // System.out.println(p1.color);
        // p1.setTip(5);
        // System.out.println(p1.tip);
        // p1.color = "Yellow";

        // Fish shark = new Fish();
        // shark.eat();

        // Dog dobby = new Dog();
        // dobby.eat();
        // dobby.legs = 4;
        // System.out.println(dobby.legs);
        // Calculator calc = new Calculator();
        // System.out.println(calc.sum(5,10));
        // System.out.println(calc.sum(1.5f,2.5f));
        // System.out.println(calc.sum(10, 5, 15));

        // Dear d = new Dear();
        // d.eat();

        Student s1 = new Student();
        s1.schoolName = "JMV";

        Student s2 = new Student();
        System.out.println(s2.schoolName);

        Student s3 = new Student();
        s3.schoolName = "ABC";

    }
}

class Pen {
    String color;
    int tip;

    void setColor(String newColor) {
        color = newColor;
    }

    void setTip(int newTip) {
        tip = newTip;
    }
}

// class Student {
// String name;
// int age;
// float percentage; //cgpa
// int marks[];

// Shallow copy constructor
// Student(Student s1) {
// marks = new int[3];
// this.name = s1.name;
// this.age = s1.age;
// this.marks = s1.marks; // this will point as the same address(they can share
// a reference)
// }

// Depp copy constructor
// Student(Student s1) {
// marks = new int[3];
// this.name = s1.name;
// this.age = s1.age;
// for(int i=0;i<marks.length;i++){
// this.marks[i] = s1.marks[i];
// }
// }

// void calcPercentage(int phy, int chem, int math) {
// percentage = (phy + chem + math) / 3;
// }
// }

// Example of Inheritance
// Base Class
// class Animal {
// String color;
// void eat() {
// System.out.println("eats");
// }
// void breathe() {
// System.out.println("breathes");
// }
// }

// Derived Class
// class Fish extends Animal {
// int fins;
// void swim() {
// System.out.println("Swims in water.");
// }
// }

class Mammal extends Animal {
    // int legs;
    void walk() {
        System.out.println("Walks.");
    }
}

class Bird extends Animal {
    void fly() {
        System.out.println("Fly");
    }
}

class Fish extends Animal {
    void swim() {
        System.out.println("Swim");
    }
}

class Dog extends Mammal {
    String breed;
}

// Compile time Polymorphism = Function Overloading
class Calculator {
    int sum(int a, int b) {
        return a + b;
    }

    float sum(float a, float b) {
        return a + b;
    }

    int sum(int a, int b, int c) {
        return a + b + c;
    }
}

// Run-time Polymorphism = Function Overriding
class Animal {
    void eat() {
        System.out.println("Eat anything.");
    }
}

class Dear extends Animal {
    void eat() {
        System.out.println("Eat grass.");
    }
}

// static example
class Student {

    // static functions
    static int returnPrecentage(int math, int chem, int phy) {
        return (math + chem + phy) / 3;
    }

    String name;
    int roll;

    static String schoolName;

    void setName(String name) {
        this.name = name;
    }

    String getName() {
        return this.name;
    }
}