package interviewBit.trees;
/*
Given a binary tree, return the inorder/preorder/postorder traversal of its TreeNodes values.
NOTE: Using recursion is not allowed.

Problem Constraints
 1 <= number of TreeNodes <= 105

Input Format: First and only argument is root TreeNode of the binary tree, A.
Output Format: Return an integer array denoting the inorder traversal of the given binary tree.
*/

import java.util.ArrayList;
import java.util.Stack;
/*
For Inorder, you traverse from the left subtree to the root then to the right subtree.
For Preorder, you traverse from the root to the left subtree then to the right subtree.
For Post order, you traverse from the left subtree to the right subtree then to the root.
 */
public class PostOrderTraversals {
	
	private ArrayList<Integer> postOrderTraversal(TreeNode A) {
		ArrayList<Integer> result = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<>();
		TreeNode curr = A;
		
		while(true) {
			while(curr != null) {
				stack.push(curr);
				stack.push(curr);
				curr = curr.left;
			}
			
			if(stack.empty()) return result;
			curr = stack.pop();
			
			if(!stack.empty() && stack.peek() == curr) {
				curr = curr.right;
			} else {
				result.add(curr.val);
				curr = null;
			}
		}
	}
	
	public static void main(String []args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.right = new TreeNode(3);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(7);
		
		
		
		
		ArrayList<Integer> result= new PostOrderTraversals().postOrderTraversal(root);
		for ( int val : result ) {
			System.out.print(" " + val);
		}
		
		
		
	}
}
