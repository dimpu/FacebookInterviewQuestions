package com.facebook;
/**
 * Given a node X, find the next highest node to X. Clue: Apart from right and left child, each node
 * has a pointer to its parent node
 * @author Mahindra
 *
 */
public class NextHighestNode {
	private Nodes root;
	NextHighestNode(){
		root = null;
	}
	/**
	 * Assign root node is empty, else call the buildTree function
	 * @param value value to be added to the tree
	 */
	public void addNode(int value){
		if(root == null){
			root = new Nodes(value);
		}
		else
			buildTree(value,root);
	}
	/**
	 * Add new nodes to the tree
	 * @param val value to be added
	 * @param node root
	 * @return
	 */
	public Nodes buildTree(int val, Nodes node){
		if(node == null)
			return new Nodes(val);
		if(val <= node.value){
			node.left = buildTree(val, node.left);
			node.left.parent = node;
		}
		else{
			node.right = buildTree(val, node.right);
			node.right.parent = node;
		}
		return node;
	}
	/**
	 * print next highest node of X
	 * @param X Node whose next highest should be found
	 */
	public void findNextHighest(Nodes X){
		// If the node doesn't have a right child, traverse to the root to get the next highest
		if(X.right == null){
			while(X.parent != null){
				if(X.parent.value < X.value)
					X = X.parent;
				else
					break;
			}
			if(X.parent != null)
				System.out.println("Next highest is " + X.parent.value);
			else
				System.out.println("The node doesn't have next highest");
		}
		// Traverse to the left most node of the node's right child
		else{
			Nodes Y = X.right;
			while(Y.left != null){
				Y = Y.left;
			}
			System.out.println("Next Highest Node is " + Y.value);
		}
	}
	/**
	 * print all the nodes in the tree
	 * @param node root
	 */
	public void printNodes(Nodes node){
		if(node == null)
			return;
		System.out.print(node.value + " ");
		printNodes(node.left);
		printNodes(node.right);
	}
	
	public static void main(String[] args){
		NextHighestNode N = new NextHighestNode();
		N.addNode(10);
		N.addNode(5);
		N.addNode(15);
		N.addNode(20);
		N.addNode(1);
		N.addNode(8);
		N.addNode(12);
		N.printNodes(N.root);
		N.findNextHighest(N.root.right.right);
	}
}
class Nodes{
	int value;
	Nodes right, left, parent;
	Nodes(int value){
		this.value = value;
		left = null;
		right = null;
		parent = null;
	}
}
