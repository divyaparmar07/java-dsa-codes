package OOP;

public class InterfaceExample {
    public static void main(String[] args) {
        Queen q = new Queen();
        q.moves();
    }
}

interface ChessPlayer {
    void moves(); // public, abstract and can not be implemented.
}

class Queen implements ChessPlayer {
    public void moves() {
        System.out.println("Up down left right diagonal(in all 4 directions)");
    }
}

class Rook implements ChessPlayer {
    public void moves() {
        System.out.println("Up Down Left right");
    }
}

class King implements ChessPlayer {
    public void moves() {
        System.out.println("Up down left right diagonal - (by 1 move)");
    }
}

// Example of Multiple Inheritance using Interface
interface Herbivore { // eat grass
    void eatGrass();
}

interface Carnivore { // eat meat
    void eatMeat();
}

class Bear implements Herbivore, Carnivore {
    public void eatGrass() {
        System.out.println("Eats grass.");
    }

    public void eatMeat() {
        System.out.println("Eats meat.");
    }
}
