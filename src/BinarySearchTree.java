public class BinarySearchTree {

    static class Node {
        int val;
        Node left, right = null;

        Node(int data) {
            this.val = data;
        }
    }

    public static Node insert(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }

        if (root.val > data) {

            root.left = insert(root.left, data);
        } else {

            root.right = insert(root.right, data);
        }

        return root;
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);

    }

    public static boolean findKey(Node root, int key) {
        if(root == null) {
            return false;
        }

        if(root.val == key) {
            return true;
        }

        if(root.val > key) {
            return findKey(root.left, key);
        } else  {
            return findKey(root.right, key);
        }

    }


    public static void main(String[] args) {
        int[] arr = {7, 11, 10, 15, 9, 8};

        Node root = null;

        for (int i : arr) {
            root = insert(root, i);
        }

        inorder(root);
        System.out.println(" ");

        if(findKey(root, 90)) {
            System.out.println("Found-----------------------");
        } else {
            System.out.println("Not Found --------------------------");
        }
    }


}
