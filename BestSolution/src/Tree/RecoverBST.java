package Tree;

public class RecoverBST {
	TreeNode prev, p, q; 
    public void recoverTree(TreeNode root) {
        if (root==null || (root.left==null && root.right==null)) return ;
        inorder(root); 
        if (p!=null) {
            int temp = p.val; 
            p.val=q.val;
            q.val=temp;
        }
    }
    public void inorder(TreeNode root){
        if (root==null) return ;
        inorder(root.left); 
        if (prev!=null && prev.val>root.val){
            if (p==null){
                p=prev; 
                q=root;
            } else {
                q=root;
            }
        }
        prev=root; 
        inorder(root.right); 
    }
    
    public static void main(String[] args){
    	TreeNode node10 = new TreeNode(10); 
    	TreeNode node5 = new TreeNode(5); 
    	TreeNode node15 = new TreeNode(15); 
    	TreeNode node6 = new TreeNode(6); 
    	TreeNode node20 = new TreeNode(20); 
    	node10.left=node5;  node10.right=node15;
    	node15.left=node6; node15.right=node20; 
    	RecoverBST r = new RecoverBST(); 
    	r.recoverTree(node10); 
    }
}
