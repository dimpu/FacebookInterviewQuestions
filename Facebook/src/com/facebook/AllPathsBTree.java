package com.facebook;
import java.awt.print.Printable;

/*
 * Print all possible paths in a Binary tree
 */
class Tree{
	Tree left,right;
	int value;
	Tree(int value){
		this.value = value;
	}
}
public class AllPathsBTree {
	Tree root;
	AllPathsBTree(){
		root = null;
	}
	public static void main(String[] args){
		AllPathsBTree a1 = new AllPathsBTree();
		a1.add(5);
		a1.add(3);
		a1.add(8);
		a1.add(10);
		a1.add(4);
		a1.add(2);
		a1.add(12);
		a1.add(7);
		a1.print();
		
	}
	/*
	 * calls the functions to print the paths passing the root and string as argument
	 */
	public void print(){
		printAllPaths(this.root,"");
	}
	/*
	 * Adding nodes to the tree
	 */
	public void add(int value){
		root = add(root,value);
	}

	public Tree add(Tree node, int value){
		if(node == null){
			node = new Tree(value);
			return node;
		}
		else{
			if(value < node.value)
				node.left = add(node.left, value);
			else
				node.right = add(node.right, value);
		}
		return node;
	}
	/*
	 * Print all paths in the tree
	 */
	public void printAllPaths(Tree node,String s){
		if(node == null)
			return;
		s = s + " " + node.value;
		if(node.left == null && node.right == null)
			System.out.println(s);
		printAllPaths(node.left, s);
		printAllPaths(node.right, s);
		return;
	}
}


