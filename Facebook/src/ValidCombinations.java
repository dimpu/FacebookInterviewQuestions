import java.io.*;
import java.util.*;

public class ValidCombinations {
	final static String [] map = {"", "a", "b", "c", "d", "e",
        "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
        "s", "t", "u", "v", "w", "x", "v", "z"};
	public static void main(String[] args)throws IOException{
		int[] array1 = {1,2,3};
		System.out.println("Combinations for 1,2,3");
		printCombinations(array1);
		System.out.println();
		
		int[] array2 = {2,3,4};
		System.out.println("Combinations for 2,3,4");
		printCombinations(array2);
		System.out.println();
		
		int[] array3 = {9,2,4};
		System.out.println("Combinations for 9,2,4");
		printCombinations(array3);
		System.out.println();
	}

	public static Node createNode(int data, String PrevString, int[] array){
		if(data > 26)
			return null;
		String dataString = PrevString + map[data];
		Node node = new Node(dataString);
		int[] a;
		if(array.length > 1){
			data = array[0]*10 + array[1];
			a = Arrays.copyOfRange(array, 2, array.length);
			node.right = createNode(data,dataString,a);
		}
		if(array.length >= 1){
			data = array[0];
			a = Arrays.copyOfRange(array,1,array.length);
			node.left = createNode(data,dataString,a);
		}
		return node;
	}

	public static void displayNodes(Node node){
		if(node == null)
			return;
		if(node.left == null && node.right == null)
			System.out.print(node.getdataString()+ " ");
		displayNodes(node.left);
		displayNodes(node.right);
	}
	public static void printCombinations(int[] array){
		Node root = createNode(0,"",array);
		displayNodes(root);
	}
}
class Node{
	String dataString;
	Node left,right;
	Node(String dataString){
		this.dataString = dataString;
	}
	public String getdataString(){
		return dataString;
	}
}