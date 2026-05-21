package Queue;

// Note: we push first element then it's process first in such cases then use queue and if first element process it last in such cases then use stack
public class QueueExample {
    static class Queue {
        static int arr[];
        static int size;
        static int rear;

        Queue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
        }

        public static boolean isEmpty() {
            return rear == -1;
        }

        // add
        public static void add(int data) {
            // queue is full
            if (rear == size - 1) {
                System.out.println("Queue is full");
                return;
            }
            rear = rear + 1;
            arr[rear] = data; 
        }

        // remove
        public static int remove() {
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1; // no element
            }
            int front = arr[0]; // fixed position
            for (int i = 0; i < rear ; i++) {
                arr[i] = arr[i+1];
            }
            rear = rear - 1;
            return front;
        }

        // peek
        public static int peek() {
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            return arr[0]; // front
        }   
    }

    public static void main(String[] args) {
        Queue q = new Queue(5);
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
    
}
