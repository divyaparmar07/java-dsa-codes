package BinarySearchTree;

public class BST {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
            // return new Node(val);
        }

        // find right position to insert
        if (root.data > val) {
            // left subtree
            root.left = insert(root.left, val);
        } else {
            // right subtree
            root.right = insert(root.right, val);
        }
        return root;
    }

    // sorted
    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static boolean search (Node root, int key) { // O(H) = Height of tree
        if (root == null) {
            return false;
        }

        if (root.data == key) {
            return true;
        }

        if (root.data > key) {
            return search(root.left, key);
        }

        else {
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val) {
        if (root.data < val) {
            root.right = delete(root.right, val);
        }
        else if (root.data > val) {
            root.left = delete(root.left, val);
        }
        else { // voila - found key which node we have to delete
            // case 1 - leaf node
            if (root.left == null && root.right == null) {
                return null; // returning parent to null
            }

            // case 2 - single child
            if (root.left == null) {
                return root.right;
            }
            else if (root.right == null) {
                return root.left;
            }

            // case 3 - both children
            Node IS = findInorderSuccessor(root.right);
            root.data = IS.data;
            root.right = delete(root.right, IS.data);
        }

        return root;
    }
    
    // in this case root is always values is not-null
    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + " ");
            printInRange(root.right, k1, k2);
        }
        else if (root.data < k1) {
           printInRange(root.left, k1, k2); 
        }
        else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void main(String[] args) {
        // 1 -> 10
        // int values[] = {5, 1, 3, 4, 2, 7};
        // Node root = null;
        // for (int i = 0; i < values.length; i++) {
        //     root = insert(root, values[i]);
        // }

        // inorder(root);
        // System.out.println();

        // if (search(root, 6)) {
        //     System.out.println("found");
        // } else {
        //     System.out.println("no found");
        // }

        int values[] = {8, 5, 3, 1, 4, 6, 10, 11, 14};

        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }

        inorder(root);
        System.out.println();

        // root = delete(root, 5);
        // System.out.println();
        
        // inorder(root);
        // System.out.println();

        printInRange(root, 5, 12);
    }
}
