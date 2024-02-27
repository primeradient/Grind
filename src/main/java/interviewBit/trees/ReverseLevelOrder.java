package interviewBit.trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

/*

Given a binary tree, return the reverse level order traversal of its nodes values.
(i.e, from left to right and from last level to starting level).

Example:

    3
   / \
  9  20
    /  \
   15   7
   
Output : [15, 7, 9, 20, 3]
 
 */
public class ReverseLevelOrder {
	
	public ArrayList<Integer> solve(TreeNode A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		
		queue.add(A);
		while ( !queue.isEmpty() ) {
			TreeNode curr = queue.remove();
			if ( curr.right != null) {  //As its reverse level order, push right first so when we reverse, left is before right
				queue.add(curr.right);
			}
			if ( curr.left != null) {
				queue.add(curr.left);
			}
			
			result.add(curr.val);
		}
		
		Collections.reverse(result);
		return result;
	}
	
	public static void main(String [] args) {
	
	}
	
	
}
