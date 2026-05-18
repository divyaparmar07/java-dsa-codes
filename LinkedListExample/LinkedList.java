package LinkedListExample;

public class LinkedList {

    public static class Node {
        int data;
        Node next; // next node to point

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

   public void addFirst(int data) {
        //step-1 create new node
        Node newNode = new Node(data);
        size++;

        // if linkedlist is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }
        
        //step-2 newNode next = head
        newNode.next = head; // link

        //step-3 head = newNode
        head = newNode;
   }

   public void addLast(int data) {
        //step-1 create new node
        Node newNode = new Node(data);
        size++;

        // if linkedlist is empty
        if (head == null) {
            head = tail = newNode;
            return;
        }
        //step-2
        tail.next = newNode;
        //step-3
        tail = newNode;
   }

   public void print() { // TC - O(n)
        // case - linkedlist is empty
        // if (head == null) {
        //     System.out.println("LL is empty");
        //     return;
        // }
        Node temp = head;
        while(temp != null) {
            System.out.print(temp.data + "->"); // print the data
            temp = temp.next; // temp pointing to next node
        }
        System.out.println("null");
   }

   public void add(int index, int data) {
        // if my index is 0 or head
        if(index == 0) {    
            addFirst(data);
            return;
        }
        Node newNode = new Node(data);
        size++;
        Node temp = head;
        int i = 0;
        while (i < index-1) {
            temp = temp.next;
            i++;
        }

        // i = index-1; temp = prev
        newNode.next = temp.next;
        temp.next = newNode;
   }

   public int removeFirst() {
        // if my linkedlist is empty
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        }
        // if size is one 
        else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        int val = head.data;
        head = head.next;
        size--;
        return val;
   }

   public int removeLast() {
        if (size == 0) {
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int val = head.data;
            head = tail = null;
            size = 0;
            return val;
        }
        
        // prev : i = size-2
        Node prev = head;
        for (int i = 0; i < size-2; i++) {
            prev = prev.next;
        }

        int val = prev.next.data; // tail.data
        prev.next = null;
        tail = prev;
        size--;
        return val;
   }

   // Time Complexity = O(n) linear time
   public int iterativeSearch(int key) {
        Node temp = head;
        int index = 0;

        while (temp != null) {
            if (temp.data == key) {
                return index; // key found
            }
            temp = temp.next;
            index++;
        }

        //key not found
        return -1;
   }

   public int helper(Node head, int key) { // TC and SC = O(n)
        // Base case condition
        if (head == null) {
            return -1;
        }

        if (head.data == key) {
            return 0;
        }
        int index = helper(head.next, key);
        // not finded then index=-1
        if (index == -1) {
            return -1;
        }
        // finded then index=index+1
        return index+1;
   }

   public int recursiveSearch(int key) {
        return helper(head,key);
   }

