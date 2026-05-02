package LinkedListExample;

public class DoubleLL {
    public class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }
    public static Node head;
    public static Node tail;
    public static int size;

    //add
    public void addFirst(int data) {
        Node newNode = new Node(data);
        size++;

        // linkedlist is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head; 
        head.prev = newNode;
        head = newNode;       
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        size++;

        //linkedlist is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.prev = tail;
        tail.next = newNode;
        tail = newNode;
    }

    //print
    public void print() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "<->");
            temp = temp.next;
        }
        System.out.println("null");
    }

    //remove
    public int removeFirst() {
        // DLL is empty
        if (head == null) {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }

        // single node in DLL
        if (size == 1) {
            int val = head.data;
            head = tail = null;
            size--;
            return val;
        }

        int val = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return val;
    }

    public int removeLast() {
        // if DLL is empty
        if (head == null) {
            System.out.println("DLL is empty");
            return Integer.MIN_VALUE;
        }

        // if DLL have one node
        if (size == 1) {
            int val = tail.data;
            tail = head = null;
            size--;
            return val;
        }

        int val = tail.data;
        tail = tail.prev;
        tail.next = null;
        size--;
        return val;
    }

    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;

            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String[] args) {
        DoubleLL dll = new DoubleLL();
        // dll.addFirst(3);
        // dll.addFirst(2);
        // dll.addFirst(1);
        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);

        dll.print();
        // System.out.println(dll.size);

        // System.out.println(dll.removeLast());
        // dll.print();
        // System.out.println(dll.size);


        // System.out.println(dll.removeLast());
        // dll.print();
        // System.out.println(dll.size);

        // System.out.println(dll.removeLast());
        // dll.print();
        // System.out.println(dll.size);
        
        // dll.removeFirst();
        // dll.print();
        // System.out.println(dll.size);

        // dll.removeFirst();
        // dll.print();
        // System.out.println(dll.size);

        dll.reverse();
        dll.print();
    }
}
