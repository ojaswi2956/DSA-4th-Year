package Day3;
import java.io.*;
import java.util.*;
public class postorderTraversal {
    static class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode(int val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }
    }
    static class Solution {
        public List<Integer> postOrderTraversal(TreeNode root){
            List<Integer> result = new ArrayList<>();
            if(root == null) return result;
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode node = stack.pop();
                result.add(node.val);
                if(node.left != null) stack.push(node.left);
                if(node.right != null) stack.push(node.right);
            }
            Collections.reverse(result);
            return result;

        }
    }
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StreamTokenizer st = new StreamTokenizer(br);
        st.nextToken();
        int n = (int) st.nval;
        TreeNode root = null;
        if(n > 0){
            Queue<TreeNode> queue = new LinkedList<>();
            st.nextToken();
            root = new TreeNode((int) st.nval);
            queue.offer(root);
            for(int i = 1; i < n; i++){
                TreeNode parent = queue.poll();
                st.nextToken();
                int leftVal = (int) st.nval;
                if(leftVal != -1){
                    parent.left = new TreeNode(leftVal);
                    queue.offer(parent.left);
                }
                st.nextToken();
                int rightVal = (int) st.nval;
                if(rightVal != -1){
                    parent.right = new TreeNode(rightVal);
                    queue.offer(parent.right);
                }
            }
        }
        Solution sol = new Solution();
        List<Integer> result = sol.postOrderTraversal(root);
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < result.size(); i++){
            if(i > 0) sb.append(' ');
            sb.append(result.get(i));
        }
        System.out.println(sb.toString());

    }
}
