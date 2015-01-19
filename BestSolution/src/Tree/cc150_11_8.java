package Tree;

public class cc150_11_8 {
	
	public int getRankOfNumber(int x, TreeNode1 root){
		int rank=0; 
		while (root!=null) {
			if (root.value==x) return root.rank+1; 
			if (root.value>x) {
				root=root.left;
			} else{
				rank+=root.rank+1; 
				root=root.right; 
			}
		}
		return rank; 
	}
}

class TreeNode1{
	TreeNode1 left, right; 
	int value, rank; 
	public TreeNode1(int val, int r){
		value = val; 
		rank=r; 
	}
}