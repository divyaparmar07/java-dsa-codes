package BinaryTrees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ExampleOfBinaryTree {
    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // height = no of edges
    // depth = no of nodes
    // que: Height of a tree
    public static int height(Node root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }

    // count of nodes of a tree - TC O(n)
    public static int count(Node root) {
        if (root == null) {
            return 0;
        }
        int leftCount = count(root.left);
        int rightCount = count(root.right);
        return leftCount + rightCount + 1;
    }

    // sum of nodes = TC O(n)
    public static int sum(Node root) {
        if (root == null) {
            return 0;
        }
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        return leftSum + rightSum + root.data;
    }

    public static int diameter2(Node root) { // TC = O(n2)
        if (root == null) {
            return 0;
        }
        int leftDiameter = diameter2(root.left);
        int leftHeight = height(root.left);
        int rightDiameter = diameter2(root.right);
        int rightHeight = height(root.right);

        int selfDiameter = leftHeight + rightHeight + 1;

        return Math.max(selfDiameter, Math.max(leftDiameter, rightDiameter));
    }

    // diameter of a tree
    // static class Info {
    //     int diameter;
    //     int height;

    //     public Info(int diameter, int height) {
    //         this.diameter = diameter;
    //         this.height = height;
    //     }
    // }
    // public static Info diameter(Node root) { // O(n)
    //     if (root == null)  {
    //         return new Info(0, 0);
    //     }
    //     Info leftInfo = diameter(root.left);
    //     Info rightInfo = diameter(root.right);

    //     int diam = Math.max(Math.max(leftInfo.diameter, rightInfo.diameter), leftInfo.height + rightInfo.height + 1);
    //     int height = Math.max(leftInfo.height, rightInfo.height) + 1;

    //     return new Info(diam, height);
    // }

    // subtree of the another tree
    public static boolean isSubtree(Node root, Node subRoot) {
        if (root == null) {
            return false;
        }

        if (root.data == subRoot.data) {
            if (isIdentical(root, subRoot)) {
                return true;
            }
        }

        // boolean leftAns = isSubtree(root.left, subRoot); // lsubtree -> true
        // boolean rightAns = isSubtree(root.right, subRoot);

        // return leftAns || rightAns;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private static boolean isIdentical(Node node, Node subRoot) {
        if (node == null && subRoot == null) {
            return true;
        }
        else if(node == null || subRoot == null || node.data != subRoot.data) {
            return false;
        }
        
        if (!isIdentical(node.left, subRoot.left)) {
            return false;
        }
        if (!isIdentical(node.right, subRoot.right)) {
            return false;
        }
        return true;
    }

    static class Info{
        Node node;
        int hd; // horizontal distance

        public Info(Node node, int hd) {
            this.node = node;
            this.hd = hd;
        }
    }
    public static void topView(Node root) {
        // level Order
        Queue<Info> q = new LinkedList<>();
        HashMap<Integer, Node> map = new HashMap<>();

        int min = 0, max = 0;
        q.add(new Info(root, 0));
        q.add(null); //when single level over
        
        while (!q.isEmpty()) {
            Info curr = q.remove();
            if (curr == null) {
                if (q.isEmpty()) {
                    break;
                } else {
                    q.add(null);
                }
            } else {
                if (!map.containsKey(curr.hd)) { // first time my horizontal distance is occurring
                    map.put(curr.hd, curr.node);
                }

                if (curr.node.left != null) {
                    q.add(new Info(curr.node.left, curr.hd-1));
                    min = Math.min(min, curr.hd-1);
                }
                if (curr.node.right != null) {
                    q.add(new Info(curr.node.right, curr.hd+1));
                    max = Math.max(max, curr.hd+1);
                }
            }
        }

        for (int i = min; i <= max; i++) {
            System.out.print(map.get(i).data + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \ / \
                4   56  7
        */
       Node root = new Node(1);
       root.left = new Node(2);
       root.right = new Node(3);
       root.left.left = new Node(4);
       root.left.right = new Node(5);
       root.right.left = new Node(6);
       root.right.right = new Node(7);

       /*
                2
               / \
              4   5
       */

    //    Node subRoot = new Node(2);
    //    subRoot.left = new Node(4);
    //    subRoot.right = new Node(5);

    //    System.out.println("Height is : " + height(root));
    //    System.out.println("Count is : " + count(root));
    //    System.out.println("Sum is : " + sum(root));
    //    System.out.println("Diameter is : " + diameter(root).diameter);

        // System.out.println(isSubtree(root, subRoot));

        topView(root);
    }
}
