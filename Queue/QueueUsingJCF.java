package Queue;
import java.util.*;

public class QueueUsingJCF {
    public static void main(String[] args) {

        // Queue is interface. we are not making objects of interface. queue implement 1. LinkedList and 2. ArrayDeque
        // Diff between Linkedlist and ArrayDeque (Cache)
        // Queue<Integer> q = new LinkedList<>();
        Queue<Integer> q = new ArrayDeque<>(); // O(1) - constant time
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
