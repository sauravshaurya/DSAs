package Tree;

import java.util.LinkedList;
import java.util.Queue;


public class FindInTree {


    public boolean isThere(TreeNode root, int key) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode temp = q.poll();

            if(key == temp.data) {
                return true;
            }

            if(temp != null) {

                if(temp.left != null) {
                    q.offer(temp.left);
                }

                if(temp.right != null) {
                    q.offer((temp.right));
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
