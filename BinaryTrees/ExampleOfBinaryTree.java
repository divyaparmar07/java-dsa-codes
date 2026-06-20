package BinaryTrees;

import java.lang.annotation.Retention;
import java.util.ArrayList;
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

    public static void KLevel(Node root, int level, int k) {
        if (root == null) {
            return;
        }
        if (level == k) {
            System.out.print(root.data + " ");
            return;
        }

        KLevel(root.left, level+1, k);
        KLevel(root.right, level+1, k);
    }

    public static boolean getPath(Node root, int n, ArrayList<Node> path) {
        // base condition
        if (root == null) {
            return false;
        }
        // add node
        path.add(root);

        if (root.data == n) {
            return true;
        }

        boolean foundLeft = getPath(root.left, n, path);
        boolean foundRight = getPath(root.right, n, path);

        // checking for if node is found in subtree left and right
        if (foundLeft || foundRight) {
            return true;
        }

        // removing current root
        path.remove(path.size()-1);
        return false;
    }

    // Time complexity = O(n), Space complexity = O(n)
    public static Node lca(Node root, int n1, int n2) {
        // 1. finding path
        ArrayList<Node> path1 = new ArrayList<>();
        ArrayList<Node> path2 = new ArrayList<>();

        getPath(root, n1, path1); // O(n)
        getPath(root, n2, path2); // O(n)

        // last common ancestor
        int i = 0;
        for (; i < path1.size() && i <path2.size(); i++) { // O(n)
            if (path1.get(i) != path2.get(i)) {
                break;
            }
        }

        // last equal node -> i-1th
        Node lca = path1.get(i-1);
        return lca;
    }

    public static Node lca2(Node root, int n1, int n2) {
        // base condition
        if (root == null || root.data == n1 || root.data == n2) {
            return root;
        }
        
        Node leftLca = lca2(root.left, n1, n2);
        Node rightLca = lca2(root.right, n1, n2);

        // leftLCA = val   rightLCA = null
        if (rightLca == null) {
            return leftLca;
        }
        // leftLCA = null   rightLCA = val
        if (leftLca == null) {
            return rightLca;
        }

        // both values are valid then return root
        return root;
    }

    public static int lcaDist(Node root, int n) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }
        
        int leftDist = lcaDist(root.left, n);
        int rightDist = lcaDist(root.right, n);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        } else if (leftDist == -1) {
            return rightDist + 1;
        } else {
            return leftDist + 1;
        }
    }

    public static int minDist(Node root, int n1, int n2) {
        Node lca = lca2(root, n1, n2);
        int dist1 = lcaDist(lca, n1);
        int dist2 = lcaDist(lca, n2);
        return dist1 + dist2;
    }

    public static int KAncestor(Node root, int n, int k) {
        if (root == null) {
            return -1;
        }

        if (root.data == n) {
            return 0;
        }

        int leftDist = KAncestor(root.left, n, k);
        int rightDist = KAncestor(root.right, n, k);

        if (leftDist == -1 && rightDist == -1) {
            return -1;
        }

        int max = Math.max(leftDist, rightDist);
        if (max + 1 == k) {
            System.out.println(root.data);
        }
        return max + 1;
    }

    public static int transform(Node root) {
        if (root == null) {
            return 0;
        }

        int leftChild = transform(root.left);
        int rightChild = transform(root.right);

        int data = root.data;

        int newLeft = root.left == null ? 0 : root.left.data;
        int newRight = root.right == null ? 0 : root.right.data;
        root.data = newLeft + leftChild + newRight + rightChild;
        return data;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }

        System.out.print(root.data + " ");
        preorder(root.left);
        preorder(root.right);
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

        // topView(root);
        // KLevel(root, 1, 3);

        // int n1 = 4, n2 = 6;
        // System.out.print(lca(root, n1, n2).data);
        // System.out.print(lca2(root, n1, n2).data);

        // int n1 = 4, n2 = 6;
        // System.out.println(minDist(root, n1, n2));

        // int n = 5, k = 2;
        // KAncestor(root, n, k);

        /*
                    27
                   / \
                  9   13
                 / \ /  \
                0  0 0   0
        */

        transform(root);
        preorder(root);
    }
}
