package com.facebook;
import java.util.*;
import java.io.*;
public class UniqueSubset {
	private static String input;
	private static ArrayList<String> output = new ArrayList<String>();
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		input = br.readLine();
		output = subsets(input);
		for(String s : output)
			System.out.print(s + " ");
	}
	public static ArrayList<String> subsets(String str){
		ArrayList<String> subset = new ArrayList<String>();
		if(str.length() == 1){
			subset.add(str);
			return subset;
		}
		String last = str.substring(str.length() - 1);
		String beforeLast = str.substring(str.length() - 2,str.length() - 1);	/*this is later used to check for repeats*/
		subset = subsets(str.substring(0,str.length() - 1));
		//checks if last char was equal to its previous char
		if(last.equals(beforeLast)){
			subset.add(subset.get(subset.size() - 1) + last);	/*this will be only unique subset that a repeat can produce*/
			return subset;
		}
		else{						
			subset.add(last);
			int size = subset.size();
			for(int i = 0;i < size - 1; i++)	/*add the last character for each subset produced in the previous iteration*/
				subset.add(subset.get(i) + last);
			return subset;
		}
	}
}
