package com.facebook;
/*
 * Given two numbers, each in a linked list, MSB at the head, multiply the numbers in an efficient 
 * time and space without reversing the linked list. Efficiency = O(M + N) where, N is digits in
 * first number and N is the digits in the second number
 */
import java.util.*;
public class MultiplyNumInLinkedList {
	
	public static void main(String[] args){
		LinkedList<Integer> l1 = new LinkedList<Integer>();
		LinkedList<Integer> l2 = new LinkedList<Integer>();
		l1.add(4);
		l1.add(5);
		l1.add(6);
		l2.add(3);
		l2.add(2);
		l2.add(1);
		int product = multiply(l1,l2);
		System.out.println(product);
	}
	public static int multiply(LinkedList<Integer> l1, LinkedList<Integer> l2){
		Iterator<Integer> iterator = l1.listIterator();
		String str = "";
		int num1;
		int sum = 0;
		//Traverse the first linkedLinked and append each node's value to a string
		while(iterator.hasNext()){
			str = str + iterator.next();
		}
		//Covert the string to num1 to get the number stored in the first list
		num1 = Integer.parseInt(str);
		iterator = l2.listIterator();
		//For each number in second list, multiply it with num1 and add the previous sum * 10
		while(iterator.hasNext()){
			sum = sum * 10 + (num1 * iterator.next());
		}
		return sum;
	}
}
