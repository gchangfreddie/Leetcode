package question.seventy.to.hundred;

public class ValidateBST {
//	public static boolean isValidBST(TreeNode root) {
//        if (root==null) return true; 
//        return isValid(root).isBst; 
//    }
//    
//    public static Res isValid(TreeNode root) {
//    	Res r = new Res(true); 
//    	r.max = root.val;
//    	r.min = root.val; 
//        
//        if (root.left!=null) {
//           Res res = isValid(root.left); 
//           if (res.isBst == false) return res; 
//           if (root.val <= res.max) return new Res(false); 
//           r.min = res.min;
//        }
//        if (root.right!=null){
//        	Res res = isValid(root.right); 
//        	if (res.isBst == false) return res; 
//        	if (root.val>=res.min) return new Res(false); 	
//        	r.max = res.max;
//        }
//        return r ; 
//         
//    }
    
    public static boolean isValidBST1(TreeNode root) {
        if (root==null || (root.left==null && root.right==null)) return true; 
        return isV(root).isBST; 
    }
    
    public static Res isV(TreeNode root){
        Res res = new Res(true, root.val, root.val); 
        if (root.left!=null) {
            Res left = isV(root.left); 
            if (!left.isBST || left.max>=root.val) {
                res.isBST=false; return res;
            } else {
                res.min=left.min; 
            }
        }
        if (root.right!=null) {
            Res right = isV(root.right); 
            if (!right.isBST || right.min<=root.val) {
                res.isBST=false; return res;
            } else{
                res.max=right.max;
            }
        }
        return res;
    }
    
    public static void main(String[] args){
    	TreeNode node10 = new TreeNode(10); 
    	TreeNode node5 = new TreeNode(10); 
    	TreeNode node15 = new TreeNode(15); 
    	TreeNode node6 = new TreeNode(6); 
    	TreeNode node20 = new TreeNode(20); 
    	node10.left=node5;// node10.right=node15;
//    	node15.left=node6; node15.right=node20; 
    	System.out.println(isValidBST1(node10)); 
    }
    
}
class Res{
	boolean isBST; 
	int max; 
	int min;
	Res(boolean x, int ma, int mi) {
		isBST=x;
		max=ma; 
		min=mi;
	}
}
