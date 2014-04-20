package com.facebook;
/*
 * Given an absolute path e.g., "/usr/bin/mail" and a relative path e.g., "../../../", find the absolute path 
 * created from the combination of the first tow paths. In the example string, the answer is /etc/abc
 * Example:
 */
import java.util.*;
public class AbsolutePath {
	public static void main(String[] args){
		String absolute = "/user/bin/mail";
		String relative = "../../../etc/xyz/../abc";
		String path = findPath(absolute,relative);
		if(path == null)
			System.out.println("Invalid path");
		else
			System.out.println(path);
	}
	/*
	 * Returns 
	 */
	public static String findPath(String absolute,String relative){
		String[] abs = absolute.split("/");
		String[] rel = relative.split("/");
		String result = "";
		Stack<String> stack = new Stack<String>();
		for(String s : abs){
			if(!s.equals(""))
				stack.push(s);
		}
		for(String s : rel){
			if(s.equals("..")){
				if(stack.isEmpty())
					return null;
				stack.pop();
			}
			else
				stack.push(s);
		}
		while(!stack.isEmpty())
			result = "/" + stack.pop() + result;
		return result;
	}
}
