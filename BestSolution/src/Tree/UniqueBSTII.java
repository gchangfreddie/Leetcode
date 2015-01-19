package Tree;

import java.util.*;

public class UniqueBSTII {
	public List<TreeNode> generateTrees(int n) {
        return generate(1, n); 
    }
    
    public List<TreeNode> generate(int s, int e){
        ArrayList<TreeNode> list = new ArrayList<TreeNode>(); 
        if (s>e) {
            list.add(null); 
        } else if (s==e) {
            list.add(new TreeNode(s)); 
        } else {
            for (int i=s; i<=e; i++) {
                List<TreeNode> left = generate(s, i-1); 
                List<TreeNode> right= generate(i+1, e); 
                for (int k=0; k<left.size(); k++) {
                    for (int j=0; j<right.size(); j++){
                        TreeNode root = new TreeNode(i); 
                        root.left = left.get(k); 
                        root.right = right.get(j); 
                        list.add(root); 
                    }
                }
            }    
        }
        return list;
    }
}
