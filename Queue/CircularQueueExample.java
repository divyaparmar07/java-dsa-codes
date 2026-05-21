package Queue;

public class CircularQueueExample {
    static class CircularQueue {
        static int arr[];
        static int size;
        static int rear;
        static int front;

        CircularQueue(int n) {
            arr = new int[n];
            size = n;
            rear = -1;
            front = -1;
        }

        public static boolean isEmpty() {
            return rear == -1 && front == -1;
        }

        public static boolean isFull() {
            return (rear + 1) % size == front;
        }

        // add
        public static void add(int data) { //O(1)
            // queue is full
            if (isFull()) {
                System.out.println("Queue is full");
                return;
            }

            // adding 1st element when front is -1 and rear is also -1
            if (front == -1) {
                front = 0;
            }
            rear = (rear + 1) % size;
            arr[rear] = data; 
        }

        // remove
        public static int remove() { // O(1)
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1; // no element
            }

            int result = arr[front];

            // last element delete
            if (rear == front) {
                rear = front = -1;
            } else {
                front = (front + 1) % size;
            }
            return result;
        }

        // peek
        public static int peek() { // O(1)
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            return arr[front]; // front
        }   
    }

    public static void main(String[] args) {
        CircularQueue q = new CircularQueue(3);
        q.add(1);
        q.add(2);
        q.add(3);
        System.out.println(q.remove());
        q.add(4);
        System.out.println(q.remove());
        q.add(5);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
