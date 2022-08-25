package Tree;


import java.util.*;

public class TreeOperations {

    public static void preOrderTraversal(TreeNode root) {
        if (root != null) {
            System.out.println(root.data);
            preOrderTraversal(root.left);
            preOrderTraversal(root.right);
        }
    }

    public static void inOrderTraversal(TreeNode root) {
        if (root != null) {
            inOrderTraversal(root.left);
            System.out.println(root.data);
            inOrderTraversal(root.right);
        }
    }


    public static void postOrderTraversal(TreeNode root) {
        if (root != null) {
            postOrderTraversal(root.left);
            postOrderTraversal(root.right);
            System.out.println(root.data);
        }
    }


    public static List<Integer> preOrderIterative(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();

        if (root == null) {
            return res;
        }

        s.push(root);

        while (!s.isEmpty()) {
            TreeNode temp = s.pop();
            res.add(temp.data);

            if (temp.right != null) {
                s.push(temp.right);
            }

            if (temp.left != null) {
                s.push(temp.left);
            }
        }

        return res;

    }

    public static List<Integer> iterativeInorder(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        TreeNode currentNode = root;
        boolean done = false;

        while (!done) {
            if (currentNode != null) {
                s.push(currentNode);
                currentNode = currentNode.left;
            } else {
                if (s.isEmpty()) {
                    done = true;
                } else {
                    currentNode = s.pop();
                    result.add(currentNode.data);
                    currentNode = currentNode.right;
                }
            }

        }

        return result;
    }

    public static List<Integer> iterativePostOrder(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        List<Integer> res = new ArrayList<>();

        if (root == null) {
            return res;
        }
        s.push(root);

        TreeNode prev = null;

        while (!s.isEmpty()) {
            TreeNode curr = s.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    s.push(curr.left);
                } else if (curr.right != null) {
                    s.push(curr.right);
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    s.push(curr.right);
                }
            } else {
                res.add(curr.data);
                s.pop();
            }
            prev = curr;
        }
        return res;
    }

    protected static List<List<Integer>> levelOrderTraversal(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);
        q.offer(null);

        List<Integer> curr = new ArrayList<>();

        while(!q.isEmpty()) {
            TreeNode temp = q.poll();

            if(temp != null) {
                curr.add(temp.data);

                if(temp.left != null) {
                    q.offer(temp.left);
                }
                if(temp.right != null) {
                    q.offer(temp.right);
                }
            } else {
                List<Integer> c_curr = new ArrayList<>(curr);
                res.add(c_curr);
                curr.clear();

                if(!q.isEmpty()) {
                    q.offer(null);
                }
            }
        }
        return res;
    }

    public static boolean findInTree(TreeNode root, int key) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode temp = q.poll();

            if(key == temp.data) {
                return true;
            }

            if(temp.left != null) {
                q.offer(temp.left);
            }

            if(temp.right != null) {
                q.offer((temp.right));
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left1 = root.left = new TreeNode(3);
        TreeNode right1 = root.right = new TreeNode(2);

        left1.left = new TreeNode(4);
        left1.right = new TreeNode(5);
        right1.left = new TreeNode(6);
        right1.right = new TreeNode(7);


        preOrderTraversal(root);
        System.out.println("--------------------------");
        inOrderTraversal(root);
        System.out.println("--------------------------");
        postOrderTraversal(root);

        System.out.println("Iteratives========================");
        System.out.println("PreOrder------------------------");
        List<Integer> result = preOrderIterative(root);
        System.out.println(result);
        System.out.println("InOrder------------------------");
        List<Integer> res2 = iterativeInorder(root);
        System.out.println(res2);
        System.out.println("PostOrder------------------------");
        List<Integer> resPost = iterativePostOrder(root);
        System.out.println(resPost);
        System.out.println("LevelOrder--------------------------------------");
        List<List<Integer>> res = levelOrderTraversal(root);
        System.out.println(res);


        boolean isThere = findInTree(root, 40);
        System.out.println("FindInTreeeeeeee================ "+ isThere);
    }
}
