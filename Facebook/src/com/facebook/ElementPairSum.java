package com.facebook;
import java.io.*;
import java.util.*;
public class ElementPairSum{
private static int[] array;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the number of elements");
        int size = Integer.parseInt(br.readLine());
        array = new int[size];
		System.out.println("Enter the numbers in sorted order");
		StringTokenizer tokenizer = new StringTokenizer(br.readLine());
		int i = 0;
		while(tokenizer.hasMoreTokens()){
			array[i++] = Integer.parseInt(tokenizer.nextToken());
		}
		System.out.println("Enter the sum");
		int sum = Integer.parseInt(br.readLine());
		findElements(array,sum);
	}
	public static void findElements(int a[], int sum){
		int low = 0;
		int high = a.length - 1;
		while(low < high){
			if(a[low] + a[high] == sum){
				System.out.println("Elements are "+ a[low] + " & " + a[high]);
				return;
			}
			if(a[low] + a[high] > sum)
				high--;
			else
				low++;
		}
		System.out.println("Element not found");
	}
}
