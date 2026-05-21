package Queue;

// Microsoft
public class QueueUsingLinkedList {
    static class Node {
        int data;
        Node next;
        Node (int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class Queue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }

        // add
        public static void add(int data) { // O(1)
            Node newNode = new Node(data);
            // if linkedlist or queue is empty.
            if (head == null) {
                head = tail = newNode;
                return;
            }
            // linkedlist exist and add element
            tail.next = newNode;
            tail = newNode;
        }

        // remove
        public static int remove() { // O(1)
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1; // no element
            }
            
            int front = head.data;
            //single element
            if (tail == head) {
                tail = head = null;
            } else {
                head = head.next;
            }
            return front;
        }

        // peek
        public static int peek() { // O(1)
            if (isEmpty()) {
                System.out.println("Empty queue");
                return -1;
            }
            return head.data;
        }   
    }

    public static void main(String[] args) {
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        while (!q.isEmpty()) {
            System.out.println(q.peek());
            q.remove();
        }
    }
}
