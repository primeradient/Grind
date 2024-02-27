package interviewBit.trees;

import java.util.ArrayList;


public class AllPathSum {
	
	public void checkPathSum(TreeNode curr, int diff, ArrayList<Integer> row, ArrayList<ArrayList<Integer>> rows) {
		
		if ( curr == null ) return;
		
		row.add(curr.val);
		
		if ( curr.left == null && curr.right == null) {
			if ( diff - curr.val == 0) {
				rows.add(new ArrayList<Integer>(row));
			}
			row.remove(row.size()-1);
			return;
		}
		
		diff = diff - curr.val;
		
		checkPathSum(curr.left, diff, row, rows );
		checkPathSum(curr.right, diff, row, rows );
		
		row.remove(row.size()-1);
		
		
	}
	
	public ArrayList<ArrayList<Integer>> pathSum(TreeNode A, int B) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<>();
		checkPathSum(A, B, new ArrayList<>(), result);
		return result;
	}
	
	
	public static void main(String [] args) {
		TreeNode node = new TreeNode(5);
		node.left = new TreeNode(4);
		node.right = new TreeNode(8);
		
		node.left.left = new TreeNode(11);
		node.right.left = new TreeNode(13);
		node.right.right = new TreeNode(4);
		
		node.left.left.left = new TreeNode(7);
		node.left.left.right = new TreeNode(2);
		
		node.right.right.left = new TreeNode(5);
		node.right.right.right = new TreeNode(1);
		
		ArrayList<ArrayList<Integer>> rows  = new AllPathSum().pathSum(node, 22);
		for ( ArrayList<Integer> row : rows) {
			System.out.println("");
			for ( int val : row ) {
				System.out.print(" " + val);
			}
		}
	}
	
}