   // finding mid using slow-fast concept/approach
   public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
        }

        return slow; // slow is my midnode
   }

   public boolean checkPalindrome() {
        // if linkedlist is empty or linkedlist have one element then it is already palidrome
        // base case
        if (head == null || head.next == null) {
            return true;
        }

        // step-1 find mid
        Node midNode = findMid(head);

        // step-2 reverse second half
        Node prev = null;
        Node curr = midNode;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node right = prev; // right half head
        Node left = head;

        // step-3 check left half & right half
        while (right != null) {
            if (left.data != right.data) {
                return false;
            }
            left = left.next;
            right = right.next;
        }

        return true;
   }

   // TC - O(n)
   public void reverse() {
        Node prev = null; //before head is null
        Node curr = tail = head;
        Node next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
   }

   public void deleteNthfromEnd(int n) {
        //calculate size
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }

        // head is my n
        if (n == size) {
            head = head.next;
            return;
        }

        //size-n
        int i = 1;
        int indexToFind = size-n;
        Node prev = head;
        // loop stop when we reach prev node of nth node 
        while (i < indexToFind) {
            prev = prev.next;
            i++;
        }

        prev.next = prev.next.next;
        return;
   }

   public static boolean isCycle() { // Floyd's cycle finding algorithm
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next; // +1
            fast = fast.next.next; // +2
            if(slow == fast) {
                return true; // cycle exists
            }
        }
        return false; // cycle doesn't exist
   }

   public static void removeCycle() {
        // detect cycle
        Node slow = head;
        Node fast = head;
        boolean cycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) { // cycle exists
                cycle = true;
                break;
            }
        }
        if (cycle == false) { // cycle not exist
            return;
        }

        //find meeting point
        slow = head;
        Node prev = null; // last node
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // remove cycle -> last.next = null
        prev.next = null;
   }

   private Node getMid(Node head) {
        Node slow = head;
        Node fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow; // mid node
   }

   private Node merge(Node head1, Node head2) {
        Node mergedLL = new Node(-1);
        Node temp = mergedLL;

        while (head1 != null && head2 != null) {
            if (head1.data <= head2.data) {
                temp.next = head1;
                head1 = head1.next;
                temp = temp.next; 
            } else {
                temp.next = head2;
                head2 = head2.next;
                temp = temp.next;
            }
        } 

        // loop for remaining element
        while (head1 != null) {
            temp.next = head1;
            head1 = head1.next;
            temp = temp.next;
        }

        while (head2 != null) {
            temp.next = head2;
            head2 = head2.next;
            temp = temp.next;
        }
        return mergedLL.next;
   }

   // TC - O(nlogn)
   public Node mergeSort(Node head) {
        //base case
        if (head == null || head.next == null) {
            return head;
        }
        //find mid
        Node mid = getMid(head);

        //left & right Merge Sort
        Node rightHead = mid.next;
        mid.next = null;
        Node newLeft = mergeSort(head);
        Node newRight = mergeSort(rightHead);

        //merge
        return merge(newLeft, newRight);
   }

   public void zigZag() {
        // find mid
        Node slow = head;
        Node fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        Node mid = slow;

        // reverse 2nd half
        Node curr = mid.next;
        mid.next = null;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        Node left = head;
        Node right = prev;
        Node nextL, nextR;

        // alternate merge - zig-zag merge
        while (left != null && right != null) {
            nextL = left.next;
            left.next = right;
            nextR = right.next;
            right.next = nextL;

            left = nextL;
            right = nextR;
        }
   }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        // ll.print();
        // ll.addFirst(2);
        // ll.print();
        // ll.addFirst(1);
        // ll.print();
        // ll.addLast(4);
        // ll.print();
        // ll.addLast(5);
        // ll.add(2, 3);

        // ll.print(); //1->2->3->4->5
        // System.out.print(ll.size);

        // ll.removeFirst();
        // ll.print();

        // ll.removeLast();
        // ll.print();
        // System.out.println(ll.size);

        // System.out.println(ll.iterativeSearch(3));
        // System.out.println(ll.iterativeSearch(10));

        // System.out.println(ll.recursiveSearch(3));
        // System.out.println(ll.recursiveSearch(10));

        // ll.reverse();
        // ll.print();

        // ll.deleteNthfromEnd(3);
        // ll.print();

        // ll.addLast(1);
        // ll.addLast(2);
        // ll.addLast(1);
        // ll.addLast(1);

        // ll.print(); //1->2->2->1->null
        // System.out.println(ll.checkPalindrome());

        // head = new Node(1);
        // Node temp = new Node(2);
        // head.next = temp;
        // head.next.next = new Node(3);
        // head.next.next.next = temp;
        // 1->2->3->2

        // System.out.println(isCycle());
        // removeCycle();
        // System.out.println(isCycle());

        // ll.addFirst(1);
        // ll.addFirst(2);
        // ll.addFirst(3);
        // ll.addFirst(4);
        // ll.addFirst(5);
        //5->4->3->2->1

        // ll.print();
        // ll.head = ll.mergeSort(ll.head);
        // ll.print();

        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addLast(4);
        ll.addLast(5);
        ll.addLast(6);
        //1->2->3->4->5
        ll.print();
        ll.zigZag();
        ll.print();
    }
}
