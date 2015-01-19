package Tree;

import java.util.*;
public class BTLevelOrderTraversal {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        if (root==null) return res; 
        Queue<TreeNode> q = new LinkedList<TreeNode> (); 
        q.add(root); 
        while(!q.isEmpty()){
            Queue<TreeNode> q1 = new LinkedList<TreeNode>(q); 
            q.clear(); 
            List<Integer> list = new ArrayList<Integer>(); 
            for (TreeNode node : q1){
                list.add(node.val); 
                if (node.left!=null) q.add(node.left); 
                if (node.right!=null) q.add(node.right); 
            }
            res.add(list); 
        }
        Collections.reverse(res); 
        return res; 
    }
	
	public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        dfs(root, res, 0); 
        return res;
    }
    
    public void dfs(TreeNode root, List<List<Integer>> res, int level){
        if (root==null) return ;
        if (res.size()<=level) res.add(new ArrayList<Integer>()); 
        List<Integer> list = res.get(level); 
        list.add(root.val); 
        dfs(root.left, res, level+1); 
        dfs(root.right, res, level+1); 
    }
}
