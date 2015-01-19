package Tree;
import java.util.*;
public class BTLevelOrderTraversalII {
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>(); 
        dfs(root, res, 0); 
        return res; 
    }
    public void dfs(TreeNode root, List<List<Integer>> res, int level){
        if (root==null) return ;
        if (res.size()<=level) res.add(0, new ArrayList<Integer>()); 
        res.get(res.size()-1-level).add(root.val); 
        if (root.left!=null) dfs(root.left, res, level+1);
        if (root.right!=null) dfs(root.right, res, level+1); 
    }
}
