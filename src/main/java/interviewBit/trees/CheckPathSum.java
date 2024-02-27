package interviewBit.trees;

public class CheckPathSum {
	
	
	public int hasPathSum(TreeNode A, int B) {
		boolean status = sum(A, 0, B);
		return status ? 1 : 0;
	}
	
	public boolean sum(TreeNode A, int curSum, int reqSum) {
		if (A == null) {
			return false;
		}
		
		if (A.left == null && A.right == null) {
			curSum += A.val;
			if (curSum == reqSum) {
				return true;
			}
			return false;
		}
		
		int sum = curSum + A.val;
		return sum(A.left, sum, reqSum) || sum(A.right, sum, reqSum);
		
	}
	
	
	public static void main(String [] args) {
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(200);
		node.right = new TreeNode(1000);
		System.out.println(new CheckPathSum().hasPathSum(node, 1000));
	}
}
